package LWork_4;

import java.io.*;

public class BankReport_Байтовыепотоки {
    private static Bank bank;
    public Bank getBank() {return bank;}
    public void setBank(Bank bank) {this.bank = bank;}
    public BankReport_Байтовыепотоки(Bank bank) {this.bank = bank;}
    int vsehOstatok = 0;
    //формирование отчета
    public String сформироватьОтчет() {
        StringBuilder report = new StringBuilder(bank.getName() + "\n\n");
        for(Check check : bank.getCheckList()){
            report.append("Счет №: ").append(check.getNomer()).append(", остаток: ").
                    append(check.getOstatok()).append("\n");
            vsehOstatok += check.getOstatok();
        }
        report.append("-----------\n").append("Суммарный остаток на счетах: ").
                append(vsehOstatok).append("\n\n").append("------------------------------------------\n\n");
        for(CashMachine cashMachine : bank.getCashMachineList()){
            report.append("Банкомат №: ").append(cashMachine.getID()).append(", адрес: ").
                    append(cashMachine.getAddress()).append("\n");
        }
        report.append("\n------------------------------------------\n");
        return report.toString();
    }

    //запись отчета в файл
    public void СохранитьОтчет(String fileName) throws IOException {
        String report = сформироватьОтчет();
        FileOutputStream fileOutput = new FileOutputStream(fileName);
        fileOutput.write(report.getBytes());
        fileOutput.close();
        System.out.println("Success write report!");
    }

    //вывод в консоль
    public String загрузитьОтчет(String fileName) throws IOException {
        String report = null;
        try(FileInputStream fileInput = new FileInputStream(fileName)) {
            byte []bytesReport = new byte[fileInput.available()];
            fileInput.read(bytesReport);
            report = new String(bytesReport);
        }
        return report;
    }
}
