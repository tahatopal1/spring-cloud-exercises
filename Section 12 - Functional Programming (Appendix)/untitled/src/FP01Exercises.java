import java.util.List;

public class FP01Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println("E1: Print only odd numbers from the list");
        printOddNumbersInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        System.out.println("E2: Print all courses");
        courses.stream().forEach(System.out::println);

        System.out.println("E3: Print courses containing the word 'Spring'");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        System.out.println("E4: Print courses whose name has at least 4 letters");
        courses.stream()
                .filter(course -> course.length() > 3)
                .forEach(System.out::println);

        System.out.println("E5: Print squares of the numbers");
        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);

        System.out.println("E6: Print the cubes of odd numbers");
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number * number)
                .forEach(System.out::println);


    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .forEach(System.out::println);
    }
}
