import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        NewString str = new NewString("denne setningen kan forkortes.");
        TextFormating txt = new TextFormating("dennæ setningen kan forkortes. Sånn som det her.");
        Scanner inp = new Scanner(System.in);
        int i = 0;
        while(i == 0){
            int task = 0;
            System.out.println("Which task to run?");
            System.out.println("1: Abreviate");
            System.out.println("2: Remove Char");
            System.out.println("3: Total Words");
            System.out.println("4: Average length of words in text");
            System.out.println("5: Average amount of words per sentence");
            System.out.println("6: Replace word in text");
            System.out.println("7: Print text");
            System.out.println("8: Print text capitalized");
            System.out.println("0: Stop");;
            
            task = inp.nextInt();
            switch (task) {
                case 1:
                    System.out.println(str.abreviate());
                    break;
            
                case 2:
                    System.out.println(str.removeChar("e"));
                    break;

                case 3:
                    System.out.println(txt.totalWords());
                    break;

                case 4:
                    System.out.println(txt.averageWordLength());
                    break;

                case 5:
                    System.out.println(txt.averageWordsPerPeriode());
                    break;

                case 6:
                    System.out.println(txt.replaceWord("det", "dette"));
                    break;

                case 7: 
                    System.out.println(txt.getText());
                    break;

                case 8:
                    System.out.println(txt.getTextCapitalized());
                    break;
                case 0:
                    i++;
                    break;

                default:
                    break;
            }
        }

        inp.close();
    }
}
