package zadanie11;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Check> Checkii;
	String Name;
	
	public Bank(String Name) {
		this.Name = Name;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = Name;
	}

	public void setCheckii(ArrayList Checkii) {
		this.Checkii = Checkii;
	}
	
	public ArrayList getCheckii() {
		return Checkii;
	} 
	
	public void addCheckii(Check newCheckii) {
		Checkii.add(newCheckii);
	}
}
