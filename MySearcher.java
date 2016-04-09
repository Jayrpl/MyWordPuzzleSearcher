package findwords;

import java.util.ArrayList;

/**
 * Your implementation of the coursework.
 * This is the only source file you should modify, and the only one you
 * should submit.
 */
public class MySearcher implements Searcher {

    @Override
    public boolean equal(char[] s, char[] t, int n) {
       boolean equal = true;
        // invariant: 0 <= i <= s.length and s[0... s.length]
       if (s.length < n || t.length < n) {
           if (s.length == t.length) {
               for (int i = 0; i < s.length; i++) {
                   if (s[i] != t[i]) {
                       equal = false;
                   }
               }
           }else {
               equal = false;
           }
       }else {
           // invariant: 0 <= i <= n and char[0...n]
           for (int i =0; i < n; i++) {
               if (s[i] != t[i]){
                   equal = false;
                   }
               }
           }
           return equal;
       }
    


    @Override
    public boolean lessThan(char[] s, char[] t, int n) {
        // invariant: 0 <= i <= n and char[0...n]
        for (int i = 0; i < n; i++){
             if (s.length > t.length)
             {
                 if(t.length == i )
                 {
                     return false;
                 }
             }
             if (s.length <= t.length) {
                 if (t.length == i){
                     return false;
                 }
             }
           if (t[i]<s[i])
           {
               return false;
           }
               if (s.length <n)
               {
                   if (t.length!=s.length)
                   {
                       if((s.length -1) ==i)
                       {
                           return true;
                       }
                   }
               }
    if(s[i] < t[i])
    {
        return true;
    }
    if (s.length < t.length && s[i] < t[i] )
    {
        return true;
    }
}
    return false;
    }
    


    @Override
    public int findPrefix(Dictionary d, char[] w, int n) {
      {
       int high = d.size() - 1;
       int low = 0;
       int mid;
       // invariant: 0<= low <= high and w[0..low+1] < mid <= w[high-1..n-1]
       while (low<=high){
           mid = (low + high) / 2;
           if(this.lessThan(d.getWord(mid), w, n)){
               low = mid + 1;
               
           } else{
               high = mid - 1;
           }
       }
    return low;
    }     
                
    }
    

    @Override
    public ArrayList<char[]> findMatches(Dictionary d, char[] clue) {
        ArrayList<char[]> matches = new ArrayList<>();
        int k = 0;
        // invariant: 0 <= abc <= clue.length and clue[0...clue.length]
         for (int m = 0; m 
                 < clue.length; m++){
            if(clue[m] != '.'){
                k++;
                      }else{
                 break;
     }
        }
        
        int h = findPrefix(d, clue, k);
        // invariant: 0 <= k <= b <= d.size() and d[0...d.size()]
        for 
                (int b = h; b < d.size(); b++) {
            boolean 
                    y = true;
     if (this.equal(d.getWord(b), clue, k)) {
                              char[] t = d.getWord(b);
                if 
                        (t.length == 
                        clue.length) {
                    for 
                            (int abc = 0; abc < clue.length; abc++) {
         if (clue[abc] != '.') {
                            
                                   if (t[abc] != clue[abc]) {
                                y = false;
                                break;
                            }
               }
       }
                    
                    if (y){
                        matches.add(t);
                    }
       }
                       }else{
         break;
            }
                 }

        return matches;
          }    
}
    

