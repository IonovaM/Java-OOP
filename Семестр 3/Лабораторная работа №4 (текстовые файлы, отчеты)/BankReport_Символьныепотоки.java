package LWork_4;

import java.io.*;

public class BankReport_Символьныепотоки {
    private static Bank bank;

    public Bank getBank() {return bank;}
    public void setBank(Bank bank) {this.bank = bank;}
    public BankReport_Символьныепотоки(Bank bank) {this.bank = bank;}
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
    public void СохранитьОтчетWithWriter(String fileName) throws IOException {
        String report = сформироватьОтчет();
        try(Writer writer = new FileWriter(fileName)){
            writer.write(report);
        }
        System.out.println("Success write report");
    }

    //запись отчета в файл
    public String загрузитьОтчетWithReader(String fileName) throws IOException {
        StringBuilder report = new StringBuilder();
        try(Reader reader = new FileReader(fileName)){
            while(reader.ready()){
                report.append((char) reader.read());
            }
        }
        return report.toString();
    }

}
