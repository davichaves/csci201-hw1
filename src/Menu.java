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
		if(object1Assigned == false || object2Assigned == false) System.out.println("Assign both objects!");
		else {
			if(o[0].returnType() == 2 && o[1].returnType() == 2){
				double [] length = new double[2];
				for(int i = 0; i < 2; i++){
					length[i] = Math.sqrt((o[i].x()*o[i].x()) + (o[i].y()*o[i].y()) + (o[i].z()*o[i].z()));
				}
				double dotProd = (o[0].x()*o[1].x()) + (o[0].y()*o[1].y()) + (o[0].z()*o[1].z());
				double angle =  Math.acos((dotProd)/(length[0]*length[1]));
				angle = Math.toDegrees(angle);
				System.out.println("The angle between the two objects is: " + angle);
				//take angles
			} else System.out.println("Can't get angle out of a point!");
		}
	}
	
	public static void sum(){
		if(object1Assigned == false || object2Assigned == false) System.out.println("Assign both objects!");
		else {
			if(o[0].returnType() == 1 && o[1].returnType() == 1){
				System.out.println("Invalid operation!");
			} else if(o[0].returnType() == 1 && o[1].returnType() == 2){
				System.out.print("The result is the point: <" + (o[0].xyz[0]+o[1].xyz[0]) + ",");
				System.out.println((o[0].xyz[1]+o[1].xyz[1]) + "," + (o[0].xyz[2]+o[1].xyz[2]) + ">");
			} else if(o[0].returnType() == 2 && o[1].returnType() == 1){
				System.out.println("Invalid operation!");
			} else if(o[0].returnType() == 2 && o[1].returnType() == 2){
				System.out.print("The result is the vector: <" + (o[0].xyz[0]+o[1].xyz[0]) + ",");
				System.out.println((o[0].xyz[1]+o[1].xyz[1]) + "," + (o[0].xyz[2]+o[1].xyz[2]) + ">");
			}
		}
	}
	
	public static void subtract(){
		if(object1Assigned == false || object2Assigned == false) System.out.println("Assign both objects!");
		else {
			if(o[0].returnType() == 1 && o[1].returnType() == 1){
				System.out.print("The result is the vector: <" + (o[0].xyz[0]-o[1].xyz[0]) + ",");
				System.out.println((o[0].xyz[1]-o[1].xyz[1]) + "," + (o[0].xyz[2]-o[1].xyz[2]) + ">");
			} else if(o[0].returnType() == 1 && o[1].returnType() == 2){
				System.out.print("The result is the point: <" + (o[0].xyz[0]-o[1].xyz[0]) + ",");
				System.out.println((o[0].xyz[1]-o[1].xyz[1]) + "," + (o[0].xyz[2]-o[1].xyz[2]) + ">");
			} else if(o[0].returnType() == 2 && o[1].returnType() == 1){
				System.out.println("Invalid operation!");
			} else if(o[0].returnType() == 2 && o[1].returnType() == 2){
				System.out.print("The result is the vector: <" + (o[0].xyz[0]-o[1].xyz[0]) + ",");
				System.out.println((o[0].xyz[1]-o[1].xyz[1]) + "," + (o[0].xyz[2]-o[1].xyz[2]) + ">");
			}
		}
	}
	
	public static void main(String [] args){
		s = new Scanner(System.in);
		arrayInput = new double[3];
		object1Assigned = object2Assigned = false;
		int option = 0;
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
			String selection = s.next();
			try {
			    option = Integer.parseInt(selection);
			} catch (NumberFormatException e) {
				System.out.println("Use an int!");
			}
			if (option == 6){
				break;
			} else if (option == 1 || option == 2){
				getInput(option);
			} else if (option == 3){
				sum();
			} else if (option == 4){
				subtract();
			} else if (option == 5){
				getAngle();
			} else {
				System.out.println("No option selected!");
			}
		}
		System.out.println("Bye!");
	}
}