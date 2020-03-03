import java.math.*;

public class Test2 {
    public static void main(String[] args) {
        //269656199 494630864 = 494630864
        //81933645 201678107 = 2
        //long r= xorSequence(81933645,201678107 );
        //System.out.println(r);
        //System.out.println(count);


        powerSum(10,2);
        //int max =  (int) Math.ceil(  Math.pow((double)6,1.0/2)  );
        System.out.println(count);
    }

    static int count = 0;
    static void powerSum(int X, int N) {
        if(X==0) {
            count++;
        }else {
            int max =  (int) Math.ceil(  Math.pow((double)X,1.0/N)  );
            System.out.println(X+ " "+max);
            for(int i=1;i<=max;i++) {
                int r = (int) Math.pow((double) i,N);
                if(X-r >= 0) {
                    powerSum(X-r,N);
                }
                
            }
        }
        
        //return count;
    }

    static long xorSequence(long l, long r) {
        long size = r - l + 1;
        long res = 0;

        long k = l%4;
        long startIndex = l+2; 
        long endIndex = r;

        long mod[] = { l ,1L,l+1,0L  };
        if(size%2==0) { 
            res = 0;
            startIndex = l+1;
        }else {
            res = mod[(int)k];
        }

        
        if(size%2==0) { //everything before l cancelled 
            if( (l%2) == (r%2) ) { //lastIndex = r-1
                endIndex = r-1;
            }
            //for(long i=l+1;i<=r;i+=2) {res = res ^ i;}
        }else {
            if( (l%2) != (r%2) ) { //lastIndex = r-1
                endIndex = r-1;
            }
            //for(long i=l+2;i<=r;i+=2) {res = res ^ i;}
        }
        k = ( (endIndex - startIndex + 1)/2) %4;

        long[] mod2 = { endIndex+0 ,2L,endIndex+2,0L  };
        res = res ^ mod2[ (int) k];
        return res;
    }
}