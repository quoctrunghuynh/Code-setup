import java.util.List;

public class FindMaxValue {
    public static int FindMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWrite raw = new ReadAndWrite();
        List<Integer> numbers = raw.ReadFile("numbers.txt");
        int maxValue = FindMax(numbers);
        raw.WriteFile("result.txt",maxValue);
    }
}
