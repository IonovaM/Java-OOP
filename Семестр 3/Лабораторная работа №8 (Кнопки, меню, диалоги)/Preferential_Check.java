package LWork_8;

public class Preferential_Check extends Check {
    public Preferential_Check() {
    }
    public Preferential_Check(int Nomer, int PIN, int Ostatok) {
        super(Nomer, PIN, Ostatok);
    }

    @Override
    public int removeSumma(int summa) {
        this.setOstatok(getOstatok() - summa);
        return getOstatok();
    }

    @Override
    public String toString() {
        return "Preferential_Check{" +
                "Nomer='" + Nomer + '\'' +
                ", PIN='" + PIN + '\'' +
                ", ostatok=" + Ostatok +
                '}';
    }
}

