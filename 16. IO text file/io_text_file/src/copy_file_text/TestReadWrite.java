package copy_file_text;

import java.util.List;

public class TestReadWrite {

    public static int countCharactor(List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).length();
        }
        return count;
    }
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<String> list = readAndWriteFile.readFile("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\src\\copy_file_text\\string.txt");
        list.add(String.valueOf(countCharactor(list)));
        readAndWriteFile.writeFile("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\src\\copy_file_text\\result.txt",list);
    }
}
