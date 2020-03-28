package leetcode;


import org.junit.Test;

import java.util.*;

/*
https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            list.set(index, lastElement);
            map.put(lastElement, index);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    @Test
    public void test() {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));

    }
}
