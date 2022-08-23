package copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public List<String> readFile(String filepath) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filepath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return list;
    }

    public void writeFile(String filePath, List<String> list) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write("\n" + list.get(i));
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
