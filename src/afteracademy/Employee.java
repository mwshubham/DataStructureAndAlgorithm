package afteracademy;

import java.util.HashMap;
import java.util.Objects;

public class Employee {

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return Objects.equals(name, employee.name);
//        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static void main(String args[]) {
        HashMap map = new HashMap<Employee, String>();
        Employee emp1 = new Employee(1, "ABC");
        Employee emp2 = new Employee(1, "XYZ");
        map.put(emp1, "A");
        map.put(emp2, "B");
        System.out.println(map.size());
    }
}
