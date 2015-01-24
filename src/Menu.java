import java.util.Scanner;
import java.util.StringTokenizer;


public class Menu {
	private static Scanner s;
	private static double [] arrayInput;
	private static boolean badInput;
	private static Object [] o = new Object[2];
	private static boolean object1Assigned;
	private static boolean object2Assigned;
	
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
				if(n==1) object1Assigned = true;
				else object2Assigned = true;
				for(int i = 0; i < 3; i++){
					System.out.println(arrayInput[i]);
				}
				o[n-1] = new Point3D(arrayInput);
				break;
			}
			if (type.equalsIgnoreCase("vector")){
				if(n==1) object1Assigned = true;
				else object2Assigned = true;
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
	
	public static void getAngle(){
		if(object1Assigned == false || object2Assigned == false) System.out.println("Assign the objects!");
		else {
			if(o[0].returnType() == 2 && o[1].returnType() == 2){
				double [] length = new double[2];
				for(int i = 0; i < 2; i++){
					length[i] = Math.sqrt((o[0].xyz[0]*o[0].xyz[0]) + (o[0].xyz[1]*o[0].xyz[1]) + (o[0].xyz[2]*o[0].xyz[2]));
				}
				double dotProd = (o[0].xyz[0]*o[1].xyz[0]) + (o[0].xyz[1]*o[1].xyz[1]) + (o[0].xyz[2]*o[1].xyz[2]);
				double angle =  Math.acos((dotProd)/(length[0]*length[1]));
				angle = (angle/(2*Math.PI))*360;
				System.out.println("The angle between the two objects is: " + angle);
				//take angles
			} else System.out.println("Can't get angle out of a point!");
		}
	}
	
	public static void main(String [] args){
		s = new Scanner(System.in);
		arrayInput = new double[3];
		object1Assigned = object2Assigned = false;
		while(true){
			if(object1Assigned){
				System.out.println("1: Change value of " + o[0].toString());
			} else {
				System.out.println("1: Change value of null");
			}
			if(object2Assigned){
				System.out.println("2: Change value of " + o[1].toString());
			} else {
				System.out.println("2: Change value of null");
			}
			System.out.println("3: Add the objects.\n4: Subtract the objects.");
			System.out.println("5: Find the angle between the objects.\n6: Quit");
			System.out.print("What do you want to do? ");
			int option = s.nextInt();
			if (option == 6){
				break;
			} else if (option == 1 || option == 2){
				getInput(option);
			} else if (option == 3){
				if(object1Assigned == false || object2Assigned == false) System.out.println("Assign the objects!");
				else {
					//code for sum here
				}
			} else if (option == 4){
				if(object1Assigned == false || object2Assigned == false) System.out.println("Assign the objects!");
				else {
					//code for subtract here
				}
			} else if (option == 5){
				getAngle();
			}
		}
		System.out.println("Bye!");
	}
}