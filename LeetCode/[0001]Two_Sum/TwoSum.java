import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        ArrayList<Pair<int[], int[]>> sols = twoSum.findAllPairWithSum(new int[]{1, 3, 1}, 4);
        for (Pair<int[], int[]> sol : sols) {
            System.out.print("{[");
            String str = "";
            for (int i : sol.first) {
                if (str.length() > 0) str += ",";
                str += i;
            }
            System.out.print(str + "],[");
            str = "";
            for (int i : sol.second) {
                if (str.length() > 0) str += ",";
                str += i;
            }
            System.out.println(str + "]}");
        }
    }

    public int[] findPairWithSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(numbers[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public ArrayList<Pair<int[], int[]>> findAllPairWithSum(int[] numbers, int target) {
        ArrayList<Pair<int[], int[]>> res = new ArrayList<>();
        HashSet<Pair<Integer, Integer>> dupElim = new HashSet<>();

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!hashMap.containsKey(numbers[i])) hashMap.put(numbers[i], new ArrayList<>());
            hashMap.get(numbers[i]).add(i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (!dupElim.contains(new Pair<>(numbers[i], complement)) && hashMap.containsKey(complement)) {
                res.add(new Pair<>(hashMap.get(complement).stream().mapToInt(Integer::intValue).toArray(),
                        hashMap.get(numbers[i]).stream().mapToInt(Integer::intValue).toArray()));
                dupElim.add(new Pair<>(complement, numbers[i]));
                dupElim.add(new Pair<>(numbers[i], complement));
            }
        }
        return res;
    }

    class Pair<T, U> {
        T first;
        U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {

            return Objects.hash(first, second);
        }
    }
}
