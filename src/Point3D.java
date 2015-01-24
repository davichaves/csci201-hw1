
public class Point3D extends Object {
	public Point3D(double[] parameters){
		for(int i =0; i < 3; i++){
			xyz[i] = parameters[i];
		}
		isAssigned = true;
	}
	public String toString(){
		return "Point <" + xyz[0] + "," + xyz[1] + "," + xyz[2] + ">";
	}
	public int returnType(){
		return 1;
	}
}
