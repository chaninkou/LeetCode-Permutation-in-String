package permutation;

public class Main {
	public static void main(String[] args){
		// Need to understand this problem better
		
		String input1 = "ab";
		
		String input2 = "eidbaoo";
		
		System.out.println("input1: " + input1 + " input2: " + input2);
		
		CheckSubStringPermutationFunction solution = new CheckSubStringPermutationFunction();
		
		System.out.println("Output: " + solution.checkInclusion(input1, input2));
			
	}
}
