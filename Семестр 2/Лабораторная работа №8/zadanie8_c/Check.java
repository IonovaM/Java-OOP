package zadanie8_c;

public class Check {
	private int Nomer;
	private int PIN;
	private int Ostatok;
	private Bank bank;

	public String getBank() {
		return bank.getName();
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public int getNomer() {
		return Nomer;
	}
	
	public void setNomer(int newNomer) {
		Nomer = newNomer;
	}
	
	public int getPIN() {
		return PIN;
	}
	
	public void setPIN(int newPIN) {
		PIN = newPIN;
	}
	
	public int getOstatok() {
		return Ostatok;
	}
	
	public void setOstatok(int newOstatok) {
		Ostatok = newOstatok;
	}
	
	public void addSumma(int summa) {
		Ostatok = getOstatok() + summa;
	}
	public void removeSumma(int summa) {
		Ostatok = getOstatok() - summa;
	}
}
