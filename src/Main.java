import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    final static String INC = "/inc";
    final static String STOP = "/stop";
    final static String RESET = "/reset";

    public static void main(String[] args) {
//      Переменные для работы счетчика
        int counter = 0;
        boolean flag = true;
        String command = "";

//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска
        File file = new File("exemple.txt");
        if (!file.exists()) {
            counter = 0;
        } else {
            counter = LoadCounter.loadCounter();
        }
//

        System.out.println("Добрый день я простой счетчик, для моей работы введите" +
                "в консоле одну из команд: \nкоманда /inc увеличит мое значение на одну единицу" +
                "\nкоманда /stop остановит мою работу и запомнит состояние" +
                "\nкоманда /reset сбросит мой показатель обратно к нулю");
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
            //command = command.toLowerCase(Locale.ROOT);

//  В switch проверяем команду и выполняем соответствующие действие;
//  Так же добавляем default чтобы выводить автоответ на все другие
//  варианты ввода в консоль.
            switch (command) {
                case INC -> {
                    System.out.println("Состояние счетчика увеличенно на одну единицу");
                    counter++;
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                }
                case STOP -> {
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                    System.out.println("\"Завершаю работу\"");
                    SaveCounter.saveCounter(counter);
                    flag = false;
                }
                case RESET -> {
                    counter = 0;
                    System.out.println("Текущее состояние счетчика \'" + counter + "\'");
                }
                default -> System.out.println("Команда не найдена");
            }
        }
    }
}