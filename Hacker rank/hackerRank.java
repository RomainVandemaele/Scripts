import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hackerRank {

    /**Number of words in string formated like "saveChangesInTheEditor" */
    static int camelcase(String s) {
        int count=1;
        for(int i=0;i<s.length();++i) {
            String l1 = s.substring(i,i+1).toLowerCase();
            String l2 = s.substring(i,i+1);
            System.out.println(l1+" "+l2);
            if(l1.compareTo(l2)!=0) {
                count+=1;
            }
        }
        return count;
    }

     
     static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int missingChar = 0;

        Pattern p1 = Pattern.compile("0|1|2|3|4|5|6|7|8|9");   // the pattern to search for
        Pattern p2 = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]");
        Pattern p3 = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
        Pattern p4 = Pattern.compile("[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\+]");

        Matcher m = p1.matcher(password);
        if(!m.find()) {missingChar++;}

        m = p2.matcher(password);
        if(!m.find()) {missingChar++;}

        m = p3.matcher(password);
        if(!m.find()) {missingChar++;}

        m = p4.matcher(password);
        if(!m.find()) {missingChar++;}

        if(missingChar+password.length() < 6) {
            missingChar += 6 - (missingChar+password.length());
        }
       
        return missingChar;
    }


    static String caesarCipher(String s, int k) {
        k=k%26;
        String cipher = "";
        for(int i=0;i<s.length();i++) {
            int value = (int) s.charAt(i);
            //System.out.println(value);
            if( 97 <= value && value <= 122) { //lower case letter
                value+=k;
                if(value > 122) {
                    value = 96 + (value-122);
                }
            }else if( 65 <= value && value <= 90) { //Upper case letter
                value+=k;
                if(value > 90) {
                    value = 64 + (value-90);
                }
            }
            //System.out.println(value);
            char c = (char) value;
            cipher += c;
        }
        return cipher;

    }

    public static void main(String[] args) {
        String res = caesarCipher("middle-Outz", 2);
        System.out.println(res);
    }
}