import java.io.*;
import java.util.Locale;


public class CounterService {
    private final static String INC = "/inc";
    private final static String STOP = "/stop";
    private final static String RESET = "/reset";
    private static String fileName = "serial";
    private static int counter;
    private static boolean flag = true;
    private static String command = "";


    public  String getFileName() {
        return fileName;
    }


    //  Работа счетчика
    protected int work() {

        counter =  new IsFileExists().fileExists();//вызов метода для проверки наличия файла и получения состояния счетчика
        System.out.println("Счетчик загружен, значение \'" + counter + "\'");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Запускаем цикл и ждем команду
// Пока не введена команда /stop

        while (flag) {
            try {
                command = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            command = command.toLowerCase(Locale.ROOT);//чтобы игнорировать регистр команды

//  В switch проверяем команду и выполняем соответствующие действие;
//  Так же добавляем default чтобы выводить автоответ на все другие
//  варианты ввода в консоль.
            switch (command) {
                case INC -> {
                    System.out.println("Состояние счетчика увеличенно на одну единицу");
                    counter++;
                    print();
                }
                case STOP -> {
                    print();
                    System.out.println("\"Завершаю работу\"");
                    new SaveCounter().save(counter);
                    flag = false;
                }
                case RESET -> {
                    counter = 0;
                    print();
                }
                default -> System.out.println("Команда не найдена");

            }
        }
        return counter;
    }
    private  void print(){System.out.println("Текущее состояние счетчика \'" + counter + "\'");}

}