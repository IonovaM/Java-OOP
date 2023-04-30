package LWork_5;
import java.io.*;
import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Bank bank1 = new Bank("Sber");

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

        sBank("/Users/margarita/IdeaProjects/untitled/src/LWork_5/report.dat", bank1);
        Bank bank = gBank("/Users/margarita/IdeaProjects/untitled/src/LWork_5/report.dat");
        System.out.println(bank);
    }

    // сохранение объект в файл
    public static void sBank(String fileName, Bank bank1) throws IOException, ClassNotFoundException {
        // создание файлового потока
        FileOutputStream fileOutput = new FileOutputStream("/Users/margarita/IdeaProjects/LabWork_1_IonovaM/src/LabWork_5/report.dat");
        // создание объектного потока с указанием файлового потока
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        // запись объекта
        objectOutput.writeObject(bank1);
        //System.out.println("File has been written");
        // закрытие потоков fileOutput.close();
        objectOutput.close();

    }
    // загрузка объекта из файла
    public static Bank gBank(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<CashMachine> newCashMachine= new ArrayList<CashMachine>();
        // создание файлового потока
        FileInputStream fileInput = new FileInputStream("/Users/margarita/IdeaProjects/LabWork_1_IonovaM/src/LabWork_5/report.dat");
        // создание объектного потока с указанием файлового потока
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        // загрузка объекта
        Bank t = (Bank) objectInput.readObject();
        // закрытие потоков fileInput.close();
        objectInput.close();
        return t;
    }
}
