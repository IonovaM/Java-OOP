package LWork_1;


public abstract class Check {
    int Nomer; int PIN; int Ostatok;

    public Check() {}

    public Check(int Nomer, int PIN, int Ostatok) throws OstatokNaScheteException {
        try {
            if (Ostatok < 0) throw new OstatokNaScheteException("Невозможно создать счет - указана отрицательная сумма");
            this.Nomer = Nomer;
            this.PIN = PIN;
            this.Ostatok = Ostatok;
        }
        catch (OstatokNaScheteException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

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

