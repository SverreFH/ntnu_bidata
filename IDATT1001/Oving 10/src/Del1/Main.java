package Del1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Arrangement test = new Arrangement(543,"a", "London", "TestCo", "testType", 200310301700L);
        Arrangement test2 = new Arrangement(542, "c", "Oslo", "TestCo","bestType",200210301800L);
        Arrangement test3 = new Arrangement(541, "b", "Brazil", "TestCo", "testType", 200210301600L);
        ArrangementRegister testRegister = new ArrangementRegister();
        testRegister.addArrangement(test);
        testRegister.addArrangement(test2);

        Scanner inp = new Scanner(System.in);
        int i = 0;
        while(i==0) {
            System.out.println("1: Add Arrangement");
            System.out.println("2: Find Arrangements at location");
            System.out.println("3: Find Arrangements at date");
            System.out.println("4: Find Arrangements within time range");
            System.out.println("5: Sort Arrangements by time");
            System.out.println("6: Sort Arrangements by location");
            System.out.println("7: Sort Arrangements by type");
            System.out.println("0: cancel");
            int task = inp.nextInt();
            inp.nextLine();
            switch (task) {
                case 1:
                    System.out.println("Arrangement number?");
                    int number = inp.nextInt();
                    System.out.println("Name of arrangement?");
                    String name = inp.next();
                    System.out.println("Location of arrangement?");
                    String location = inp.next();
                    System.out.println("Company behind arrangement?");
                    String company = inp.next();
                    System.out.println("Type of arrangement?");
                    String type = inp.next();
                    System.out.println("Date of arrangement?");
                    long date = inp.nextLong();
                    Arrangement arrangement = new Arrangement(number, name, location, company, type, date);
                    testRegister.addArrangement(arrangement);
                    break;
                case 2:
                    System.out.println("Location?");
                    String locationToCheck = inp.next();
                    System.out.println(testRegister.findArrangementsAtLocation(locationToCheck));
                    break;
                case 3:
                    System.out.println("Date?");
                    long dateToCheck = inp.nextLong();
                    System.out.println(testRegister.findArrangementsAtDate(dateToCheck));
                    break;
                case 4:
                    System.out.println("Lower limit?");
                    long lowerLimit = inp.nextLong();
                    System.out.println("Upper limit?");
                    long upperLimit = inp.nextLong();
                    System.out.println(testRegister.ArrangementsWithinTimeRange(lowerLimit, upperLimit));
                    break;
                case 5:
                    testRegister.listSortedByTime();
                    System.out.println(testRegister);
                    break;
                case 6:
                    testRegister.listSortedByPlace();
                    System.out.println(testRegister);
                    break;
                case 7:
                    testRegister.listSortedByType();
                    System.out.println(testRegister);
                    break;
                case 0:
                    i++;
                    break;
            }
        }
    }
}