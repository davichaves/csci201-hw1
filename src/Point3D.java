
public class Point3D extends Object {
	public Point3D(float[] parameters){
		xyz = parameters;
		isAssigned = true;
	}
	public String toString(){
		return "Point <" + xyz[0] + "," + xyz[1] + "," + xyz[2] + ">";
	}
	public int returnType(){
		return 1;
	}
}
