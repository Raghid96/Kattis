
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Scanner;

public class expressionSolver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String line;
		int caseCount = 1;
		expressionSolver es;

		while(!(line = sc.nextLine()).isEmpty()) {

			es = new expressionSolver(line);
			ArrayList<String> simplifiedLine = es.simplify();
			es.printSimplified(simplifiedLine, caseCount);

			caseCount = caseCount + 1;
			if (sc.hasNextLine())
				continue;
			else
				break;

		}
		sc.close();
	}

	private ArrayList<String> elementList;

	public expressionSolver(String line) {
		this.elementList = lineSplitter(line);
	}

	private static ArrayList<String> lineSplitter(String line) {

		String[] lineSplit = line.split(" ");
		ArrayList<String> elementList = new ArrayList<String>();
		int size = lineSplit.length;

		for(int i = 0; i< size; i++) {
			elementList.add(lineSplit[i]);
		}
		return elementList;
	}

	private ArrayList<String> simplify(){

		int thresholdInteger = 10;
		int loops = 1;
		
		for (int x = 0 ; x < loops ; x++) {
			for(int index = 0; index< this.elementList.size()-2 ; index++) {

				String currentIndexElement = this.elementList.get(index);

				if (currentIndexElement.equals("+") || currentIndexElement.equals("-") || currentIndexElement.equals("*")) {
					String nextIndexElement = this.elementList.get(index+1);
					String nexttIndexElement = this.elementList.get(index+2);
					
					if(ifInteger(nextIndexElement,thresholdInteger) && ifInteger(nexttIndexElement,thresholdInteger)) {
						loops++;
						this.elementList = operation(this.elementList, currentIndexElement, nextIndexElement, nexttIndexElement,index);
					}
				}
			}
		}
		return this.elementList;
	}

	private static ArrayList<String> operation(ArrayList<String> elementList, String currentIntegerElement, String nextIntegerElement, String nexttIntegerElement, int index){

		elementList.remove(index+1);
		elementList.remove(index+1);


		if(currentIntegerElement.equals("+")) {
			elementList.set(index, Integer.toString(operate(nextIntegerElement,nexttIntegerElement,"+")) + "");	
		}else if(currentIntegerElement.equals("-")) {
			elementList.set(index, Integer.toString(operate(nextIntegerElement,nexttIntegerElement,"-")) + "");		
		}else if(currentIntegerElement.equals("*")) {
			elementList.set(index, Integer.toString(operate(nextIntegerElement,nexttIntegerElement,"*")) + "");		
		}

		return elementList;
	}

	private static int operate(String elementOne, String elementTwo, String sign) {
		int result;

		if(sign == "+")
			result = Integer.valueOf(elementOne) + Integer.valueOf(elementTwo);
		else if (sign == "-")
			result = Integer.valueOf(elementOne) - Integer.valueOf(elementTwo);
		else
			result = Integer.valueOf(elementOne) * Integer.valueOf(elementTwo);
		return result;
	}

	private static boolean ifInteger(String string, int threshold) {
		
		if (string.isEmpty())
			return false;

		int len = string.length();

		if(len == 1 && string.charAt(len-1) == '-')
			return false;
		else
			for(int x = 0; x<len; x++) {
				if(Character.digit(string.charAt(x),threshold) >= 0) 
					return true;
			}
		return false;
	}

	private void printSimplified(ArrayList<String> arr, int caseCount) {
		System.out.println("Case " + caseCount + ": "  +  String.join(" ", arr));  
	}

}