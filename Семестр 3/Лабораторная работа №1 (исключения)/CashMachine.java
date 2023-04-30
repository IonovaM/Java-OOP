package LWork_1;

public class CashMachine {
    private int ID;
    private String Address;
    public CashMachine() {
    }
    public CashMachine(int ID, String Address) {
        this.ID = ID;
        this.Address = Address;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }


    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }

    //Переопределяем метод toString для вывода банкомата в читабельном формате
    @Override
    public String toString() {
        return "CashMachine{" +
                "ID=" + ID +
                ", address='" + Address + '\'' +
                '}';
    }
}

