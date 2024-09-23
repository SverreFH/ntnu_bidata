import java.util.ArrayList;
import java.util.Scanner;

/**
 * put hver case i sin egen metode i main
 * Bruk composisjon
 * Lag hjelpemetoder til metodene
 * Høy cohession lav kobling
 */
public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int task;

        Property test = new Property(1,"Test",4,7,"Dromstad",45.5,"Lars");
        ArrayList<Property> testList = new ArrayList<>();
        testList.add(test);
        PropertyRegister testRegister = new PropertyRegister(testList);


        int i = 0;
        while(i == 0){
            System.out.println("1: get the municipality number");
            System.out.println("2: get the municipality name");
            System.out.println("3: get the lot number");
            System.out.println("4: get the section number");
            System.out.println("5: get the name");
            System.out.println("6: get the area");
            System.out.println("7: get name of the owner");
            System.out.println("8: get property id");
            System.out.println("9: print property");
            System.out.println("10: add property");
            System.out.println("11: remove property");
            System.out.println("12: get number of properties in register");
            System.out.println("13: print properties");
            System.out.println("14: find property by id");
            System.out.println("15: average area of plots");
            System.out.println("16: find property by lot number");
            System.out.println("0: Cancel");
            task = inp.nextInt();
            inp.nextLine();
            switch (task){
                case 1:
                    System.out.println(test.getMunicipalityNumber());
                    break;
                case 2:
                    System.out.println(test.getMunicipalityName());
                    break;
                case 3:
                    System.out.println(test.getLotNumber());
                    break;
                case 4:
                    System.out.println(test.getSectionNumber());
                    break;
                case 5:
                    System.out.println(test.getName());
                    break;
                case 6:
                    System.out.println(test.getArea());
                    break;
                case 7:
                    System.out.println(test.getNameOfOwner());
                    break;
                case 8:
                    System.out.println(test.propertyId());
                    break;
                case 9:
                    System.out.println(test);
                    break;
                case 10:
                    System.out.println("Does the property have a name? y/n");
                    String hasName = inp.next();
                    System.out.println("Municipality number?");
                    int municipalityNumber = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Municipality name?");
                    String municipalityName = inp.next();
                    System.out.println("Lot number?");
                    int lotNumber = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Section number?");
                    int sectionNumber = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Area?");
                    double area = inp.nextDouble();
                    inp.nextLine();
                    System.out.println("Owners name?");
                    String ownersName = inp.next();
                    if(hasName.equalsIgnoreCase("y")){
                        System.out.println("Name?");
                        String name = inp.next();
                        inp.nextLine();
                        Property add = new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,name,area,ownersName);
                        testRegister.addProperty(add);
                    }
                    else{
                        Property add = new Property(municipalityNumber,municipalityName,lotNumber,sectionNumber,area,ownersName);
                        testRegister.addProperty(add);
                    }
                    System.out.println(testRegister);
                    break;
                case 11:
                    System.out.println("Municipality number of property being removed?");
                    int municipalityRemove = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Lot number of property being removed?");
                    int lotRemove = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Section number of property being removed?");
                    int sectionRemove = inp.nextInt();
                    inp.nextLine();
                    Property remove = testRegister.findProperty(municipalityRemove,lotRemove,sectionRemove);
                    testRegister.removeProperty(remove);
                    System.out.println(testRegister);
                    break;
                case 12:
                    System.out.println(testRegister.getNumberOfPropertiesInRegister());
                    break;
                case 13:
                    testRegister.printProperties();
                    break;
                case 14:
                    System.out.println("Municipality number of property being removed?");
                    int municipalityFind = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Lot number of property being removed?");
                    int lotFind = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Section number of property being removed?");
                    int sectionFind = inp.nextInt();
                    inp.nextLine();
                    System.out.println(testRegister.findProperty(municipalityFind,lotFind,sectionFind));
                    break;
                case 15:
                    System.out.println(testRegister.averageAreOfProperties());
                    break;
                case 16:
                    System.out.println("Lot number?");
                    int lotToFind = inp.nextInt();
                    inp.nextLine();
                    System.out.println(testRegister.findPropertiesWithLotNumber(lotToFind));
                    break;
                case 0:
                    i++;
                    break;
            }
        }
    }
}