package leetcode.insert_delete_getrandom_0380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
//import java.util.logging.Logger;

class RandomizedSet {
    //    private Logger LOGGER = Logger.getLogger(this.getClass().getName());
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> numbers;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        numbers = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
//        LOGGER.info("INSERT BEGIN:" + numbers);
        numbers.add(val);
        map.put(val, numbers.size() - 1);

//        LOGGER.info("INSERT END:" + numbers);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer index = map.remove(val);
        if (index == null) return false;

//        LOGGER.info("REMOVE BEGIN:" + numbers);

        swap(numbers, index, numbers.size() - 1);
        numbers.remove(numbers.size() - 1);

        if (numbers.size() != index)
            map.put(numbers.get(index), index);

//        LOGGER.info("REMOVE END: " + numbers);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int randIndex = ThreadLocalRandom.current().nextInt(0, numbers.size());
        return numbers.get(randIndex);
    }

    private void swap(ArrayList<Integer> arr, int i1, int i2) {
        int temp = arr.get(i1);
        arr.set(i1, arr.get(i2));
        arr.set(i2, temp);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */