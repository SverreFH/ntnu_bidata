
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int task = 0;
        System.out.println("Which task? ");
        Scanner inp = new Scanner(System.in);
        task = inp.nextInt();
        System.out.println("------------------");
        Fraction myObj = new Fraction(2,8);
        Fraction myObj2 = new Fraction(2,8);
        MinRandom rndObj = new MinRandom();

        switch (task) {
            case 1 -> {
                myObj.add(myObj2);
                myObj.toConsole();
            }
            case 2 -> {
                myObj.sub(myObj2);
                myObj.toConsole();
            }
            case 3 -> {
                myObj.mult(myObj2);
                myObj.toConsole();
            }
            case 4 -> {
                myObj.div(myObj2);
                myObj.toConsole();
            }
            case 5 -> {
                int intNumb = rndObj.randomNumb(3, 10);
                System.out.println(intNumb);
            }
            case 6 -> {
                double doubleNumb = rndObj.randomDesNumb(0.5, 0.923);
                System.out.println(doubleNumb);
            }
            case 7 -> rndObj.randomNumbWithDes(1.0, 6.5);
            default -> {
            }
        }
        inp.close();

        
    }

}
