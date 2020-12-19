package com.company;

public class EmployeeWageBuilder {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private final String company;
    private final int empRatePerHour;
    private final int numOfWorkingDays;
    private final int maxHoursPerMonth;
    private int totalEmpWage;

    public EmployeeWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        this.company = company;
        this.empRatePerHour = empRatePerHour;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }
    public void computeEmployeeWage() {
        //Variables
        int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        //Computation
        while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            System.out.println("Days#: " + totalWorkingDays + " Emp Hr: " +empHrs);
        }
        totalEmpWage = totalEmpHrs * empRatePerHour;
    }
    @Override
    public String toString() {
        return "Total Emp Wage for Company: " +company+ "is:" +totalEmpWage;
    }

    public static void main(String args[]){
        System.out.println("Welcome to employee wage program");
        EmployeeWageBuilder dMart = new EmployeeWageBuilder("DMart", 20, 2, 10);
        EmployeeWageBuilder reliance = new EmployeeWageBuilder("Reliance", 10, 4, 20);
        dMart.computeEmployeeWage();
        System.out.println(dMart);
        reliance.computeEmployeeWage();
        System.out.println(reliance);
    }
}
