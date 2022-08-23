package Test;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("text.txt");
        if (file.isFile()) {
            System.out.println("File");
        } else {
            System.out.println("Not found");
            file.createNewFile();
        }
    }
}
