import java.io.*;
//import java.lang.FdLibm.Pow;
import java.math.*;

public class t {

  public static void main(String[] arg) {
    long x = (long) 562949953421312L;
    String winner = counterGame(x);
    System.out.println(winner);
    /*System.out.println(toBinary(x)+" " + x); 
    String s = toBinary(x);
    long power2  = (long) Math.pow(2,s.length()-1);
    System.out.println("Power2 : " + power2);*/
  }

  public static String counterGame(long n) {
    int turn = -1;
    boolean mul = false; 
    while(n > 1) {
        if(!mul) {
            String b = toBinary(n);
            long power2  = (long) Math.pow(2,b.length()-1);
            //System.out.println(n+ "  " + b);
            System.out.println("Power2 : " + power2);
            if(n==power2) { //n is a power of two
                mul=true;
                n = n/2;
            }else {
                n = n - power2;
            }
        }else {
            n = n/2;
        }
        
        System.out.println("New n : " + n);
        turn+=1;
      }
      if(turn%2==0) {
        return "Louise";
      }else {
          return "Richard";
      }
      
  }

  public static String toBinary(long n) {
      String bin ="";
      long temp = n/2;
      Integer res = (int) (n%2);
      while(temp > 0) {
        bin =  res.toString() + bin ;
        res = (int) (temp%2);
        temp = temp/2;
      }
      bin =  res.toString() + bin;
      return bin;
  }
}