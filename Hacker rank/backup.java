public class backup {
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


    static String pangrams(String s) {
        Boolean[] letters = new Boolean[26];
        for(int i=0;i<letters.length;++i) {
            letters[i] = false;
        }

        for(int j=0;j<s.length();++j) {
            int l = (int) s.substring(j, j+1).toLowerCase().charAt(0);
            //System.out.println(l);
            if(l>=97 && l <=122) { //not space
                l -=97;
                letters[l] = true;
            }
            
        }

        for(int i=0;i<letters.length;++i) {
            if(letters[i] == false) {
                //System.out.println(i);
                return "not pangram";
            }
        }
        return "pangram";

    }

    static String[] weightedUniformStrings(String s, int[] queries) {
        String res[] = new String[queries.length];
        Vector<Integer> weights = new Vector<Integer>();
        Integer wus = 0;
        int min=100,max=0;
        for(int i=0;i<s.length();++i) {
            int w = (int) s.charAt(i);
            w -=96; //weight of the letter
            if(i >0 && s.charAt(i)==s.charAt(i-1)) {
                wus += w;
            }else {
                wus=w;
            }
            weights.add(wus);
            System.out.println(wus);
            if(wus > max) {
                max=wus;
            }
            if(wus < min) {
                min=wus;
            }
        }
        System.out.println(min+" "+max);
        for(int j=0;j<queries.length;++j) {
            if(queries[j] > max || queries[j] < min) {
                res[j]="No";
            }else {
                if(weights.contains(queries[j]) ) {
                    res[j]="Yes";
                }else {
                    res[j]="No";
                }
            }
        }
        return res;
    }

    static void separateNumbers(String s) {
        int length = 1;
        int n=s.length();
        Boolean found = false;
        while (length <= ( (int) n/2) && !found) {
            Boolean seq = true; //sequence exists
            int i=0;
            Long startNum=0L,nextNum=0L;
            while(seq && i < n) {
                if(i==0) {
                    String numS = s.substring(i, i+length);
                    if(numS.charAt(0)=='0') {
                        seq = false;
                    }else {
                        Long num = Long.parseLong(numS);
                        startNum = num;
                        nextNum = startNum + 1;
                    }
                    i+=length;    
                }else {
                    String nextNumS = Long.toString(nextNum);
                    String numS ="0";
                    if(i+nextNumS.length() <= n ) {
                        numS = s.substring(i, i+nextNumS.length());
                    }else {
                        numS = s.substring(i, i+1);
                    }
                    
                    if(nextNumS.compareTo(numS)!=0) {
                        seq = false;
                    }
                    i += nextNumS.length();
                    nextNum++;
                }
            }
            found = seq;
            if(found) {
                System.out.println("YES "+startNum);
            }
            length++;
        }
        if(!found) {
            System.out.println("NO");
        }
        
        
    }
    
    static String funnyString(String s) {
        int i = 0;
        int n = s.length();
        Boolean isFunny = true;
        if(n==2) {
            return "Funny";
        }
        while(i < n/2+1 && isFunny) {
            int ascii1 = (int) s.charAt(i);
            int ascii2 = (int) s.charAt(i+1);

            int ascii3 = (int) s.charAt(n-1-i);
            int ascii4 = (int) s.charAt(n-1-i-1);

            isFunny = Math.abs(ascii1-ascii2) == Math.abs(ascii3-ascii4);  
            
            i++;
        }
        if(isFunny) {
            return "Funny";
        }else {
            return "Not Funny";
        }
    }
    
    static int anagram(String s) {
        if(s.length()%2==1) {
            return -1;
        }
        int n = s.length();
        String s1 = s.substring(0,n/2);
        String s2 = s.substring(n/2);
        Boolean[] match = new Boolean[n/2];
        for(int i=0;i<match.length;++i) {
            match[i] = false;
        }

        for(int j=0;j<n/2;++j) {
            int k=0;
            Boolean found = false;
            while(k<n/2 && !found) {
                if(s1.charAt(j)== s2.charAt(k) && match[k]==false) {
                    found = true;
                    match[k] = true;
                }
                k++;
            }
        }

        int count = 0;
        for(int i=0;i<match.length;++i) {
            if ( match[i] == false ) {
                count++;
            }
        }
        //System.out.println(s1+" "+s2);
        return count;
    }

    static int palindromeIndex(String s) {
        int i = 0,j=s.length()-1;
        int delIndex = -1;
        int oldI = 0,oldJ=0;
        Boolean reversed = false;
        while(i<j) {
            if( s.charAt(i) != s.charAt(j)  ) {
                if(delIndex!=-1) {
                    if(reversed) {return -1;}
                    else {
                        i=oldI;
                        j=oldJ;
                        reversed = true;
                    }
                }

                if(s.charAt(i) == s.charAt(j-1) &&  s.charAt(i+1) != s.charAt(j) ) { //del j
                    delIndex = j;
                    j--;
                }else if(s.charAt(i) != s.charAt(j-1) && s.charAt(i+1) == s.charAt(j)) {
                    delIndex = i;
                    i++;
                }else if(s.charAt(i) == s.charAt(j-1) && s.charAt(i+1) == s.charAt(j)) {
                    //System.out.println(delIndex + " " + i +" -1");
                    oldI = i;
                    oldJ = j;
                    if(!reversed) {
                        delIndex=j;
                        j--;
                    }else {
                        delIndex=i;
                        i++;
                    }
                }else {
                    return -1;
                }
            }
            i++;
            j--;

        }
        //System.out.println(delIndex);
        return delIndex;
    }

    public static int max = 0;
    public static int min = 100000;

    public static void getHealth(String[] genes, int[] health,int first,int last,String d) {
        int h = 0;
        int n = d.length();
        for(int i=first;i<=last;++i) {
            String gene = genes[i];
            int l = gene.length();
            int j=0;
            //int l=0;
            while (j <= n-l) {
                if(gene.charAt(0)==d.charAt(j)) {
                    int m=-1;
                    //oldJ = j;
                    int k = 1;
                    while(k<l && gene.charAt(k)==d.charAt(j+k)) {
                        if(m==-1 && d.charAt(j+k)==gene.charAt(0)) {m=j+k;}
                        ++k;
                    }
                    if(k==l) { h +=health[i];}

                    if(m==-1) {
                        j += k-2;
                    }else {
                        j = m-1;
                    }
                }
                j++;
            }

        }
        if(h > max) {
            max = h;
        }
        if(h < min) {
            min = h;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void mainHealth(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] genes = new String[n];

        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String genesItem = genesItems[i];
            genes[i] = genesItem;
        }

        int[] health = new int[n];

        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int healthItem = Integer.parseInt(healthItems[i]);
            health[i] = healthItem;
        }

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");

            int first = Integer.parseInt(firstLastd[0]);

            int last = Integer.parseInt(firstLastd[1]);

            String d = firstLastd[2];
            getHealth(genes,health,first,last,d);
        }
        System.out.println(min+" "+max);
        scanner.close();
    }

    /*Check if each letter either has the same frequency by removing max one letter */
    static String isValid(String s) {
        Integer[] freq = new Integer[26];
        for(int i=0;i<freq.length;++i) {
            freq[i] = 0;
        }
        int maxFreq=0;
        for(int i=0;i<s.length();++i) {
            int index = ( (int) s.charAt(i) ) - 97;
            freq[index]++;
            if(freq[index] > maxFreq) {
                maxFreq = freq[index];
            }
        }

        int countDiff = 0,countLetter=0;
        Boolean valid = true;
        for(int i=0;i<freq.length;++i) {
            
            if(freq[i]!=0) {
                System.out.println(i+" : "+freq[i]);
                if(maxFreq - freq[i] > 1) {
                    valid = false;
                    countDiff++;
                }else if(maxFreq - freq[i] == 1) {
                    countDiff++;
                }
                countLetter++;
            }
        }
        System.out.println(valid+ " " + countDiff + " "  + maxFreq);
        if( (valid && (countDiff==0 || countDiff==countLetter-1 || countDiff==1) ) || (!valid && countDiff==1) ) {
            return "YES";
        }else {
            return "NO";
        }

    }

    static String highestValuePalindrome(String s, int n, int k) {
        int changeTD = 0;
        int extra = 0;
        String c = s;
        Vector<Integer> indexes = new Vector<Integer>();
        for(int i=0;i<n/2;++i) {
            if(s.charAt(i)!=s.charAt(n-1-i)) {
                int c1 = (int) s.charAt(i) - 48;
                int c2 = (int) s.charAt(n-1-i) - 48;
                if(c1!=9 && c2!=9) {
                    indexes.add(i);
                    if(c1 > c2) {
                        c = c.substring(0,n-1-i) + s.charAt(i) + c.substring(n-i);
                    }else {
                        c = c.substring(0,i) + s.charAt(n-1-i) + c.substring(i+1);
                    }
                }else if(c1==9 || c2==9) {
                    c = c.substring(0,i) + "9" + c.substring(i+1,n-1-i) + "9" + c.substring(n-i);
                }
                //indexes.add(i);
                changeTD++;
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
                    c = c.substring(0,i) + "9" + c.substring(i+1,n-1-i) + "9" + c.substring(n-i);
                    extra--;
                    kI++;
                }else if(extra >= 2 ) {
                    c = c.substring(0,i) + "9" + c.substring(i+1,n-1-i) + "9" + c.substring(n-i);
                    extra-=2;
                }
            }
            i++;
        }
        
        if(extra >=1 && c.length()%2==1) { //number in the middle
            c = c.substring(0,n/2) + "9" + c.substring(n/2+1) ;
        }
        System.out.println(c);
        return c;
      
    }
    

    public static void main(String[] args) {
        
    }

}