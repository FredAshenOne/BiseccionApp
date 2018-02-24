package mainPackage;

public class Registro {
	
	private double limiteMenor,limiteMayor,biseccion,errAbsol,errRel;
	
	int iterations = 0;
	
	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public Registro() {}
	
	public double getBiseccion() {
		return biseccion;
	}

	public void setBiseccion(double biseccion) {
		this.biseccion = biseccion;
	}

	public double getErrAbsol() {
		return errAbsol;
	}

	public void setErrAbsol(double errAbsol) {
		this.errAbsol = errAbsol;
	}

	public double getErrRel() {
		return errRel;
	}

	public void setErrRel(double errRel) {
		this.errRel = errRel;
	}

	public double getLimiteMenor() {
		return limiteMenor;
	}

	public void setLimiteMenor(double limiteMenor) {
		this.limiteMenor = limiteMenor;
	}

	public double getLimiteMayor() {
		return limiteMayor;
	}

	public void setLimiteMayor(double limiteMayor) {
		this.limiteMayor = limiteMayor;
	}

	
	
	
	
}
