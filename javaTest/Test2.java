

public class Test2 {
    public static void main(String[] args) {
        //269656199 494630864 = 494630864
        //81933645 201678107 = 2
        long r= xorSequence(81933645,201678107 );
        System.out.println(r);
    }

    static long xorSequence(long l, long r) {
        long size = r - l + 1;
        long res = 0;

        long k = l%4;
        long startIndex = l+2; 
        long endIndex = r;

        if(size%2==0) { 
            res = 0;
            startIndex = l+1;
        }else if(k==0) { // l -> 1 -> l + 1 -> 0 -> ...
            res = l;
        }else if(k== 1) {
            res = 1;
        }else if(k== 2) {
            res = l+1;
        }else if(k== 3) {
            res = 0;
        }

        
        if(size%2==0) { //everythong before l cancelled 
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

        long mod[] = { endIndex+0 ,2L,endIndex+2,0L  };
        res = res ^ mod[ (int) k];

        /*if(k==0) { // l -> 2 -> l + 2 -> 0 -> ...
            res = res ^ endIndex;
        }else if(k== 1) {
            res = res ^  2;
        }else if(k== 2) {
            res = res ^ (endIndex + 2);
        }else if(k== 3) {
            res = res ^ 0;
        }*/


        return res;

    }
}