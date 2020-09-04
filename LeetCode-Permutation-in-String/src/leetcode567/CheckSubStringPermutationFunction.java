package leetcode567;

public class CheckSubStringPermutationFunction {
	// Permutation is ab = ab or ba
    public static boolean checkInclusion(String s1, String s2) {
    	
    	// Make sure s1 length is not greater than s2, since we want to check if s2 contain all of s1
    	if(s1.length() > s2.length()){
    		return false;
    	}
    	
    	// Since it only contains lower case letters and order does matter so we don't use hashset
    	int[] char_counts = new int[26];
    	
    	// Count up to the s1 length
    	for(int i = 0; i < s1.length(); i++){
    		char_counts[s1.charAt(i) - 'a']++;
    		char_counts[s2.charAt(i) - 'a']--;
    	}
    	
    	// Checking right away if s2 already contain all of s1
    	if(allZeros(char_counts)){
    		return true;
    	}
    	
    	// As the i continue, subtract the count as you go
    	// As the i - s1.length() continue, add the count as you go
    	for(int i = s1.length(); i < s2.length(); i++){
    		// Mark as visited
    		char_counts[s2.charAt(i) - 'a']--;
    		
    		// This is revisiting
    		char_counts[s2.charAt(i - s1.length()) - 'a']++;
    		
    		// Since we want substring
        	// Checking currently if s2 already contain all of s1
        	if(allZeros(char_counts)){
        		return true;
        	}
    	}
    	
    	// Return false when s2 does not contain all of s1 since the array need to be all zero
    	return false;
    }
    
    // A method that return false if any of array is not zeroes, other wise true
    private static boolean allZeros(int[] char_counts){
    	for(int i = 0; i < 26; i++){
    		if(char_counts[i] != 0){
    			return false;
    		}
    	}
    	
    	return true;
    }
}
