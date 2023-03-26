import java.io.File;
import java.io.ObjectInputStream;
import java.util.Optional;

public class IsFileExists {
    protected int fileExists() {
//      Для работы счетчика через файл проверяем наличие файла куда будем писать его данные и если
//      не нашли то создаем файл(так же для первого запуска)
        File file = new File(new CounterService().getFileName());
        if (!file.exists()) {
            return 0;
        } else {
            return new LoadCounter().load();
        }

//        return Optional.ofNullable(new File(new CounterService().getFileName()))
//                .filter(File::exists)
//                .map(f->new LoadCounter().load())
//                .orElse(0);
    }

}
