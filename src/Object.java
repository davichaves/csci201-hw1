
public abstract class Object {
	protected boolean isAssigned = false;
	protected double [] xyz = new double[3];
	public String toString(){
		return "null";
	}
	public double x(){
		return xyz[0];
	}
	public double y(){
		return xyz[1];
	}
	public double z(){
		return xyz[2];
	}
	public abstract int returnType();
}