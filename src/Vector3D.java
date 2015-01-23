
public class Vector3D extends Object {
	public Vector3D(float[] parameters){
		xyz = parameters;
		isAssigned = true;
	}
	public String toString(){
		return "Vector <" + xyz[0] + "," + xyz[1] + "," + xyz[2] + ">";
	}
	public int returnType(){
		return 2;
	}
}
