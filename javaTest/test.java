//package javaTest;

//import javaTest.Point;
import java.util.Random;
import java.lang.Thread;

import java.io.File;  // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors


public class   test {

    public static void files() {
        try {

            File myObj = new File("filename.txt"); //only create file and get info and delete
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
            //myObj.delete();

            FileWriter f = new FileWriter("filename.txt"); //reset file if exists
            f.write("ok\n");
            f.write("ok2\n");
            f.close();

            Scanner scan = new Scanner(myObj);


            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }
            scan.close();
            System.out.println("File size in bytes " + myObj.length());
            myObj.close();

        }catch(IOException e) {
            System.out.println("Error with file manipulation");
            e.printStackTrace();
        }
    }

    public  static void doSomething ( Point arg1 , Point arg2 ) {
        arg1 . x = 100;
        arg1 . y = 100;
        Point temp = arg1 ;
        arg1 = arg2 ;
        arg2 = temp ;
    }

    public static <U , V> U doSomethingElse ( U u , V v ) {
        return u;
    }

    enum Days { Monday , Tuesday , Wednesday , Thursday ,Friday , Saturday , Sunday }

    public static void main(String[] args) throws Exception{
        //Base a = new Base();
        Derived  b = new Derived();
        //a.echo();
        b.echo();

        //System.out.println(doSomethingElse(4, "ok"));



        Days today = Days.Sunday ;
        if ( today == Days.Sunday ) {
           System . out . println ( " Happy Sunday !" ) ;
           //States st1 = States . Ready , st2 = States . Processing ;
        }


        int n = 10;
        Integer M[][] = new Integer[n][];
        for(int i=0;i<n;i++){
            M[i] = new Integer[i+1];
            for(int j=0;j<i+1;j++) {
                M[i][j] = 1;
            }
        }

        Point pnt1 = new Point ( 0 , 0 ) ;
        Point pnt2 = new Point ( 0 , 0 ) ;
        doSomething(pnt1,pnt2);


        try {
            System.out.println("P1: "+pnt1.x+","+pnt1.y);
            System.out.println("P2: "+pnt2.x+","+pnt2.y);
        }catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }catch(NullPointerException e) {
            throw new Exception("null");
        }


        Random r = new Random();
        r.nextInt(10);

        //files();



    }

}

abstract class  Base {
    public abstract void  echo ( ) ; //one abstract fct => class abstract => no instances
}

class Derived extends Base {
    public void echo ( ) { System . out . println ( "Derived" ) ; }
 }

class Base2 {
    public final void echo ( ) { //cannot be override
        System . out . println ( "Base" ) ;
    }
}

class Derived2 extends Base2 {
    //public void echo() {}
    public void echo(int x) {

    }
}
