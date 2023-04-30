package LWork_1;

public class Main1 {
    public static void main(String[] args) throws SnyatSoSchetaException, OstatokNaScheteException {
        Check check = new Usual_Check(111, 1111, 1000);
        check.removeSumma(1200);
        System.out.println(check);
    }
}
