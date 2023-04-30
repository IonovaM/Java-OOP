package LWork_1;


public class Usual_Check extends Check {

    public Usual_Check(int Nomer, int PIN, int Ostatok) throws OstatokNaScheteException {
        super(Nomer, PIN, Ostatok);
    }

    @Override
    public void removeSumma(int summa) throws SnyatSoSchetaException {
        try {
            if (summa < 0) throw new SnyatSoSchetaException("Указана отрицательная сумма");
            if ((Ostatok - summa) < 0) throw new SnyatSoSchetaException("На счете недостаточно средств");
            this.Ostatok -= summa;
        }
        catch (SnyatSoSchetaException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
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
