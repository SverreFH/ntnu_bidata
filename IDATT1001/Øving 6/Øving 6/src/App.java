
import java.util.Random;
import java.util.Scanner;

public class App {


    public static void countRndNumb(int numbRounds) {
        Random random = new java.util.Random();

        int[] myList = new int[10];

        for(int i = 0; i < numbRounds; i++){
            int rndInt = random.nextInt(10);
            if(rndInt == 0){
                myList[0] ++;
            }
            else if(rndInt == 1){
                myList[1] ++;
            }
            else if(rndInt == 2){
                myList[2] ++;
            }
            else if(rndInt == 3){
                myList[3] ++;
            }
            else if(rndInt == 4){
                myList[4] ++;
            }
            else if(rndInt == 5){
                myList[5] ++;
            }
            else if(rndInt == 6){
                myList[6] ++;
            }
            else if(rndInt == 7){
                myList[7] ++;
            }
            else if(rndInt == 8){
                myList[8] ++;
            }
            else if(rndInt == 9){
                myList[9] ++;
            }
        }
        for(int j = 0; j < 10; j++){
            double numbStars = (double) myList[j] / (double) 10;
            int numbStarsInt = (int)Math.round(numbStars);
            System.out.print(j + " : " + myList[j] + " ");
            for(int i = 0; i < numbStarsInt; i ++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static int[][] makeMatrix(int height, int width){
        Scanner inp = new Scanner(System.in);
        int numb = 0;
        int[][] matrix = new int[height][width];
        for(int i = 0; i < height; i++){
            //System.out.println("Line number: " + (i+1) + " of the matrix");
            for(int j = 0; j < width; j++){
                System.out.println("Number in pos line: " + (i+1) + " , sylinder: " + (j+1) + "?");
                numb = inp.nextInt();
                matrix[i][j] = numb;
            }
        }
        //inp.close();
        return matrix;
    }

    public static void printMatrix(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Which task to run?");
        System.out.println("1: CountRndNumb");
        System.out.println("2: Count total letters");
        System.out.println("3: Count unique letters");
        System.out.println("4: Prosent letter");
        System.out.println("5: Number of spesific letter");
        System.out.println("6: most commen letter");
        System.out.println("7: add matrix");
        System.out.println("8: mult matrix");
        System.out.println("9: trans matrix");
        int task = 0;
        
        Scanner inp = new Scanner(System.in);
        task = inp.nextInt();
        inp.nextLine();
        
        //inp.close();
        

        switch (task) {
            case 1:
                countRndNumb(500);
                break;
            
            case 2:
                int i = 1;
                while(i != 0){
                    String text = "";
                    System.out.println("Enter text or write stop to stop");
                    text = inp.next();
                    if(text.equals("stop")){
                        i--;
                    }
                    else{
                        TextAnalyse myCase = new TextAnalyse(text);
                        System.out.println(myCase.totalLetters());
                    }
                }
                break;

            case 3:
                i = 1;
                while(i != 0){
                    String text = "";
                    System.out.println("Enter text or write stop to stop");
                    text = inp.next();
                    if(text.equals("stop")){
                        i--;
                    }
                    else{
                        TextAnalyse myCase = new TextAnalyse(text);
                        System.out.println(myCase.uniqueLetters());
                    }
                }
                break;
                
            case 4:
                i = 1;
                while(i != 0){
                    String text = "";
                    System.out.println("Enter text or write stop to stop");
                    text = inp.next();
                    if(text.equals("stop")){
                        i--;
                    }
                    else{
                        TextAnalyse myCase = new TextAnalyse(text);
                        System.out.println(myCase.prosentLetters());
                    }
                }
                break;
            
            case 5:
                i = 1;
                while(i != 0){
                    String text = "";
                    char letter = 'a';
                    System.out.println("Enter text or write stop to stop");
                    text = inp.next();
                    
                    if(text.equals("stop")){
                        i--;
                    }
                    else{
                        System.out.println("Letter to find instances off?");
                        letter = inp.next().charAt(0);
                        TextAnalyse myCase = new TextAnalyse(text);
                        System.out.println(myCase.numberOfLetter(letter));
                    }
                }
                break;

            case 6:
                i = 1;
                while(i != 0){
                    String text = "";
                    System.out.println("Enter text or write stop to stop");
                    text = inp.next();
                    if(text.equals("stop")){
                        i--;
                    }
                    else{
                        TextAnalyse myCase = new TextAnalyse(text);
                        System.out.println(myCase.mostCommonLetter());
                    }
                }
                break;

            case 7:
                int[][] listOneAdd = makeMatrix(3, 3);
                int[][] listTwoAdd = makeMatrix(3, 3);
                Matrix matrixOneAdd = new Matrix(listOneAdd);
                Matrix matrixTwoAdd = new Matrix(listTwoAdd);
                int[][] matrixAddResult = matrixOneAdd.add(matrixTwoAdd);
                printMatrix(matrixAddResult);
                break;

            case 8:
                int[][] listOneMult = makeMatrix(3, 3);
                int[][] listTwoMult = makeMatrix(3, 3);
                Matrix matrixOneMult = new Matrix(listOneMult);
                Matrix matrixTwoMult = new Matrix(listTwoMult);
                int[][] matrixMultResult = matrixOneMult.mult(matrixTwoMult);
                printMatrix(matrixMultResult);
                break;

            case 9:
                int[][] lisTrans = makeMatrix(3, 2);
                Matrix matrixTrans = new Matrix(lisTrans);
                int[][] matrixTransResult = matrixTrans.trans();
                printMatrix(matrixTransResult);
                break;

            default:
                break;
        }
        inp.close();

        
        
        
        
        
        
        

    }
    
}
