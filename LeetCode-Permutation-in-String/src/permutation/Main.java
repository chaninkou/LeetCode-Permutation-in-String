package permutation;

public class Main {
	public static void main(String[] args){
		// Need to understand this problem better
		
		String input1 = "ab";
		
		String input2 = "eidbaoo";
		
		System.out.println("input1: " + input1 + " input2: " + input2);
		
		System.out.println("Output: " + checkInclusion(input1, input2));
			
	}
	
    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        // s1 length can not be bigger than s2 length
        if(s1Len > s2Len){
            return false;
        }
        
        // Since there are 26 lower case letters
        int[] count = new int[26];
        
        for(int i = 0; i < s1Len; i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        if(allZero(count)){
            return true;
        }
        
        for(int i = s1Len; i < s2Len; i++){
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1Len) - 'a']++;
            if(allZero(count)){
                return true;
            }
        }
        
        
        return false;
    }
    
    private static boolean allZero(int[] count){
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
