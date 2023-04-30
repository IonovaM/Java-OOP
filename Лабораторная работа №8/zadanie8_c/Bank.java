package zadanie8_c;

import java.util.ArrayList;

public class Bank {

	private String Name;
	ArrayList Check = new ArrayList();
	ArrayList CashMachine = new ArrayList();
	
	public String getName() {
		return Name;
	}
	
	public void setName(String newName) {
		Name = newName;
	}
	
	public void setCheck(ArrayList Check) {
		this.Check = Check;
	}
	
	public ArrayList getCheck() {
		return Check;
	}
	
	public void addCheck(Check newCheck) {
		Check.add(newCheck);
	}
	
	public void removeCheck(Check oldCheck) {
		Check.remove(oldCheck);
	}
	
	
	public void setCashMachine(ArrayList CashMachine) {
		this.CashMachine = CashMachine;
	}
	
	public ArrayList getCashMachine() {
		return CashMachine;
	}
	
	public void addCashMachine(CashMachine newCashMachine) {
		CashMachine.add(newCashMachine);
	}
	
}

