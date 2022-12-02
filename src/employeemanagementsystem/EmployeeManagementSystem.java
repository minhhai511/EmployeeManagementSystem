/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SƠNPC
 */
public class EmployeeManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager EM = new EmployeeManager();
        while (true) {
            System.out.println("Main menu:\n"
                    + "1.Add employees \n"
                    + "2.Update employees\n"
                    + "3.Remove employees\n"
                    + "4.Search employees\n"
                    + "5.Sort employees by salary\n"
                    + "6.Exit");
            int option = Validation.getInt("Choose an option:", "Please input a valid option!", 1, 6);
            switch (option) {
                case 1:
                    EM.AddEmployees();
                    break;
                case 2:
                EM.UpdateEmployees();
                    break;
                case 3:
                    EM.RemoveEmployees();
                    break;
                case 4:
                    EM.SearchEmployees();
                    break;
                case 5:
                    EM.SortEmployees();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

}
