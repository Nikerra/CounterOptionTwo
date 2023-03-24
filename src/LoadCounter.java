import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoadCounter {
    public static int loadCounter() {
        int counter = 0;

        try(FileReader fr = new FileReader("exemple.txt")) {
            Scanner scanner = new Scanner(fr);
            counter = Integer.parseInt(String.valueOf(scanner.nextInt()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }
}
