import java.io.File;

public class IsFileExists {
    private static int counter;

    static int fileExists() {
//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска)
        File file = new File(CounterService.getFileName());

        if (!file.exists()) {
            counter = 0;
        } else {
            counter = LoadCounter.load();
        }
        return counter;
    }

}
