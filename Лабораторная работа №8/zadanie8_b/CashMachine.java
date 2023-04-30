package zadanie8_b;

public class CashMachine {
	private int ID;
	private String Address;
	private Bank bank;

	public String getBank() {
		return bank.getName();
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
}
