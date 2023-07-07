package service;


import entity.Employee;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.stream.Collectors;


@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee withMaxSalary(int departmentId) {
        return streamByDepartment(departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public Employee withMinSalary(int departmentId) {
        return streamByDepartment(departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    public Map<Integer, List<Employee>> employeesByDepartment(Integer departmentId) {
        return streamByDepartment(departmentId)
                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.toList()));
    }


    private Stream<Employee> streamByDepartment(Integer departmentId) {
        List<Employee> employees = employeeService.getAll();
        Stream<Employee> employeeStream = employees.stream()
                .filter(e -> departmentId == null || e.getDepartmentId().equals(departmentId));
        return employeeStream;
    }
}