package LWork_6;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Main6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //создаем банк
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

        //Сериализуем наш банк
        //метод принимает на вход путь для сохранения файла и экземпляр класса
        saveBank("/Users/margarita/IdeaProjects/untitled/src/LWork_6/report.xml", bank1);

        //Десериализуем
        Bank bank2 = getBank("/Users/margarita/IdeaProjects/untitled/src/LWork_6/report.xml");
        System.out.println(bank2);
    }
    //Метод в котором мы сериализуем объект
    public static void saveBank(String fileName, Bank saveBank){
        //Также используем try c ресурсами для автоматического закрытия
        //Класс xml encoder необходим для сериализации принимает на вход выходной файловый поток
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName))){
            // с помощью метода writeObject записываем(сериализуем) объект
            xmlEncoder.writeObject(saveBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Получаем банк из файла
    public static Bank getBank(String fileName) {

        //Используем try с ресурсами для автоматического закрытия потока
        //C помощью класса xmldecoder десериализуем объект, принимает на вход входной файловый поток
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fileName))){
            //Считываем объект и приводим его к классу Bank
            //Потому что, метод readObject возвращает Object
            return (Bank) xmlDecoder.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

