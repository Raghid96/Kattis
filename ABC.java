
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;


public class ABC {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        int[] nums = new int[3];
        for (int x = 0; x < 3; x++)
            nums[x] = sc.nextInt();
        sc.nextLine();
        Arrays.sort(nums);
        
        HashMap<Character, Integer> pairup = new HashMap<>();
        for (int x = 0; x < 3; x++)
            pairup.put((char) ('A' + x), nums[x]);
        for (char c : sc.nextLine().toCharArray())
            System.out.print(pairup.get(c) + " ");
        sc.close();
    }
		
	
	
}
