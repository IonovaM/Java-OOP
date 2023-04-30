package LWork_9;

public class Usual_Check extends Check {
    public Usual_Check() {
    }
    public Usual_Check(int Nomer, int PIN, int Ostatok) {
        super(Nomer, PIN, Ostatok);
    }

    @Override
    public int removeSumma(int summa) {
        this.setOstatok(getOstatok() - summa);
        return getOstatok();
    }

    @Override
    public String toString() {
        return "Usual_Check{" +
                "Nomer='" + Nomer + '\'' +
                ", PIN='" + PIN + '\'' +
                ", ostatok=" + Ostatok +
                '}';
    }
}
