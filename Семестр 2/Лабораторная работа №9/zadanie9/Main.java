package zadanie9;

import java.util.Scanner;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Bank bank1 =  new Bank("Sber");
		
		ArrayList<Check> Check1 = new ArrayList<>();
		Check check1 = new Check(111, 111, 1000);
		Check check2 = new Check(222, 222, 2000);
		Check1.add(check1);
		Check1.add(check2);
		
		ArrayList<Usual_Check > Us_Check1 = new ArrayList<>();
		Usual_Check uscheck1 = new Usual_Check(111, 111, 1000, 400);
		Usual_Check uscheck2 = new Usual_Check(222, 222, 2000, 800);
		Us_Check1.add(uscheck1);
		Us_Check1.add(uscheck2);
		
		ArrayList<Preferential_Check> Pr_Check1 = new ArrayList<>();
		Preferential_Check prcheck1 = new Preferential_Check(111, 111, 1000, 600);
		Preferential_Check prcheck2 = new Preferential_Check(222, 222, 2000, 1200);
		Pr_Check1.add(prcheck1);
		Pr_Check1.add(prcheck2);
		
		CashMachine cashmach1 = new CashMachine(11, "Советская ул., 59");
		CashMachine cashmach2 = new CashMachine(22, "просп. Кирова, 36а");
		
		System.out.println("Название банка: " + bank1.getName());
		System.out.println("Номер первого счета: " + check1.getNomer());
		System.out.println("Номер второго счета: " + check2.getNomer());
		System.out.println("PIN от первого счета:  " + check1.getPIN());
		System.out.println("PIN от второго счета:  " + check2.getPIN());
		System.out.println("Остаток на первом счету: " + check1.getOstatok());
		System.out.println("Остаток на втором счету:  " + check2.getOstatok());
		System.out.println("Остаток на первом ОБЫЧНОМ счету: " + uscheck1.getUs_Ostatok());
		System.out.println("Остаток на втором ОБЫЧНОМ счету:  " + uscheck2.getUs_Ostatok());
		System.out.println("Остаток на первом ЛЬГОТНОМ счету: " + prcheck1.getPr_Ostatok());
		System.out.println("Остаток на втором ЛЬГОТНОМ счету:  " + prcheck2.getPr_Ostatok());
		System.out.println("Идентификационный номер первого банкомата:  " + cashmach1.getID());
		System.out.println("Идентификационный номер второго банкомата:  " + cashmach2.getID());
		System.out.println("Адрес второго банкомата:  " + cashmach1.getAddress());
		System.out.println("Адрес третьего банкомата:  " + cashmach2.getAddress());
		
		
		
		
		Scanner input = new Scanner (System.in);
		System.out.println("Введите номер счета: ");
		int nomer_ch = input.nextInt();
		System.out.println("Введите сумму снятия: ");
		int summa = input.nextInt();
		for(int i = 0; i< Check1.size(); i++) {
			if (Check1.get(i).getNomer()==(nomer_ch)){
				Check1.get(i).removeSumma(summa);
			}
		}
		System.out.println("С какого счета нужно снять деньги?");
		System.out.println("P.S. Введите ЛГ (ели нужно снять со льготног счета), ОБ (если нужно снять с обычного счета), СЧЕТ (если просто нужно снять деньги)");
		//Scanner in = new Scanner (System.in);
		//String schet = in.nextLine();
		String schet = "ОБ";
		if (schet == "ЛГ"){
			for(int i = 0; i< Pr_Check1.size(); i++) {
				if (Pr_Check1.get(i).getNomer()==(nomer_ch)){
					Pr_Check1.get(i).removeSummaPr(summa);
					System.out.println("Остаток на Вашем ОБЫЧНОМ счету: " + Pr_Check1.get(i).getPr_Ostatok());
				}
			}
		}
		else if (schet == "ОБ"){
			for(int i = 0; i< Us_Check1.size(); i++) {
				if (Us_Check1.get(i).getNomer()==(nomer_ch)){
					Us_Check1.get(i).removeSummaUs(summa);
					System.out.println("Остаток на Вашем ОБЫЧНОМ счету: " + Us_Check1.get(i).getUs_Ostatok());
				}
			}
		}
		else if (schet == "СЧЕТ"){
			for(int i = 0; i< Check1.size(); i++) {
				if (Check1.get(i).getNomer()==(nomer_ch)){
					Check1.get(i).removeSumma(summa);
					System.out.println("Остаток на Вашем счету: " + Check1.get(i).getOstatok());
				}
			}
		}
	}

}

