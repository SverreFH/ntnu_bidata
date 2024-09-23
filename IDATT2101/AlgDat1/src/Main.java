import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] stockArray = Main.generateRandomStockList(100000);
        //int[] stockArray = new int[]{-1, 3, -9, 2, 2, -1, 2, -1, -5};
        StockCalculator calculator = new StockCalculator(stockArray);

        // Handout for making sure the program runs for long enough to get valid data
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do {
            calculator.calculate();
            end = new Date();
            ++rounds;
        } while (end.getTime()-start.getTime() < 1000);
        time = (double)
                (end.getTime()-start.getTime()) / rounds;
        System.out.println("Milliseconds pr. round:" + time);

        System.out.println("Buy date : " + calculator.getBuyDate());

        System.out.println("Sell date : " + calculator.getSellDate());
    }

    public static int[] generateRandomStockList(int amountOfValues){
        int[] randomStockValues = new int[amountOfValues];
        Random rd = new Random();
        for(int i = 0; i < amountOfValues; i++){
            int randomValue = rd.nextInt(41)-20;
            randomStockValues[i] = randomValue;
        }

        System.out.println(Arrays.toString(randomStockValues));
        return randomStockValues;
    }
}

