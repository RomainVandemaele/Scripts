import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class hackerRank {

   

    static String highestValuePalindrome(String s, int n, int k) {
        int changeTD = 0;
        int extra = 0;
        String c = "";
        Vector<Integer> indexes = new Vector<Integer>();
        for(int i=0;i<n/2;++i) {
            if(s.charAt(i)!=s.charAt(n-1-i)) {
                int c1 = (int) s.charAt(i) - 48;
                int c2 = (int) s.charAt(n-1-i) - 48;
                if(c1!=9 && c2!=9) {
                    indexes.add(i);
                    if(c1 > c2) {
                        c+=s.charAt(i);
                        //c = c.substring(0,n-1-i) + s.charAt(i) + c.substring(n-i);
                    }else {
                        c+=s.charAt(n-1-i);
                        //c = c.substring(0,i) + s.charAt(n-1-i) + c.substring(i+1);
                    }
                }else if(c1==9 || c2==9) {
                    c +="9";
                    //c = c.substring(0,i) + "9" + c.substring(i+1,n-1-i) + "9" + c.substring(n-i);
                }
                //indexes.add(i);
                changeTD++;
            }else{
                c+=s.charAt(i);
            }
        }
        extra =  k- changeTD;
        if(extra < 0) {
            return "-1";
        }
        //System.out.println("extra : "+extra);
        int kI = 0;
        int i=0;
        while(extra > 0 && i<n/2) {
            if(c.charAt(i)!='9') {
                if(kI < indexes.size() && i==indexes.get(kI)) {
                    c = c.substring(0,i) + "9" + c.substring(i+1);
                    extra--;
                    kI++;
                }else if(extra >= 2 ) {
                    c = c.substring(0,i) + "9" + c.substring(i+1);
                    extra-=2;
                }
            }
            i++;
        }
        
        if(n%2==1) { //number in the middle
            if(extra > 0) {
                c += "9"; 
            }else {
                c += s.charAt(n/2+1);
            } 
        }
        System.out.println(c.length()+ " "+ n/2);
        for(int j=0;j<n/2;++j) {
            c += c.charAt(n/2-1-j);
        }
        System.out.println(c+"\n");
        return c;
    }

    public static void main(String[] args) {

        highestValuePalindrome("5", 1, 1);
        highestValuePalindrome("932239", 6, 2);
        highestValuePalindrome("777", 3, 0);
        
        /*for(int j=0;j<res.length;++j) {
            System.out.println(res[j]);
        }*/
        
    }
}