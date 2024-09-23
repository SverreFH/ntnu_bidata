import java.util.Random;
import java.text.DecimalFormat;

public class MinRandom{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private Random rnd= new java.util.Random();

    public MinRandom(){};

    public int randomNumb(int lower, int upper){
        int i = 0;
        int numb = 0;
        while(i == 0){
            numb = rnd.nextInt(upper + 1);
            if(numb > lower){
                i++;
            }
        }
        return numb;
    }

    public double randomDesNumb(double lower, double upper){
        int i = 0;
        double numb = 0;
        while(i == 0){
            numb = rnd.nextDouble();
            if(numb > lower && numb < upper){
                i++;
            }
        }
        return numb;
    }

    public void randomNumbWithDes(double lower, double upper){
        
        int intLow = (int) lower;
        int intUpp = (int) upper;
        double doubLow = lower - (double) intLow;
        double doubUpp = upper - (double) intUpp;
        int intNumb = randomNumb(intLow, intUpp);
        double doubNumb = randomDesNumb(doubLow, doubUpp);
        double fullNumb = (double) intNumb + doubNumb;
        System.out.println("Random numb is " + df.format(fullNumb));
    }
}