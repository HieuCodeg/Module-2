package tim_max;

import java.util.List;

public class FindMaxValue {

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\src\\tim_max\\number.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("C:\\GitHub\\Module-2\\16. IO text file\\io_text_file\\src\\tim_max\\result.txt", maxValue);
    }
}
