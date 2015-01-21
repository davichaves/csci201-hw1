import java.util.Scanner;
import java.util.StringTokenizer;


public class Menu {
	private static Scanner s;
	private static float [] arrayInput;

	private static void getInput(int n){
		if(n==1){
			System.out.println("Enter values in the following format: <x,y,z>");
			String myInput = s.next();
			try {
				checkingInput(myInput);
			} catch (BadInputException bie) {
				System.out.println(bie.getMessage());
			}
			for(int i = 0; i < 3; i++){
				System.out.println(arrayInput[i]);
			}
//			System.out.println("Is this a Vector or a Point?");
		} else {
			System.out.println("Enter values in the following format: <x,y,z>");
//			System.out.println("Is this a Vector or a Point?");
		}
	}
	private static void checkingInput(String input) throws BadInputException {
		input = input.substring(1, myInput.length()-1);
		StringTokenizer tokenizer = new StringTokenizer(input, ",");
		int numberOfTokens = tokenizer.countTokens();
		if(numberOfTokens > 3){
			throw new BadInputException();
		}
		String [] myInputs = new String[numberOfTokens];
		for(int i = 0; i<numberOfTokens; i++){
			myInputs[i] = tokenizer.nextToken();
			arrayInput[i] = Float.parseFloat(myInputs[i]);
		}
	}
	
	public static void main(String [] args){
		s = new Scanner(System.in);
		arrayInput = new float[3];
		while(true){
			System.out.println("1: Change value of null\n2: Change value of null");
			System.out.println("3: Add the objects.\n4: Subtract the objects.");
			System.out.println("5: Find the angle between the objects.\n6: Quit");
			System.out.print("What do you want to do? ");
			int option = s.nextInt();
			if(option == 6){
				break;
			}
			if(option == 1 || option == 2){
				getInput(option);
			}
		}
		System.out.println("Bye!");
	}
}