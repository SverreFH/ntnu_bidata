import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("Ola", "Nordman", 1978, 123,1990,60000.0, 35.0);
        Scanner inp = new Scanner(System.in);

        int i = 0;
        while(i==0){
            System.out.println("Getting or editing data?");
            System.out.println("1: Getting");
            System.out.println("2: Editing");
            System.out.println("0: cancel");
            int task = inp.nextInt();
            if(task == 1){
                int j = 0;
                while (j==0) {
                    System.out.println("1: Get Employee Info");
                    System.out.println("2: Get Employee number");
                    System.out.println("3: Get Employment Year");
                    System.out.println("4: Get Monthly Salary");
                    System.out.println("5: Get Tax Rate");
                    System.out.println("6: Get Employee Taxed Per Month");
                    System.out.println("7: Get Employee salary per year");
                    System.out.println("8: Get Employee Taxes Per Year");
                    System.out.println("9: Get Employee Name");
                    System.out.println("10: Get Employee age");
                    System.out.println("11: Get Employee Years Employed");
                    System.out.println("12: Check Employee employed more than 20 years");
                    System.out.println("0: Cancel");
                    task = inp.nextInt();
                    switch (task) {
                        case 1 -> {
                            System.out.println(emp.getPersonInfo().getBirthYear());
                            System.out.println(emp.getPersonInfo().getSirName());
                            System.out.println(emp.getPersonInfo().getFistName());
                        }
                        case 2 -> System.out.println(emp.getEmployeeNumber());
                        case 3 -> System.out.println(emp.getEmploymentYear());
                        case 4 -> System.out.println(emp.getMonthlySalary());
                        case 5 -> System.out.println(emp.getTaxes());
                        case 6 -> System.out.println(emp.taxedPerMonth());
                        case 7 -> System.out.println(emp.salaryPerYear());
                        case 8 -> System.out.println(emp.taxedPerYear());
                        case 9 -> System.out.println(emp.employeeName());
                        case 10 -> System.out.println(emp.employeeAge());
                        case 11 -> System.out.println(emp.yearsEmployed());
                        case 12 -> System.out.println(emp.employedMoreThanXYears(20));
                        case 0 -> j++;
                    }
                }
            }

            else if(task == 2){
                int j = 0;
                while(j==0){
                    System.out.println("1: Change employee name");
                    System.out.println("2: Change employee salary");
                    System.out.println("3: change employee taxes");
                    System.out.println("0: cancel");
                    task = inp.nextInt();
                    switch (task){
                        case 1 -> {
                            Scanner txtInp = new Scanner(System.in);
                            System.out.println("New first name?");
                            String firstname = txtInp.next();
                            System.out.println("New sir name?");
                            String lastname = txtInp.next();
                            emp.setPersonInfo(firstname, lastname);
                            System.out.println(emp.getPersonInfo().getFistName());
                            System.out.println(emp.getPersonInfo().getSirName());
                        }
                        case 2 -> {
                            System.out.println("New salary?");
                            Scanner doubleInp = new Scanner(System.in);
                            double newSal = doubleInp.nextDouble();
                            emp.setMonthlySalary(newSal);
                            System.out.println(emp.getMonthlySalary());
                        }
                        case 3 -> {
                            System.out.println("New tax?");
                            Scanner doubleInp = new Scanner(System.in);
                            double newTax = doubleInp.nextDouble();
                            emp.setTaxes(newTax);
                            System.out.println(emp.getTaxes());
                        }
                        case 0 -> j++;
                    }
                }
            }

            else{
                i++;
            }
        }
    }
}
