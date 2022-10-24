package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int TEST_AMOUNT = 100000;
    private static final int READ_AMOUNT = 1000;
    private static final int MUL_VALUE = 1000;


    private UseListsAndMaps() {
    }

    private static String timeToFill(List<Integer> list) {
	    long time = System.nanoTime();
	    for (int i=0; i<TEST_AMOUNT; i++) {
	        list.add(0, i);
	    }
	    time = System.nanoTime() - time;
	    final var millis = TimeUnit.NANOSECONDS.toMillis(time);
	    return millis + "";
    }

    private static String timeToRead(List<Integer> list) {
	    long time = System.nanoTime();
	    for (int i=0; i<READ_AMOUNT; i++) {
	        list.get(list.size()/2);
	    }
	    time = System.nanoTime() - time;
	    final var millis = TimeUnit.NANOSECONDS.toMillis(time);
	    return millis + "";
    }

    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> nums = new ArrayList<>();
	    for (int i=1000; i<2000; i++) {
	        nums.add(i);
	    }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> nums2 = new LinkedList<>(nums);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int tmp = nums.get(0);
	    nums.set(0, nums.get(nums.size()-1));
	    nums.set(nums.size()-1, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elem : nums) {
            System.out.println(elem);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        String time = timeToFill(nums);
	    System.out.println("Inserting " + TEST_AMOUNT + " elements in arraylist took " + time + " ms");
	    time = timeToFill(nums2);
	    System.out.println("Inserting " + TEST_AMOUNT + " elements in linkedlist took " + time + " ms");
        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = timeToRead(nums);
	    System.out.println("Reading " + READ_AMOUNT + " times the element at position " + nums.size()/2 + " in arraylist took " + time + " ms");
	    time = timeToRead(nums2);
	    System.out.println("Reading " + READ_AMOUNT + " times the element at position " + nums2.size()/2 + " in linkedlist took " + time + " ms");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Integer> continents = new HashMap<>();
        continents.put("Africa", 1110635);
        continents.put("Americas", 972005);
        continents.put("Antarctica", 0);
        continents.put("Asia", 4298723);
        continents.put("Europe", 742452);
        continents.put("Oceania", 38304);
        
        /*
         * 8) Compute the population of the world
         */
        long population = 0;
	    population = population + continents.get("Africa");
        population = population + continents.get("Americas");
        population = population + continents.get("Antarctica");
        population = population + continents.get("Asia");
        population = population + continents.get("Europe");
        population = population + continents.get("Oceania");
        population = population * MUL_VALUE;
	    System.out.println("World Population = " + population);
    }
}
