import java.util.Scanner;

/**
 * Класс для обработки массива целых чисел
 */
public class Main {


    public static Integer sum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }

        return sum;
    }

    public static Integer min(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Input string:");
        String line = scanner.nextLine();
        scanner.close();

        IntArrayParser parser = new IntArrayParser();
        parser.setLine(line);
        int[] numbers = new int[parser.getNumbersCount()];
        parser.parse(numbers);

        System.out.printf("Output string: %s%n", line);
        System.out.printf("Amount of numbers: %d%n", numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Number %d: %d%n", i+1, numbers[i]);
        }

        System.out.printf("Sum of numbers: %d%n", sum(numbers));
        System.out.printf("Sum of numbers: %d%n", min(numbers));
    }
}