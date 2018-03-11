package mainPackage;

import javax.swing.table.DefaultTableModel;

public class Functions{
	double valorx,limit1,bisec,limit2,errAbs,errRel,errorel;
	
		
	public double valorx(double valor1,double valor2) {
		return (valor1 + valor2) /2;
		
	}
	
	public double biseccion(double valorx) {
		return (valorx * Math.sin(valorx))-1;
		
	}
	
	public double errorAbs(double valorx,double valory) {
		return valorx - valory;
		
	}
	
	public double errorRel(double errorAbs,double valorx) {
		return errorAbs/valorx;
		
	}
	
	public void iteraciones(int iteraciones,Registro regs,DefaultTableModel model) {
		double valory = 0;
		model.setNumRows(0);
		for(int i = 0;i < iteraciones;i++) {			
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = biseccion(valorx);			
			errAbs = Math.abs(errorAbs(valorx,valory));
			model.addRow(new Object[] {
					i+1,limit1,limit2,valorx,bisec,errAbs,errorRel(errAbs,valorx)
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}				
	}
	
	
	public void errResult(double err,Registro regs,DefaultTableModel model) {
		model.setNumRows(0);
		double valory = 0;
		int i = 0;
		do {	
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = biseccion(valorx);			
			errAbs = Math.abs(errorAbs(valorx,valory));
			errorel = errorRel(errAbs,valorx);
			model.addRow(new Object[] {
					i+1,limit1,limit2,valorx,bisec,errAbs,errorel
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}while(err < errorel);				
	}
	
	public void funResult(double result,Registro regs,DefaultTableModel model) {
		model.setNumRows(0);
		double valory = 0;
		int i = 0;
		do {
			limit1 = regs.getLimiteMenor();
			limit2 = regs.getLimiteMayor();
			valorx = valorx(limit1,limit2);
			bisec = Math.abs(biseccion(valorx));
			errAbs = Math.abs(errorAbs(valorx,valory));
			errorel = errorRel(errAbs,valorx);
			model.addRow(new Object[] {
					i+1,limit1,limit2,valorx,Math.abs(bisec),errAbs,errorel
					});
			if(bisec > 0) {
				regs.setLimiteMayor(valorx);
			}else {
				regs.setLimiteMenor(valorx);
			}	
			valory = valorx; 
		}while(result < bisec );	
	}
	
	
}
