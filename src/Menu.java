import java.util.Scanner;
import java.util.StringTokenizer;


public class Menu {
	private static Scanner s;
	private static float [] arrayInput;
	private static boolean badInput;
	private static Object [] o = new Object[2];
	private static boolean [] objectAssigned = new boolean[2];
	
	private static void getInput(int n){  	
		do {
			System.out.print("Enter values in the following format: <x,y,z> ");
			String myInput = s.next();
			try {
				checkingInput(myInput);
			} catch (BadInputException bie) {
				badInput = true;
				System.out.println(bie.getMessage());
			}
		} while(badInput);
		for(int i = 0; i < 3; i++){
			System.out.println(arrayInput[i]);
		}
		String type;
		do {
			System.out.print("Is this a Vector or a Point? ");
			type = s.next();
			if (type.equalsIgnoreCase("point")){
				objectAssigned[n-1] = true;
				o[n-1] = new Point3D(arrayInput);
				break;
			}
			if (type.equalsIgnoreCase("vector")){
				objectAssigned[n-1] = true;
				o[n-1] = new Vector3D(arrayInput);
				break;
			}
			System.out.println("Bad input!!!");
		} while(true);
	}
	private static void checkingInput(String input) throws BadInputException {
		if(input.charAt(0) != '<') throw new BadInputException();
		if(input.charAt(input.length()-1) != '>') throw new BadInputException();
		if(input.length()<3) throw new BadInputException();
		input = input.substring(1, input.length()-1);
		StringTokenizer tokenizer = new StringTokenizer(input, ",");
		int numberOfTokens = tokenizer.countTokens();
		if(numberOfTokens > 3) {
			throw new BadInputException();
		}
		String [] myInputs = new String[numberOfTokens];
		for(int i = 0; i<numberOfTokens; i++){
			myInputs[i] = tokenizer.nextToken();
			try {
				Float.parseFloat(myInputs[i]);
			} catch(NumberFormatException e) {
				throw new BadInputException();
			}
			arrayInput[i] = Float.parseFloat(myInputs[i]);
		}
		badInput = false;
	}
	
	public static void main(String [] args){
		s = new Scanner(System.in);
		arrayInput = new float[3];
		objectAssigned[0] = objectAssigned[1] = false;
		while(true){
			for(int i = 0; i < 2; i++){
				if(objectAssigned[i]){
					System.out.println((i+1) + ": Change value of " + o[i].toString());
				} else {
					System.out.println((i+1) + ": Change value of null");
				}
			}
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