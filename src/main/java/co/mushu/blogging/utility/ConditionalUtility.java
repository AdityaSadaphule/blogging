package co.mushu.blogging.utility;

import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.stereotype.Service;
import sun.security.krb5.EncryptedData;

import java.beans.Encoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
public class ConditionalUtility {
    public String isPasswordValid(String password){
        if(password.length() < 8) return "password length should be at least of 8 character";
        boolean digit = false;
        boolean alpha = false;
        boolean capital = false;
        boolean special = false;
        boolean space = false;
        for(char ch : password.toCharArray()){
            if(Character.isUpperCase(ch)) capital = true;
            else if(Character.isAlphabetic(ch)) alpha = true;
            else if(Character.isDigit(ch)) digit = true;
            else if(Character.isSpaceChar(ch)) space = true;
            else if(ch == '*'||ch=='\''||ch =='\"' || ch == '\\' || ch == ' ') return "You cannot use ' ',''','\"','\\' and '*' in your password.";
            else special = true;
        }
        if(!digit || !alpha || !capital || !special){
            List<String> list = new ArrayList<>();
            if(!digit){
                list.add("Digit");
            }
            if(!alpha){
                list.add("Alphabet");
            }
            if(!capital){
                list.add("Uppercase");
            }
            if(!special){
                list.add("Special Character(e.g %,!,@,$,\",.)");
            }
            StringBuilder sb = new StringBuilder("password should contain at least 1 ");
            boolean first = false;
            for(String cmt : list){
                if(!first) sb.append(cmt);
                else sb.append(", ").append(cmt);
                first = true;
            }
            sb.append(". ");
            if(space){
                sb.append("password should not contain space.");
            }
            return new String(sb);
        }else if(space){
            return "password should not contain space.";
        }
        return "valid";
    }

    public Boolean isValidUsername(String username){
        for(int i=0;i<username.length();i++){
            char ch = username.charAt(i);
            if(ch == '\'' || ch == '\"' || ch == '\\' || ch == '*') return false;
        }
        return true;
    }

    public String generateBlogId(String username,String subject){
        String AlphaNumericString = "cdEFefgMNhilmnopqrstABu6vyzCDkHIJwxKLOabPQR234STUVYZ01Gj578WX9";
        AlphaNumericString = AlphaNumericString.replace(' ','_');
        StringBuilder sb = new StringBuilder(40);

        for (int i = 0; i < 40; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
