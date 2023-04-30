package zadanie10;

public abstract class Check {

	int Nomer;
	int PIN;
	int Ostatok;
	
	public Check(int Nomer, int PIN, int Ostatok) {
		this.Nomer = Nomer;
		this.PIN = PIN;
		this.Ostatok = Ostatok;
	}
	
	public int getNomer() {
		return Nomer;			
	}
	public void setNomer(int Nomer) {
		this.Nomer = Nomer;		
	}

	
	public int getPIN() {
		return PIN;			
	}
	public void setPIN(int PIN) {
		this.PIN = PIN;		
	}

	
	public int getOstatok() {
		return Ostatok;	
	}
	public void setOstatok(int Ostatok) {
		this.Ostatok = Ostatok;		
	}
	
	public abstract int removeSumma(int summa);
	
}
