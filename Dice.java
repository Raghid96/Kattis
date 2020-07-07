import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);		
		Dice dice = new Dice();
		
		int diceOne = sc.nextInt();
		int diceTwo = sc.nextInt();
		
		if (diceOne == diceTwo) {
			
			System.out.println(dice.maxProbabilityNumbers(diceOne));
			
		} else {
			
			int[] highProbNum = dice.maxProbabilityNumbers(diceOne, diceTwo);
			int size = highProbNum.length;
			
			for(int i = 0; i< size ; i++) {
				System.out.println(highProbNum[i]);
			}
		}
		sc.close();
	}
	
	
	private int maxProbabilityNumbers(int diceOne) {
		return diceOne + 1;
	}
	
	
	private int[] maxProbabilityNumbers(int diceOne, int diceTwo) {
		
			int diff = Math.abs(diceOne - diceTwo) + 1;
			int[] highProbNum = new int[diff];
			int min = findMin(diceOne, diceTwo);
		
			for(int i = 0; i< diff ; i++) {
				
				highProbNum[i] = min + 1 + i;
				
			}
			return highProbNum;
	}
	
	
	private int findMin(int diceOne, int diceTwo) {
		int min;
		
		if(diceOne > diceTwo) {
			min = diceTwo;
		}else {
			min = diceOne;
		}
		
		return min;
	}
	

}
