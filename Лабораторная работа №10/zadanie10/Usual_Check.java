package zadanie10;

public class Usual_Check extends Check  {

	int Us_Ostatok;
	
	public Usual_Check(int Nomer, int PIN, int Ostatok, int Us_Ostatok) {
        super(Nomer, PIN, Us_Ostatok);   
        this.Us_Ostatok = Us_Ostatok;
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
