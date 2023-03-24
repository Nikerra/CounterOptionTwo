import java.io.*;

public class LoadCounter {
    private static int counter;

    static Integer load() {
        try(ObjectInputStream objIstr = new ObjectInputStream(new FileInputStream(CounterService.getFileName()))) {
            counter = objIstr.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }

}
