import java.util.Calendar;

public class Employee {
    private Person personInfo;
    int employeeNumber;
    int employmentYear;
    Double monthlySalary;
    Double taxes;

    /**
     * This method initializes an object of the Employee class
     * @param firstName the employees first name
     * @param sirName   the employees last name
     * @param birthYear the employees birthYear
     * @param en        the employees employment number
     * @param ey        the year the employee got employed
     * @param ms        the employee's monthly salary
     * @param t         the employee's monthly taxes
     */
    Employee(String firstName, String sirName, int birthYear, int en, int ey, Double ms, Double t){
        personInfo = new Person(firstName, sirName, birthYear);
        employeeNumber = en;
        employmentYear = ey;
        monthlySalary = ms;
        taxes = t;
    }

    /**
     * Gets the persons full name
     * @return returns persons name
     */
    Person getPersonInfo(){return personInfo;}

    /**
     * Gets the employees employment number
     * @return employment number
     */
    int getEmployeeNumber(){return employeeNumber;}

    /**
     * Gets the employment year
     * @return  year of employment
     */
    int getEmploymentYear(){return employmentYear;}

    /**
     * Gets the monthly salary
     * @return monthly salary
     */
    Double getMonthlySalary(){return monthlySalary;}

    /**
     * Gets the monthly tax rate
     * @return  monthly tax rate
     */
    Double getTaxes(){return taxes;}

    /**
     * Updates person's first and last name
     * @param f first name
     * @param s sir name
     */
    void setPersonInfo(String f, String s){
        personInfo.setFirstName(f);
        personInfo.setSirName(s);
    }

    /**
     * Updates a employee's monthly salary
     * @param newSalary new salary
     */
    void setMonthlySalary(double newSalary){
        monthlySalary = newSalary;
    }

    /**
     * Updates a employee's monthly tax rate
     * @param newTaxes new tax rate
     */
    void setTaxes(double newTaxes){
        taxes = newTaxes;
    }

    /**
     * Checks how much of monthly salary goes to taxes
     * @return amount paid in taxes per month
     */
    double taxedPerMonth(){
        return monthlySalary * (taxes/100);
    }

    /**
     * Calculates how much an employee makes in a year
     * @return  total yearly salary
     */
    double salaryPerYear(){
        return 12 * monthlySalary;
    }

    /**
     * Calculates how much an employee has to pay in taxes over a year
     * @return  Total amount paid in taxes for a year
     */
    double taxedPerYear(){
        return taxedPerMonth() * 10.5;
    }

    //Works together
    /**
     * Combines first and last name
     * @return  combined name
     */
    String employeeName(){
        String firstName = getPersonInfo().getFistName();
        String sirName = getPersonInfo().getSirName();
        return sirName + " " + firstName;
    }

    //Works together
    /**
     * Calculates employee's age
     * @return age
     */
    int employeeAge(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - getPersonInfo().getBirthYear();
    }

    /**
     * Calculates years employed
     * @return years employed
     */
    int yearsEmployed(){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - getEmploymentYear();
    }

    /**
     * Checks if an employee had worked at company more than x years
     * @param x years to check against
     * @return  true/false
     */
    boolean employedMoreThanXYears(int x) {
        return yearsEmployed() > x;
    }
}
