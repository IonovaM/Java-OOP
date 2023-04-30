package zadanie8_a;

public class Main {

	public static void main(String[] args) {
		Bank bank1 = new Bank();
		bank1.setName("Sber");
		Check check1 = new Check();
		Check check2 = new Check();
		check1.setNomer(1);
		check2.setNomer(2);
		check1.setPIN(111);
		check2.setPIN(222);
		check1.setOstatok(1000);
		check2.setOstatok(2000);
		CashMachine cashmachine1 = new CashMachine();
		CashMachine cashmachine2 = new CashMachine();
		CashMachine cashmachine3 = new CashMachine();
		cashmachine1.setID(01);
		cashmachine2.setID(02);
		cashmachine3.setID(03);
		cashmachine1.setAddress("Советская ул., 59");
		cashmachine2.setAddress("пр. Фрунзе, 55");
		cashmachine3.setAddress("просп. Кирова, 36а");
		
		System.out.println("Название банка: " + bank1.getName());
		System.out.println("Номер первого счета: " + check1.getNomer());
		System.out.println("Номер второго счета: " + check2.getNomer());
		System.out.println("PIN от первого счета:  " + check1.getPIN());
		System.out.println("PIN от второго счета:  " + check2.getPIN());
		System.out.println("Остаток на первом счету: " + check1.getOstatok());
		System.out.println("Остаток на втором счету:  " + check2.getOstatok());
		System.out.println("Идентификационный номер первого банкомата:  " + cashmachine1.getID());
		System.out.println("Идентификационный номер второго банкомата:  " + cashmachine2.getID());
		System.out.println("Идентификационный номер третьего банкомата:  " + + cashmachine3.getID());
		System.out.println("Адрес первого банкомата:  " + cashmachine1.getAddress());
		System.out.println("Адрес второго банкомата:  " + cashmachine2.getAddress());
		System.out.println("Адрес третьего банкомата:  " + cashmachine3.getAddress());
		
	}
}
