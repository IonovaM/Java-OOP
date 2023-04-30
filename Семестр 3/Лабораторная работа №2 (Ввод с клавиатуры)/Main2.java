package LWork_2;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {
    public static void main(String args[]) throws IOException {

        CashMachine cashMachine1 = new CashMachine();
        ReadInformation address = new ReadInformation();
        System.out.println("Введите адрес банкомата: ");
        cashMachine1.setAddress(address.вводСтрокиСКлавиатуры());
        ReadInformation id = new ReadInformation();
        System.out.println("Введите ID банкомата: ");
        cashMachine1.setID(id. вводЧислаСКлавиатуры());

        System.out.println(cashMachine1);

        CashMachine cashMachine2 = new CashMachine();
        System.out.println("Введите адрес банкомата: ");
        Scanner sc_str = new Scanner(System.in);
        cashMachine2.setAddress(sc_str.next());
        System.out.println("Введите ID банкомата: ");
        Scanner sc_int = new Scanner(System.in);
        cashMachine2.setID(sc_int.nextInt());

        System.out.println(cashMachine2);
    }
}
