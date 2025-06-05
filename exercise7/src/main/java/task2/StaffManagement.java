package task2;

import java.util.*;
import java.util.stream.Collectors;

public class StaffManagement {
    Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee e) throws DuplicateEmployeeException{
        if(employees.contains(e)) {
            throw new DuplicateEmployeeException("Number ist schon vorhanden." + e.getEmployeeID());
        } else {
            employees.add(e);
        }
    }

    public List<Employee> getEmployeesSortedByName() {
        List<Employee> result = new ArrayList<>(employees);
        Collections.sort(result, Comparator.comparing(Employee::getName));
        return result;
        //return employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesSortedByYearsEmployed() {
        List<Employee> result = new ArrayList<>(employees);
        Collections.sort(result, Comparator.comparingDouble(Employee::getYearsEmployed));
        return result.reversed();
        //return employees.stream().sorted(Comparator.comparing(Employee::getYearsEmployed)).collect(Collectors.toList()).reversed();
    }

    public List<Employee> getEmployeesFromDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getDepartment().equals(department)) {
                result.add(emp);
            }
        }
        return result;
        //return employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public Map<String, Employee> getLongestEmployedEmployeePerDepartement() {
        Map<String, Employee> result = new HashMap<>();
        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            if (!result.containsKey(dept) || emp.getYearsEmployed() > result.get(dept).getYearsEmployed()) {
                result.put(dept, emp);
            }
        }
        return result;

        /*
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getYearsEmployed))))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(null)));

         */
    }
}
