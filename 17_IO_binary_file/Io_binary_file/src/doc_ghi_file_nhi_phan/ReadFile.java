package doc_ghi_file_nhi_phan;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("testText.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

