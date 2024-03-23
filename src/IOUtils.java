import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class IOUtils {
    public static void checkInputFile(File file) {
        if (!file.exists()) {
            System.out.println("Input file does not exist");
            System.exit(1);
        } else if (!file.isFile()) {
            System.out.println("Input path is not a file");
            System.exit(2);
        }
    }

    public static char[] readCharArray(File file) {
        try {
            return Files.readString(file.toPath()).toCharArray();
        } catch (IOException e) {
            System.out.println("Failed to read input file");
            System.exit(3);
        }
        return null;
    }

    public static void writeString(File file, String string) {
        try {
            Files.writeString(file.toPath(), string);
        } catch (IOException e) {
            System.out.println("Failed to write to output file");
            System.exit(4);
        }
    }
}
