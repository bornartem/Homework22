package service;

import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int employeesSize = 6;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
              "0", new Employee ("Arnold", "Shwarzenegger"),
               "1", new Employee ("Silvester", "Stalone"),
            "2", new Employee ("Bruce", "Lee"),
               "3", new Employee("Steven", "Sigal"),
                "4" , new Employee("Chuck", "Norris")
    ));




    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= employeesSize) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
            employees.put(employee.getFullName(), employee); {

        }  return employee;
    }


    //            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников");

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
//        if (!employees.contains(employee)) {
//            throw new EmployeeNotFoundException("Сотрудник не найден");
//        }
//    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }
}
