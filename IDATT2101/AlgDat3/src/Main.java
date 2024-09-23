import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] randomList = createRandomList();
        int[] copiedListRandom = Arrays.copyOf(randomList, randomList.length);
        int[] alternatingList = createAlternatingList();
        int[] copiedListAlternating = Arrays.copyOf(alternatingList, alternatingList.length);
        int randomListSumBefore = Arrays.stream(randomList).sum();
        int copiedListRandomSumBefore = Arrays.stream(copiedListRandom).sum();
        int alternatingListSumBefore = Arrays.stream(alternatingList).sum();
        int copiedListAlternatingSumBefore = Arrays.stream(copiedListAlternating).sum();

        Date startRandom = new Date();
        double timeRandom;
        sorter.quicksort(randomList, 0, randomList.length - 1);
        Date endRandom = new Date();
        timeRandom = (double) endRandom.getTime() - startRandom.getTime();
        System.out.println("Ms for sorting of random list using quick sort : " + timeRandom);
        checkListSorting(randomList, randomListSumBefore);

        Date startRandomSorted = new Date();
        double timeRandomSorted;
        sorter.quicksort(randomList, 0, randomList.length - 1);
        Date endRandomSorted = new Date();
        timeRandomSorted = (double) endRandomSorted.getTime() - startRandomSorted.getTime();
        System.out.println("Ms for sorting of already sorted list using quick sort : " + timeRandomSorted);
        checkListSorting(randomList, randomListSumBefore);


        Date startRandomMod = new Date();
        double timeRandomMod;
        sorter.quicksortModified(copiedListRandom, 0, copiedListRandom.length - 1, 55);
        Date endRandomMod = new Date();
        timeRandomMod = (double) endRandomMod.getTime() - startRandomMod.getTime();
        System.out.println("Ms for sorting of random list using modified quick sort : " + timeRandomMod);
        checkListSorting(copiedListRandom, copiedListRandomSumBefore);


        Date startRandomModSorted = new Date();
        double timeRandomModSorted;
        sorter.quicksortModified(copiedListRandom, 0, copiedListRandom.length - 1, 55);
        Date endRandomModSorted = new Date();
        timeRandomModSorted = (double) endRandomModSorted.getTime() - startRandomModSorted.getTime();
        System.out.println("Ms for sorting of already sorted list using modified quick sort : " + timeRandomModSorted);
        checkListSorting(copiedListRandom, copiedListRandomSumBefore);

        Date startAlternating = new Date();
        double timeAlternating;
        sorter.quicksort(alternatingList, 0, alternatingList.length - 1);
        Date endAlternating = new Date();
        timeAlternating = (double) endAlternating.getTime() - startAlternating.getTime();
        System.out.println("Ms for sorting of  alternating list using quick sort : " + timeAlternating);
        checkListSorting(alternatingList, alternatingListSumBefore);

        Date startAlternatingSorted = new Date();
        double timeAlternatingSorted;
        sorter.quicksort(alternatingList, 0, alternatingList.length - 1);
        Date endAlternatingSorted = new Date();
        timeAlternatingSorted = (double) endAlternatingSorted.getTime() - startAlternatingSorted.getTime();
        System.out.println(("Ms for sorting of already sorted alternating list using quick sort : " + timeAlternatingSorted));
        checkListSorting(alternatingList, alternatingListSumBefore);

        Date startAlternatingMod = new Date();
        double timeAlternatingMod;
        sorter.quicksortModified(copiedListAlternating, 0, copiedListAlternating.length - 1, 55);
        Date endAlternatingMod = new Date();
        timeAlternatingMod = endAlternatingMod.getTime() - startAlternatingMod.getTime();
        System.out.println("Ms for sorting of alternating list modified quick sort : " + timeAlternatingMod);
        checkListSorting(copiedListAlternating, copiedListAlternatingSumBefore);

        Date startAlternatingModSorted = new Date();
        double timeAlternatingModSorted;
        sorter.quicksortModified(copiedListAlternating, 0, copiedListAlternating.length - 1, 55);
        Date endAlternatingModSorted = new Date();
        timeAlternatingModSorted = endAlternatingModSorted.getTime() - startAlternatingModSorted.getTime();
        System.out.println("Ms for sorting of already sorted alternating list using modified quick sort : " + timeAlternatingModSorted);
        checkListSorting(copiedListAlternating, copiedListAlternatingSumBefore);
    }

    public static int[] createRandomList(){
        int[] randomList = new int[1000000];
        for(int i = 0; i < randomList.length; i++){
            randomList[i] = (int) (Math.random() * 100000);
        }
        return randomList;
    }

    public static int[] createAlternatingList(){
        int[] alternatingList = new int[1000000];
        for(int i = 0; i < alternatingList.length; i++){
            if ((i & 1) == 0){
                alternatingList[i] = (int) (Math.random() * 100000);
            } else {
                alternatingList[i] = 42;
            }
        }
        return alternatingList;
    }

    public static void checkListSorting(int[] list, int sumBefore){
        //Testing to se if sort has happened correctly
        for (int i = 1; i <= list.length - 1; i++){
            if(list[i] < list[i-1]){
                System.out.println("Comparison test failed");
                break;
            }
        }

        if(sumBefore != Arrays.stream(list).sum()) System.out.println("Sum test failed");
    }
}