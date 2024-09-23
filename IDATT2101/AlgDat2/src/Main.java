import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Handout for making sure the program runs for long enough to get valid data
        Date start = new Date();
        int rounds = 0;
        double time;
        Date end;
        do {
            calculator.recursiveCalculate(4000, 0.5);
            end = new Date();
            ++rounds;
        } while (end.getTime()-start.getTime() < 1000);
        time = (double)
                (end.getTime()-start.getTime()) / rounds;
        System.out.println("Milliseconds pr. round recursive calculator :" + time);

        // Handout for making sure the program runs for long enough to get valid data
        Date startOddEven = new Date();
        int roundsOddEven = 0;
        double timeOddEven;
        Date endOddEven;
        do {
            calculator.recursiveCalculateOddEven(4000, 0.5);
            endOddEven = new Date();
            ++roundsOddEven;
        } while (endOddEven.getTime()-startOddEven.getTime() < 1000);
        timeOddEven = (double)
                (endOddEven.getTime()-startOddEven.getTime()) / roundsOddEven;
        System.out.println("Milliseconds pr. round recursive calculator odd/even:" + timeOddEven);
    }
}