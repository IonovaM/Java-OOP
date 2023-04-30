package LWork_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main7 {
    static JFrame jFrame = getJFrame();
    //Переменная счетчик для компоновки частей
    static int numb_rows_panel = 2;

    //Создаем вкладки
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();


    public static void main(String[] args) {
        //получаем банк
        Bank bank = createBank();

        //Создаем панель закладок
        JTabbedPane jTabbedPane = new JTabbedPane();
        //Прикрепляем панель к окну
        jFrame.add(jTabbedPane);
        //Прикрепляем вкладки к панели
        jTabbedPane.add(jPanel, "Банкоматы");
        jTabbedPane.add(jPanel1, "Информация о счетах");

        //Вызываем метод отображения панели со счетами
        setJPanelCheck(bank);
        //Вызываем метод отображения панели с банкоматами
        setJPanelCashMashine(bank);


        //Компонуем
        jFrame.pack();
    }


    //Вывод вкладки с информацией о счетах
    static void setJPanelCheck(Bank bank) {
        //очищаем от предыдущих, чтобы не наслаивалось
        jPanel1.removeAll();


        //Создаем лист моделей для передачи в jlist
        DefaultListModel<Check> defaultListModel = new DefaultListModel<>();
        //Копируем туда список счетов
        //defaultListModel.addAll(bank.getCheckList());
        for (Check check : bank.getCheckList()) {
            defaultListModel.addElement(check);
        }

        //Создаем Jlist (список) для вывода на панель
        JList<Check> jList = new JList<>(defaultListModel);
        //Добавляем список на панель
        jPanel1.add(jList);

        //Создаем кнопку снять со счета
        JButton jButton = new JButton("Снять cо счета");

        //Создаем слушатель для кнопки
        //Сам слушатель реализуем в анонимном классе
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Получаем выбранный пользователем счет из списка
                Check account = jList.getSelectedValue();

                //Создаем текстовое поле ввода
                JTextField jTextField = new JTextField();

                //Объединяем в массив компонент для передачи диалоговому окну
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Введите сумму, которую вы хотите снять:"),
                        jTextField
                };

                //Выводим диалоговое окно
                int result = JOptionPane.showConfirmDialog(null, inputs, "Снятие со счета", JOptionPane.OK_CANCEL_OPTION);

                //Проверяем результат вызова диалогова окна
                if (result == 0) {
                    //Вызываем соответсвующий метод для счета
                    account.removeSumma(Integer.parseInt(jTextField.getText()));
                }

            }
        });

        //добавляем кнопку на панель
        jPanel1.add(jButton);
        jFrame.pack();

    }

    //Вывод вкладки с информацией о банкоматах
    static void setJPanelCashMashine(Bank bank) {
        //очищаем панель
        jPanel.removeAll();

        //Изменяем переменную, отвечающую за компоновку на панели
        numb_rows_panel = bank.getCashMachineList().size();
        //устанавливаем сетку
        jPanel.setLayout(new GridLayout(numb_rows_panel, 2));


        for (CashMachine cashMachine : bank.getCashMachineList()) {
            //Создаем надпись (лейбл) с номером банкомата
            JLabel jLabel = new JLabel(String.valueOf(cashMachine.getID()));

            //Создаем поле с адресом банкомата
            JTextField jTextField = new JTextField(cashMachine.getAddress());
            jPanel.add(jLabel);
            jPanel.add(jTextField);
        }
    }

    //Получение фрейма(Рабочей области)
    private static JFrame getJFrame() {
        //Создание фрейма
        JFrame jFrame = new JFrame() {
        };
        //Делаем его видимым
        jFrame.setVisible(true);
        //Создаем возможность закрыть окно
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Получаем инструменты необходимые для работы с экраном(разрешением)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Получаем разрешения экрана
        Dimension dimension = toolkit.getScreenSize();
        //Устанавливаем границы окна
        //jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 500);
        //Задаем названия окна
        jFrame.setTitle("Банк");
        return jFrame;
    }

    //Создание банка вынесено в метод
    public static Bank createBank() {

        Bank bank = new Bank("Sber");

        Check check1 = new Usual_Check(111, 1111, 1000);
        Check check2 = new Usual_Check(222, 2222, 2000);
        Check check3 = new Usual_Check(333, 3333, 3000);
        Check check4 = new Usual_Check(444, 4444, 4000);
        Check check5 = new Preferential_Check(555, 5555, 5000);
        Check check6 = new Preferential_Check(666, 6666, 6000);
        Check check7 = new Preferential_Check(777, 7777, 7000);
        bank.addCheck(check1);
        bank.addCheck(check2);
        bank.addCheck(check3);
        bank.addCheck(check4);
        bank.addCheck(check5);
        bank.addCheck(check6);
        bank.addCheck(check7);


        CashMachine cashmach1 = new CashMachine(101, "г. Томск, ул. Красноармейская, 135");
        CashMachine cashmach2 = new CashMachine(102, "г. Томск, просп. Кирова, 36");
        CashMachine cashmach3 = new CashMachine(103, "г. Томск, просп. Фрунзе, д. 90/1");
        CashMachine cashmach4 = new CashMachine(104, "г. Томск, Иркутский тракт, 33");
        CashMachine cashmach5 = new CashMachine(105, "г. Томск, ул. Усова, 37");
        bank.addCashMachine(cashmach1);
        bank.addCashMachine(cashmach2);
        bank.addCashMachine(cashmach3);
        bank.addCashMachine(cashmach4);
        bank.addCashMachine(cashmach5);

        return bank;
    }

}
