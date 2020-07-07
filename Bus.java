import java.util.Arrays;
import java.util.Scanner;


public class Bus {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num_cases = sc.nextInt();
		
		int[] arr = new int[num_cases];
		
		for(int x = 0; x < num_cases; x++) {
			
			int stop_x = sc.nextInt(); // Number of stops 
			
			double sum = 0;
			
			for(int i = 0; i< stop_x ; i++) {
				sum = 2*(sum + 0.5);
			}
			
			arr[x] = (int) sum;
		}
		
		System.out.println(Arrays.toString(arr));
		sc.close();
		
	}
	

}
