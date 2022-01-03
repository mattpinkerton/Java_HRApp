
package hrapp;

/**
 *
 * @author mattpinkerton
 */
public class Department {

    private String name;

    private Employee[] employees = new Employee[10];

    private int lastAddedEmployeeIndex = -1;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmp(Employee anEmployee) {
        /*
        Increment lastAddedEmployeeIndex and add employee to this position in the employees array.
        When adding new employee to the employees array, consider the length of the array.
        You can simply stop adding extra employees once you have reached your employee array capacity. 
         */
        if (lastAddedEmployeeIndex < employees.length) {
            lastAddedEmployeeIndex++;
            employees[lastAddedEmployeeIndex] = anEmployee;
        }
    }

    public Employee[] getEmployees() {
        /*
        Algorithm returns an array of employees that contains the exact number of
        elements that matches the actual number of employees in this department.
        This can be calculated by adding one to the lastAddedEmployeeIndex variable.
        Then copies references for relevant employee object from the employees array
        to this new array and returns it to the invoker.
        This way the invoker always gets an array alrrady trimmed to exact required size.
         */
        Employee[] actualEmployees = new Employee[lastAddedEmployeeIndex + 1];

        for (int i = 0; i < actualEmployees.length; i++) {
            actualEmployees[i] = employees[i];
        }
        return actualEmployees;
    }

    public int getEmployeeCount() {
        /*
        Variable lastAddedEmployeeIndex indicates last valid position in the employees array.
        Because array indexing starts at zero, number of elements is equal to index + 1.
         */
        return lastAddedEmployeeIndex + 1;
    }

    //query method that attempts to locate an employee with specific id in this department
    public Employee getEmployeeByID(int empId) {
        Employee result = null;
        for (Employee emp : employees) {
            if (emp != null) {
                if (emp.getID() == (empId)) {
                    result = emp;
                    break;
                }
            }
        }
        return result;
    }

    public double getTotalSalary() {
        double totalSalary = 0.0;
        for (int i = 0; i <= lastAddedEmployeeIndex; i++) {
            totalSalary += employees[i].getSalary();
        }
        return totalSalary;
    }

    public double getAverageSalary() {
        if (lastAddedEmployeeIndex > -1) {
            return getTotalSalary() / (lastAddedEmployeeIndex + 1);
        }
        return 0.0;
    }

    public String toString() {
        return name;
    }

}
