import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12, 9, 13, 4 ,6 ,2, 2, 12, 15));
        System.out.println("---");
        printNumberNumbersInListFunctional(List.of(12, 9, 13, 4 ,6 ,2, 2, 12, 15));
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // What to do?
        numbers.stream().forEach(System.out::println);
    }

    private static void printNumberNumbersInListFunctional(List<Integer> numbers) {
        // What to do?
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }



}
