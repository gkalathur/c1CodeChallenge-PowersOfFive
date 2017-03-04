import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public Solution(){
    }

        public synchronized int getMin(String s){
        StringBuffer sbBinary = new StringBuffer(s);
        long [] resultsArray = new long [sbBinary.length() + 1] ;
       
        if(!s.startsWith("0") && hasPowerOfFives(Long.parseLong(sbBinary.toString(), 2))) {
                   return 1;
        }
        resultsArray[0] = 0;
        int startIndex = 1, endIndex;
        while(startIndex <= sbBinary.length()) {
              endIndex = startIndex;
              resultsArray[startIndex] = Integer.MAX_VALUE;
              while(endIndex >= 1) {
                     if(sbBinary.charAt(endIndex - 1) == '0') {
                            endIndex --;
                            continue;
                     }
                     if (hasPowerOfFives(Long.parseLong(sbBinary.substring(endIndex - 1, startIndex), 2))) {
                            resultsArray[startIndex] = Math.min(resultsArray[startIndex], resultsArray[endIndex - 1] + 1) ;                       
                          }
                     endIndex --;
              }
              startIndex ++;
        }

     return resultsArray[sbBinary.length()] == Integer.MAX_VALUE ? -1 : (int)resultsArray[sbBinary.length()] ;    		 
    }
    		 
    public boolean hasPowerOfFives(long num) {
		boolean result = false;
		if(num!= 0) {
			// Natural Log base 10 method to determine the exponent
			int exponent = (int)(Math.log(Long.valueOf(num).doubleValue())/Math.log(Long.valueOf(5l).doubleValue())); 
			result = Math.pow(5,exponent) == num ? true : false;
		}
		return result;
	}



}