package zadanie9;

import java.util.ArrayList;

public class Preferential_Check extends Check {

	int Pr_Ostatok;

	public Preferential_Check(int Nomer, int PIN, int Ostatok, int Pr_Ostatok) {
        super(Nomer, PIN, Ostatok);  
        this.Pr_Ostatok = Pr_Ostatok;
    }
	
	public int getPr_Ostatok() {
		return Pr_Ostatok;	
	}
	public void setPr_Ostatok(int Pr_Ostatok) {
		this.Pr_Ostatok = Pr_Ostatok;		
	}
	
	public int removeSummaPr(int summa) {
		return Pr_Ostatok = getPr_Ostatok() - summa;
	}
	
}
