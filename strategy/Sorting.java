import java.util.Arrays;
import java.util.Random;

public class Sorting {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int[] smallArray = new int[30];
        int[] bigArray = new int[100000];

        populateData(smallArray);
        populateData(bigArray);

        SortContext sorter = new SortContext();

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(smallArray));
        System.out.println();

        testAlgorithm(sorter, new BubbleSortStrategy(), "Bubble Sort", smallArray, bigArray);
        testAlgorithm(sorter, new SelectionSortStrategy(), "Selection Sort", smallArray, bigArray);
        testAlgorithm(sorter, new MergeSortStrategy(), "Merge Sort", smallArray, bigArray);
    }

    // Runs timing tests
    public static void testAlgorithm(
            SortContext sorter,
            SortStrategy strategy,
            String name,
            int[] smallArray,
            int[] bigArray
    ) {

        int[] smallCopy = smallArray.clone();
        int[] bigCopy = bigArray.clone();

        sorter.setStrategy(strategy);

        System.out.println("----- " + name + " -----");

        long startSmall = System.nanoTime();
        sorter.executeSort(smallCopy);
        long endSmall = System.nanoTime();

        long startBig = System.nanoTime();
        sorter.executeSort(bigCopy);
        long endBig = System.nanoTime();

        System.out.println("Small array time: " + (endSmall - startSmall) / 1_000_000.0 + " ms");
        System.out.println("Big array time:   " + (endBig - startBig) / 1_000_000.0 + " ms");
        System.out.println();
    }

    // Populate arrays with random numbers
    public static void populateData(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(array.length);
        }
    }
}