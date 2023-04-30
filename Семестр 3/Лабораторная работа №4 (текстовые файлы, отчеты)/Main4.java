package LWork_4;

import java.io.IOException;
import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args)  throws IOException {

        Bank bank1 = new Bank("СБЕР");

        Check check1 = new Usual_Check(111, 1111, 1000);
        Check check2 = new Usual_Check(222, 2222, 2000);
        Check check3 = new Usual_Check(333, 3333, 3000);
        Check check4 = new Usual_Check(444, 4444, 4000);
        Check check5 = new Preferential_Check(555, 5555, 5000);
        Check check6 = new Preferential_Check(666, 6666, 6000);
        Check check7 = new Preferential_Check(777, 7777, 7000);
        bank1.addCheck(check1);
        bank1.addCheck(check2);
        bank1.addCheck(check3);
        bank1.addCheck(check4);
        bank1.addCheck(check5);
        bank1.addCheck(check6);
        bank1.addCheck(check7);


        CashMachine cashmach1 = new CashMachine(101, "г. Томск, ул. Красноармейская, 135");
        CashMachine cashmach2 = new CashMachine(102, "г. Томск, просп. Кирова, 36");
        CashMachine cashmach3 = new CashMachine(103, "г. Томск, просп. Фрунзе, д. 90/1");
        CashMachine cashmach4 = new CashMachine(104, "г. Томск, Иркутский тракт, 33");
        CashMachine cashmach5 = new CashMachine(105, "г. Томск, ул. Усова, 37");
        bank1.addCashMachine(cashmach1);
        bank1.addCashMachine(cashmach2);
        bank1.addCashMachine(cashmach3);
        bank1.addCashMachine(cashmach4);
        bank1.addCashMachine(cashmach5);

        BankReport_Байтовыепотоки bankReport1 = new BankReport_Байтовыепотоки(bank1);
        bankReport1.СохранитьОтчет("/Users/margarita/IdeaProjects/untitled/src/LWork_4/report_Байтовыепотоки.txt");
        String report1 = bankReport1.загрузитьОтчет("/Users/margarita/IdeaProjects/untitled/src/LWork_4/report_Байтовыепотоки.txt");
        System.out.println("\n\n\n" + report1);

        BankReport_Символьныепотоки bankReport2 = new BankReport_Символьныепотоки(bank1);
        bankReport2.СохранитьОтчетWithWriter("/Users/margarita/IdeaProjects/untitled/src/LWork_4/report_Символьныепотоки.txt");
        String report2 = bankReport2.загрузитьОтчетWithReader("/Users/margarita/IdeaProjects/untitled/src/LWork_4/report_Символьныепотоки.txt");
        System.out.println("\n\n\n" + report2);

    }
}
