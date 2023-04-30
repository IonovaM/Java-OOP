package zadanie10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Bank bank1 =  new Bank("Sber");
		Bank bank2 =  new Bank("Sb2");
		
		Usual_Check uscheck1 = new Usual_Check(111, 111, 1000, 400);
		Usual_Check uscheck2 = new Usual_Check(222, 222, 2000, 800);
		bank2.setCheckii(new ArrayList<Check>());
		bank2.addCheckii(uscheck1);
		bank2.addCheckii(uscheck2);		
		
		Preferential_Check prcheck1 = new Preferential_Check(111, 111, 1000, 600);
		Preferential_Check prcheck2 = new Preferential_Check(222, 222, 2000, 1200);
		bank2.addCheckii(prcheck1);
		bank2.addCheckii(prcheck2);
		
		System.out.println("Название банка: " + bank1.getName());
		System.out.println("Название банка: " + bank2.getName());
		System.out.println("Остаток на первом ОБЫЧНОМ счету: " + uscheck1.getUs_Ostatok());
		System.out.println("Остаток на втором ОБЫЧНОМ счету:  " + uscheck2.getUs_Ostatok());
		System.out.println("Остаток на первом ЛЬГОТНОМ счету: " + prcheck1.getPr_Ostatok());
		System.out.println("Остаток на втором ЛЬГОТНОМ счету:  " + prcheck2.getPr_Ostatok());
		System.out.println(" ");
		
		
		for (int i = 0; i < bank2.getCheckii().size(); i++) {
			System.out.println("Остаток на " + (i+1) + " банковском счету:  " + ((Check)bank2.getCheckii().get(i)).removeSumma(0));
		}
		
		Scanner input = new Scanner (System.in);
		System.out.println("Введите сумму снятия: ");
		int summa = input.nextInt();
		
		for (int i = 0; i < bank2.getCheckii().size(); i++) {
			System.out.println("Остаток на " + (i+1) + " банковском счету после снятия:  " + ((Check)bank2.getCheckii().get(i)).removeSumma(summa));
		}
	}

}
