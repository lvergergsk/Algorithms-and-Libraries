import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamNotes {

    Integer[] intArrayToIntegerArray(int[] ints) {
        return Arrays.stream(ints).boxed().toArray(Integer[]::new);
    }

    ArrayList<Integer> intArrayToIntegerArrayList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    List<Integer> intArrayToIntegerList(int[] ints) {
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    int[] integerArrayToIntArray(Integer[] integers) {
        return Arrays.stream(integers).mapToInt(i -> i).toArray();
    }

    int[] integerArrayListToIntArray(ArrayList<Integer> integers) {
        return integers.stream().mapToInt(i -> i).toArray();
    }

    int[] integerLListToIntArray(List<Integer> integers) {
        return integers.stream().mapToInt(i -> i).toArray();
    }
}
