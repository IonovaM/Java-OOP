package zadanie8_c;

import java.util.ArrayList;

public class CashMachine {
	private int ID;
	private String Address;
	private Bank bank;

	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int newID) {
		ID = newID;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String newAddress) {
		Address = newAddress;
	}
	
	public int removeS(int pin, int summa) {
		int t = 0;
			for (int j = 0; j < getBank().getCheck().size(); j++)
				if (((Check)getBank().getCheck().get(j)).getPIN()==(pin)){
					((Check)getBank().getCheck().get(j)).removeSumma(summa);
					t = ((Check)getBank().getCheck().get(j)).getOstatok();
					return t;
			}
		return t;
	}
}
