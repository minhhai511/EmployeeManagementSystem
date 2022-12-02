/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SƠNPC
 */
public class EmployeeManager {

    private List<Employee> listEmployee = new ArrayList<>();

    public EmployeeManager() {
        listEmployee.add(new Employee("quang123", "minh", "quang", "1224124545", "pmq@gmail.com", "67 to hieu", valid.toDate("5/11/2002", "dd/MM/yyyy"), "male", 32000, "Viettel"));
        listEmployee.add(new Employee("tuan223", "quoc", "tuan", "1224344545",
                "tgt@gmail.com", "123 oak street", valid.toDate("4/01/2002", "dd/MM/yyyy"), "male", 42000, "fpt"));
        listEmployee.add(new Employee("quy323", "duc", "quy", "4234124545",
                "dsad@gmail.com", "65 ho guom", valid.toDate("5/06/2002", "dd/MM/yyyy"), "male", 52000, "fcorp"));
        listEmployee.add(new Employee("minh453", "van", "minh", "122342545",
                "qwe@gmail.com", "78 to hieu", valid.toDate("15/8/2002", "dd/MM/yyyy"), "female", 62000, "ppiper"));
        listEmployee.add(new Employee("toan563", "toan", "quang", "1224344545",
                "sad@gmail.com", "85 kim dong", valid.toDate("12/12/2002", "dd/MM/yyyy"), "male", 12000, "vnpt"));
    }

    Validation valid = new Validation();

    void AddEmployees() {
        String id = "";
        while (true) {
            id = valid.getString("Enter Employee ID: ", "Wrong ID format!", "^[a-zA-Z0-9]+$");
            if (FindEmployeebyID(id) != null) {
                System.out.println("Duplicate ID, please enter another ID!");
            } else {
                break;
            }
        }
        String FirstName = valid.getString("Enter Employee first name: ", "Please enter a valid first name!", "^[a-zA-Z ]+$");
        String LastName = valid.getString("Enter Employee last name: ", "Please enter a valid last name!", "^[a-zA-Z ]+$");
        String Phone = valid.getString("Enter Employee phone number: ", "Please enter a valid phone number!", "^[0-9]+$");
        String Email = valid.getString("Enter Employee email: ", "Wrong email format!", "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
        String Address = valid.getString("Enter Employee address: ", "Please enter a valid address!", "^[a-zA-Z0-9 ]+$");
        Date DOB = valid.getDate("Enter Employee DOB(dd/MM/yyyy):", "Please enter a valid date!", "dd/MM/yyyy");
        String Sex = valid.getString("Enter Employee sex: ", "Sex(male,female)", "^(male|female)$");
        double Salary = valid.getDouble("Enter Employee salary: ", "Please enter a valid salary!", 0, Double.MAX_VALUE);
        String Agency = valid.getString("Enter Employee agency: ", "Please enter a valid agency!", "^[a-zA-Z ]+$");
        Employee employee = new Employee(id, FirstName, LastName, Phone, Email, Address, DOB, Sex, Salary, Agency);
        listEmployee.add(employee);
        System.out.println("List of employee after adding employee is: ");
        display();
    }

    private Employee FindEmployeebyID(String id) {
        for (Employee Employee : listEmployee) {
            if (Employee.getId().equalsIgnoreCase(id)) {
                return Employee;
            }
        }
        return null;
    }

    void UpdateEmployees() {
        if (listEmployee.isEmpty() == false) {
            String id = valid.getString("Enter Employee ID you want to update information: ", "Wrong ID format!", "^[a-zA-Z0-9]+$");
            if (FindEmployeebyID(id) != null) {
                Employee employee = FindEmployeebyID(id);
                String FirstName = valid.getString("Update Employee first name: ", "Please enter a valid first name!", "^[a-zA-Z]+$");
                String LastName = valid.getString("Update Employee last name: ", "Please enter a valid last name!", "^[a-zA-Z]+$");
                String Phone = valid.getString("Update Employee phone number: ", "Please enter a valid phone number!", "^[0-9]+$");
                String Email = valid.getString("Update Employee email: ", "Wrong email format!", "^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$");
                String Address = valid.getString("Update Employee address: ", "Please enter a valid address!", "^[a-zA-Z0-9 ]+$");
                Date DOB = valid.getDate("Update Employee DOB(dd/MM/yyyy):", "Please enter the correct format!", "dd/MM/yyyy");
                String Sex = valid.getString("Update Employee sex: ", "Sex(male or female)", "^(male|female)$");
                double Salary = valid.getDouble("Update Employee salary: ", "Please enter a valid salary!", 0, Double.MAX_VALUE);
                String Agency = valid.getString("Update Employee agency: ", "Please enter a valid agency!", "^[a-zA-Z ]+$");
                employee.setFirstName(FirstName);
                employee.setLastName(LastName);
                employee.setPhone(Phone);
                employee.setAddress(Address);
                employee.setEmail(Email);
                employee.setDOB(DOB);
                employee.setSex(Sex);
                employee.setSalary(Salary);
                employee.setAgency(Agency);
                System.out.println("Updated employee successfully!");
            } else {
                System.out.println("The employee you want to update does not exist!");
            }
        } else {
            System.out.println("List is empty. Cannot update!");
        }
        System.out.println("List of employee after updating is: ");
        display();
    }

    void RemoveEmployees() {
        if (listEmployee.isEmpty() == false) {
            String id = valid.getString("Enter Employee ID you want to delete: ", "Wrong ID format!", "^[a-zA-Z0-9 ]+$");
            if (FindEmployeebyID(id) != null) {
                Employee employee = FindEmployeebyID(id);
                listEmployee.remove(employee);
                System.out.println("Deleted employee successfully!");
            } else {
                System.out.println("The employee you want to delete does not exist!");
            }
        } else {
            System.out.println("List is empty. Cannot delete!");
        }
        System.out.println("List of employee after deleting is: ");
        display();

    }

    public void SearchEmployees() {
        String name = Validation.getString("Enter name of the employees you want to search: ", "Name invalid", "^[a-zA-Z ]+$");
        System.out.println("List result: ");

        boolean isExisted = false;
        for (Employee E : listEmployee) {
            String fullName = E.getFirstName() + " " + E.getLastName();
            if (fullName.contains(name)) {
                if (!isExisted) {
                    System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                            "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                }
                isExisted = true;
                System.out.println(E);
            }
        }
        if (!isExisted) {
            System.out.println("Employee name not found!");
        }
    }

    public void SortEmployees() {
        Collections.sort(listEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        display();
    }

    void display() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employee E : listEmployee) {
            System.out.println(E);
        }
    }

}
