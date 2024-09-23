import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        HashList hashList = new HashList();
        int elementsAdded = 0;

        try {
            Scanner scanner = new Scanner(new File("src/sample.txt"));

            while (scanner.hasNextLine()) {
                hashList.addElement(scanner.nextLine());
                elementsAdded++;

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double load = (double) elementsAdded /hashList.capacatiy;

        System.out.println("\n");
        System.out.println("Load: " + elementsAdded);
        System.out.println("Capacity " + hashList.capacatiy);
        System.out.println("Load factor : " + load);

        System.out.println("\n");
        System.out.println("Degree of collisions : " + (double) hashList.collisions / elementsAdded);

        System.out.println("\n");
        System.out.println(hashList.checkIfStudentExists("Helle Vosmik Rosenlind"));
        System.out.println(hashList.checkIfStudentExists("Maximus"));
        System.out.println(hashList.checkIfStudentExists("Olav Sie Rotvær"));
        System.out.println(hashList.checkIfStudentExists("Sverre Frogner Haugen"));
    }
}