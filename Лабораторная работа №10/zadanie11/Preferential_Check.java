package zadanie11;

public class Preferential_Check implements Check {
	
	int Nomer;
	int PIN;
	int Ostatok;
	int Pr_Ostatok;
	
	public Preferential_Check(int Nomer, int PIN, int Ostatok, int Pr_Ostatok) {
		this.Nomer = Nomer;
		this.PIN = PIN;
		this.Ostatok = Ostatok;
        this.Pr_Ostatok = Pr_Ostatok;
    }
	@Override
	public int getNomer() {
		return Nomer;			
	}
	@Override
	public void setNomer(int Nomer) {
		this.Nomer = Nomer;		
	}
	@Override
	public int getPIN() {
		return PIN;			
	}
	@Override
	public void setPIN(int PIN) {
		this.PIN = PIN;		
	}
	@Override
	public int getOstatok() {
		return Ostatok;	
	}
	@Override
	public void setOstatok(int Ostatok) {
		this.Ostatok = Ostatok;		
	}

	public int getPr_Ostatok() {
		return Pr_Ostatok;	
	}

	public void setPr_Ostatok(int Pr_Ostatok) {
		this.Pr_Ostatok = Pr_Ostatok;		
	}
	
	@Override
	public int removeSumma(int summa) {
		return Pr_Ostatok = getPr_Ostatok() - summa- (summa/100);
	}
}
