package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        int n = 0;
        System.out.print("Enter the number of employees: ");
        n = input.nextInt();

        List<Employee> employeeList = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            char option;
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            option = input.next().toLowerCase().charAt(0);
            if (option == 'n') {
                System.out.print("Name: ");
                String name = input.next();
                System.out.print("Hours: ");
                int hours = input.nextInt();
                System.out.print("Value per hour: ");
                double valuePerHour = input.nextDouble();
                employeeList.add(new Employee(name, hours, valuePerHour));
            } else if(option == 'y') {
                System.out.print("Name: ");
                String name = input.next();
                System.out.print("Hours: ");
                int hours = input.nextInt();
                System.out.print("Value per hour: ");
                double valuePerHour = input.nextDouble();
                System.out.print("Additional charge: ");
                double additionalCharge = input.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                System.out.println("Invalid option!");
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s - $ %.2f%n", employeeList.get(i).getName(), employeeList.get(i).payment());
        }

        input.close();

    }

}
