package zadanie11;

public class Usual_Check implements Check {
	
	int Nomer;
	int PIN;
	int Ostatok;
	int Us_Ostatok;
	
	public Usual_Check(int Nomer, int PIN, int Ostatok, int Us_Ostatok) {
        this.Nomer = Nomer;
		this.PIN = PIN;
		this.Ostatok = Ostatok;   
        this.Us_Ostatok = Us_Ostatok;
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
	
	public int getUs_Ostatok() {
		return Us_Ostatok;	
	}
	public void setUs_Ostatok(int Us_Ostatok) {
		this.Us_Ostatok = Us_Ostatok;		
	}
	
	@Override
	public int removeSumma(int summa) {
		return Us_Ostatok = getUs_Ostatok() - summa - (summa/100*5);
	}
}
