package LWork_6;

import java.io.Serializable;
// Абстрактный класс реализующий интерфейс serializable
public abstract class Check implements Serializable {
    int Nomer; int PIN; int Ostatok;

    public Check() {
    }

    public Check(int Nomer, int PIN, int Ostatok) {
        this.Nomer = Nomer;
        this.PIN = PIN;
        this.Ostatok = Ostatok;}

    public int getNomer() {
        return Nomer;
    }
    public void setNomer(int Nomer) {
        this.Nomer = Nomer;
    }


    public int getPIN() {
        return PIN;
    }
    public void setPIN(int PIN) {
        this.PIN = PIN;
    }


    public int getOstatok() {
        return Ostatok;
    }
    public void setOstatok(int Ostatok) {
        this.Ostatok = Ostatok;
    }


    public int removeSumma(int summa) {
        return getOstatok() - summa;
    }

    //Переопределяем метод toString для вывода счета в читабельном формате
    @Override
    public String toString() {
        return "Check{" +
                "Nomer='" + Nomer + '\'' +
                ", PIN='" + PIN + '\'' +
                ", ostatok=" + Ostatok +
                '}';
    }
}

