
public class Vector3D extends Object {
	public Vector3D(double[] parameters){
		for (int i =0; i < 3; i++) {
			xyz[i] = parameters[i];
		}
		isAssigned = true;
	}
	public String toString(){
		return "Vector <" + xyz[0] + "," + xyz[1] + "," + xyz[2] + ">";
	}
	public int returnType(){
		return 2;
	}
}
