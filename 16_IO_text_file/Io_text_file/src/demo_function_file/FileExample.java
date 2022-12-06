package demo_function_file;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
//        exists() kiểm tra xem file có tồn tại hay không

//        getName() lấy tên file (input-file.txt)
//
//        getParent() lấy đường dẫn thư mục của file
//
//        getPath() đường dẫn đầy đủ
//
//        isDirectory() kiểm tra xem là thư mục hay không
//
//        isFile() kiểm tra xem là file hay không
//
//        length() cỡ file (byte)
//
//        createNewFile() tạo ra file mới
//
//        delete() xóa file
//
//        list() lấy tên file, thư mục chứa trong đường dẫn
//
//        mkdir() tạo thư mục
//
//        renameTo(File dest) đổi tên file
        File x = new File("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\result.txt");

        System.out.println("Tên file: " + x.getName());
        System.out.println("Đường dẫn thư mục: " + x.getParent());
        System.out.println("Đầy đủ " + x.getPath());
        System.out.println("exists(): " + x.exists());
        System.out.println(" isDirectory() : " + x.isDirectory());
        System.out.println("isFile(): " + x.isFile());
        System.out.println("length(): " + x.length());

        File newfile = new File("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\result.txt");
        System.out.println("rename to() :" + x.renameTo(newfile));

        System.out.println("list(): " + x.list());

        File file = new File("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\src\\newforder");
        file.mkdir();
    }
}
