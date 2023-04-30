package LWork_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Main9 {
    static JFrame jFrame = getJFrame();
    //Переменная счетчик для компоновки частей
    static int numb_rows_panel = 2;

    //Создаем вкладки
    static JPanel jPanel = new JPanel(new GridLayout(numb_rows_panel, 2));
    static JPanel jPanel1 = new JPanel();

    //Создаем меню бар
    static JMenuBar jMenuBar = new JMenuBar();

    //Создаем несколько подменю для начального экрана
    static JMenu jMenuFile = new JMenu("Файл");
    static JMenuItem jMenuItemNew = new JMenuItem("Новый");;
    static JMenuItem jMenuItemOpen = new JMenuItem("Открыть");
    static JMenuItem jMenuItemSave = new JMenuItem("Сохранить");
    //Переменная для хранения экземпляра класса
    static Bank bank;

    //Создаем панель закладок
    static JTabbedPane jTabbedPane = new JTabbedPane();

    public static void main(String[] args) {

        //Вызываем метод отображения начального окна
        start();

        //Создаем слушатель для подменю создания нового файла
        jMenuItemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Текстовое поле
                JTextField jTextField = new JTextField();

                //Массив компонент
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Название Банка: "),
                        jTextField
                };

                //Вызываем диалог для ввода данных
                int result = JOptionPane.showConfirmDialog(null, inputs, "Создать банк", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    //Когда пользователь нажал окей
                    //Создаем новый банк и присваеваем его текущему
                    bank = new Bank(jTextField.getText());
                    //Устанавливаем название окна
                    jFrame.setTitle(jTextField.getText());
                    //Вызываем метод отображения остальных частей из пред. лабы
                    show();
                }

            }
        });

        //Создаем слушатель для подменю "сохранить"
        jMenuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Создаем элемент jFileChooser для возможности выбора пути к файлу
                JFileChooser jFileChooser = new JFileChooser();

                //Вызываем диалог сохранения
                int i = jFileChooser.showSaveDialog(null);
                if(i == JFileChooser.APPROVE_OPTION){
                    //если пользователь нажал "ок"
                    //Получаем путь выбранные пользователем и записываем его в переменную добавляя в конец разрешение файла
                    String filepath = jFileChooser.getSelectedFile().getPath() + ".xml";
                    //Сохраняем наш банк вызывая метод
                    saveBank0(filepath,bank);
                }
            }
        });

        //Создаем слушатель для подменю "open"
        jMenuItemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ////Создаем элемент jFileChooser для возможности выбора пути
                JFileChooser jFileChooser = new JFileChooser();
                //Вызываем диалоговое окно для открытия файла
                int i = jFileChooser.showOpenDialog(null);
                System.out.println("банк получен");
                if(i == JFileChooser.APPROVE_OPTION){
                    System.out.println("2банк получен");
                    //Получаем путь к файлу
                    String filepath = jFileChooser.getSelectedFile().getPath() ;
                    System.out.println("файл получен");
                    System.out.println(filepath);
                    //Вызываем метод чтения и полученный банк присваиваем нашей переменной
                    bank = getBank0(filepath);
                    System.out.println("3банк получен");
                    System.out.println(bank);
                    //Меняем заголовок окна
                    jFrame.setTitle(bank.getName());
                    System.out.println("4банк получен");
                    show();

                }
                show();
            }
        });

    }


    //Два наших метода для сериализации из лабы 6
    public static Bank getBank0(String fileName) {
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(fileName))){
            return (Bank) xmlDecoder.readObject();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void saveBank0(String fileName, Bank saveBank){
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(fileName))){
            xmlEncoder.writeObject(saveBank);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //тело main из предыдущей лабы вынесено в этот метод
    static void show(){
        //Очищаем меню бар, чтобы избежать наслаивания
        jMenuBar.removeAll();

        //Снова выводим начальные элементы, так как меню было очищено
        start();

        //Прикрепляем панель к окну
        jFrame.add(jTabbedPane);
        //Прикрепляем вкладки к панели
        jTabbedPane.add(jPanel, "Банкоматы");
        jTabbedPane.add(jPanel1, "Информация о счетах");

        //Вызываем метод отображения панели со счетами
        setJPanelAccount(bank);
        //Вызываем метод отображения панели с банкоматами
        setJPanelATM(bank);

        //Прикрепляем меню бар к окну
        jFrame.setJMenuBar(jMenuBar);

        //Инициализируем меню
        JMenu jMenu = new JMenu("Создать");

        //Создаем вкладки подменю
        JMenuItem jMenuItem = new JMenuItem("Счет");
        JMenuItem jMenuItem2 = new JMenuItem("Банкомат");

        //Прикрепляем подменю к меню
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        //Прикрепляем меню к меню бар
        jMenuBar.add(jMenu);

        //Создаем слушатель для подменю
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Создаем три поля для ввода данных
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();
                JTextField jTextField2 = new JTextField();

                //Создаем радио кнопки (переключатели)
                JRadioButton jRadioButton = new JRadioButton("Обычный");
                JRadioButton jRadioButton1 = new JRadioButton("Льготный");

                //Объединяем кнопки в группу
                ButtonGroup buttonGroup = new ButtonGroup();
                buttonGroup.add(jRadioButton);
                buttonGroup.add(jRadioButton1);

                //Объединяем в массив компонент для передачи диалоговому окну
                //И сразу подписываем поля
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Номер"),
                        jTextField,
                        new JLabel("PIN"),
                        jTextField1,
                        new JLabel("Остаток"),
                        jTextField2,
                        new JLabel("Тип"),
                        jRadioButton,
                        jRadioButton1
                };

                int result = JOptionPane.showConfirmDialog(null, inputs, "Создать счет", JOptionPane.OK_CANCEL_OPTION);
                if(result ==0) {
                    if (jRadioButton.isSelected()) {
                        //Если выбран обычный счет создаем соответствующий счет
                        //Передавая в конструктор значения из текстовых полей
                        Check check = new Usual_Check(Integer.parseInt(jTextField.getText()),Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText()));
                        //Добавляем в наш банк новый счет
                        bank.addCheck(check);
                    }else{
                        //Если выбран льготный счет создаем соответствующий счет
                        //Передавая в конструктор значения из текстовых полей
                        Check check = new Preferential_Check(Integer.parseInt(jTextField.getText()),Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText()));
                        //Добавляем в наш банк новый счет
                        bank.addCheck(check);
                    }

                    //Вызываем метод отображения панели со счетами
                    setJPanelAccount(bank);
                    //Вызываем метод отображения панели с банкоматами
                    setJPanelATM(bank);
                }
            }
        });

        //Создаем слушатель для подменю
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Создаем текстовое поле ввода
                JTextField jTextField = new JTextField();
                JTextField jTextField1 = new JTextField();
                //Собираем все в массив компонент и подписываем
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("ID"),
                        jTextField,
                        new JLabel("Адресс"),
                        jTextField1
                };

                //Аналогично предыдущему слушателю вызываем диалоговое окно
                int result = JOptionPane.showConfirmDialog(null, inputs, "Создать банкомат", JOptionPane.OK_CANCEL_OPTION);
                if(result == 0){
                    //Создаем банкомат, получая значения текстовых полей, и передаем их в конструктор
                    CashMachine cashMachine = new CashMachine(Integer.parseInt(jTextField.getText()), jTextField1.getText());
                    bank.addCashMachine(cashMachine);
                    //Снова собираем наши панели после обновления информации
                    setJPanelAccount(bank);
                    setJPanelATM(bank);
                    //И компонуем
                    jFrame.pack();
                }
            }
        });

    }

    //Метод для отображения стартовых элементов
    static void start(){
        //прикрепляем начальный пункт меню для возможности создать, открыть или сохранить файл
        jMenuFile.add(jMenuItemNew);
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.add(jMenuItemSave);
        jMenuBar.add(jMenuFile);
        jFrame.setJMenuBar(jMenuBar);
    }

    //Вывод вкладки с информацией о счетах
    static void setJPanelAccount(Bank bank){
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
                Check check = jList.getSelectedValue();

                //Создаем текстовое поле ввода
                JTextField jTextField = new JTextField();
                final JComponent[] inputs = new JComponent[]{
                        new JLabel("Введите сумму, которую вы хотите снять:"),
                        jTextField
                };
                //Выводим диалоговое окно
                int result = JOptionPane.showConfirmDialog(null, inputs, "Снятие со счета", JOptionPane.OK_CANCEL_OPTION);
                //Проверяем результат вызова диалогова окна
                if(result == 0){
                    //Вызываем соответсвующий метод для счета
                    check.removeSumma(Integer.parseInt(jTextField.getText()));
                }
            }
        });

        //добавляем кнопку на панель
        jPanel1.add(jButton);

    }

    //Вывод вкладки с информацией о банкоматах
    static void setJPanelATM(Bank bank) {
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
        JFrame jFrame = new JFrame() {};
        //Делаем его видимым
        jFrame.setVisible(true);
        //Создаем возможность закрыть окно
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Получаем инструменты необходимые для работы с экраном(разрешением)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Получаем разрешения экрана
        Dimension dimension = toolkit.getScreenSize();
        //Устанавливаем границы окна
        jFrame.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 500);
        //Задаем названия окна
        jFrame.setTitle("My app");
        return jFrame;
    }

}
