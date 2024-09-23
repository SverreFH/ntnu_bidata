import java.util.Random;

public class MainPart2 {
    public static void main(String[] args) {
        Random random = new Random();
        int capacity = 10000019; //Prime number
        long[] randomList = new long[capacity];
        randomList[0] = random.nextInt(1000);

        for(int i = 1; i < capacity; i++){
            randomList[i] = randomList[i - 1] + random.nextInt(1000) + 1;
        }

        Random rnd = new Random();
        for (int i = 0; i < randomList.length; i++){
            int randomIndex = i + rnd.nextInt(randomList.length - i);
            long temp = randomList[i];
            randomList[i] = randomList[randomIndex];
            randomList[randomIndex] = temp;
        }

        int[] percentages = {50, 80, 90, 99, 100};

        for (int percentage : percentages){
            int numInsertions = (int) ((capacity * percentage)/100.0);

            long start = System.nanoTime();
            LinearProbe linearProbe = new LinearProbe(capacity);
            for (int i = 0; i < numInsertions; i++){
                linearProbe.probeAdd(randomList[i]);
            }
            long end = System.nanoTime();
            long elapsed = (end - start) / 1000000;
            System.out.println("Linear Probing for " + percentage + "% Collisions = " +
                    linearProbe.collisions + " Time: " + elapsed + " ms");
        }

        for (int percentage : percentages) {
            int numInsertions = (int) ((capacity * percentage) / 100.0);

            long start = System.nanoTime();
            DoubleHash doubleHash = new DoubleHash(capacity);
            for (int i = 0; i < numInsertions; i++) {
                doubleHash.insert(randomList[i]);
            }
            long end = System.nanoTime();
            long elapsed = (end - start) / 1000000;
            System.out.println("Double hashing for " + percentage + "% Collisions = " +
                    doubleHash.collisions + " Time: " + elapsed + " ms");
        }
    }
}
