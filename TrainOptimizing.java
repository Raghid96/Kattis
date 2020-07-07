import java.util.Scanner;

public class TrainOptimizing {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int capacity = sc.nextInt();
		int stops = sc.nextInt();
		
		TrainOptimizing train = new TrainOptimizing();
		
		if (train.isPossible(capacity, stops, sc))
			System.out.println("possible");
		else
			System.out.println("impossible");
		
		sc.close();

	}
	
	private boolean isPossible(int capacity, int stops, Scanner sc) {
		
		int passengers = 0;
		int left, enter, wait; 
		
		for(int i = 0; i < stops; i++) {
			
			left = sc.nextInt();
			enter = sc.nextInt();
			wait = sc.nextInt();
			
			if(left > passengers)
				return false;
			
			passengers += enter - left;
			
			if ((passengers != capacity && wait > 0) || (passengers > capacity) || (passengers < 0) || (i == stops - 1 && wait > 0))
				return false;
			
		}
		if (passengers != 0)
			return false;
		
		return true;	
	}	
}
