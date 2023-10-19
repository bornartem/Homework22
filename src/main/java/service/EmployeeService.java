package service;


import exception.EmployeeAlreadyAddedException;
import exception.EmployeeNotFoundException;
import exception.EmployeeStorageIsFullException;

import java.util.Collection;


public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;

    Collection<Employee> getAll();
}