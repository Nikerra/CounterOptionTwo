import java.io.*;

public class LoadCounter {
    private static int counter;

    protected Integer load() {
        try(ObjectInputStream objIstr = new ObjectInputStream(new FileInputStream(new CounterService().getFileName()))) {
            counter = objIstr.readInt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }

}
