package copy_file_nhi_phan;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void copyFile(File source, File target) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(target);

            byte[] buffer = new byte[1024];
            int length;
            int count = 0;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                count += length;
            }
            System.out.println("Tổng cộng: " + count + "byte" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File sourceFile;
        File targetFile;
        while (true) {
            System.out.println("Nhập file nguồn: ");
            String sourcePath = sc.nextLine();
            sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                int choosen = 0;
                System.err.println("File không tồn tại, vui lòng nhập lại");
                continue;
            }
            break;
        }


        while (true) {
            System.out.println("Nhập file đích: ");
            String targetPath = sc.nextLine();
            targetFile = new File(targetPath);
            if (targetFile.exists()) {
                int choosen = 0;
                System.err.println("File đã tồn tại, vui lòng lựa chọn");
                System.out.println("1. ghi đè");
                System.out.println("2. Nhập lại");
                while (true) {
                    try {
                        choosen = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    if (choosen == 1 || choosen == 2) {
                        break;
                    }
                    System.out.println("Vui lòng chọn lại: ");
                    System.out.println("1. ghi đè");
                    System.out.println("2. Nhập lại");
                }
                if (choosen == 1) {
                    break;
                }
                if (choosen == 2) {
                    continue;
                }

            }
            break;
        }
        copyFile(sourceFile, targetFile);
    }
}
