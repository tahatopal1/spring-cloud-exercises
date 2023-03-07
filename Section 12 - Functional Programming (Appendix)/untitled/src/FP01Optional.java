import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FP01Optional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "mango");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        System.out.println("Second exercise: ");
        predicate = fruit -> fruit.startsWith("c");
        optional = fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        //System.out.println(optional.get()); // throws error

        Optional<String> fruit = Optional.of("banana");
        Optional<String> empty = Optional.empty();


    }
}
