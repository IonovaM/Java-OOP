package LWork_9;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Класс имлементирует (реализует) интерфейс serializable
public class Bank  implements Serializable {
    private String Name;
    //Лист Банкоматов
    private List<CashMachine> cashMachineList = new ArrayList<>();
    //Лист Счетов
    private List<Check> checkList = new ArrayList<>();

    //Конструктор с параметрами
    public Bank(String Name) {
        this.Name = Name;
    }

    //Конструктор по умолчанию публичный
    public Bank() {
    }

    //Добавление банкомата в список
    public void addCashMachine(CashMachine cashMachine){
        cashMachineList.add(cashMachine);
    }

    //Добавление счета в список
    public void addCheck(Check check){
        checkList.add(check);
    }


    //Геттеры и сеттеры
    public List<CashMachine> getCashMachineList() {
        return cashMachineList;
    }

    public void setCashMachineList(List<CashMachine> cashMachineList) {
        this.cashMachineList = cashMachineList;
    }

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> checkList) {
        this.checkList = checkList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    //Переопределяем метод toString для вывода банка в читабельном формате
    @Override
    public String toString() {
        return "Bank{" +
                "name='" + Name + '\'' +
                ", cashMachineList=" + cashMachineList +
                ", cashMachineList=" + checkList +
                '}';
    }
}