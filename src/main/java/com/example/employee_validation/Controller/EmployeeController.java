package com.example.employee_validation.Controller;


import com.example.employee_validation.Api.ApiResponse;
import com.example.employee_validation.Model.Employee;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get")// Get all employees: Retrieves a list of all employees.
    public ResponseEntity getEmployee() {
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/add")//Add a new employee: Adds a new employee to the system.
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.ok(new ApiResponse(" Employee added successfully"));
    }


    @PutMapping("/update/{index}")// update event
    public ResponseEntity updateEvent( @PathVariable int index, @Valid @RequestBody Employee employee , Errors errors) {
        if (errors.hasErrors()) {
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index, employee);
        return ResponseEntity.ok("Emoloyee updated");
    }



    @DeleteMapping("/delete/{index}")//Deletes an employee from the system,Verify that the employee exists.
    public ResponseEntity deleteEmployee(@PathVariable int index) {
        for (Employee employee : employees) {
            if (employee.equals(employees.get(index))) {
                employees.remove(employee);
                return ResponseEntity.ok(new ApiResponse(" Employee deleted successfully"));
            }
        }
        return ResponseEntity.ok(new ApiResponse(" Employee Not Found "));
    }



    @GetMapping("/search/{position}")//Search Employees by Position
    public ResponseEntity searchEmployee(@PathVariable String position) {

        if (employees.isEmpty()) {
            return ResponseEntity.ok(new ApiResponse(" Employee Not Found "));
        }

        ArrayList<Employee> allEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getPosition().equals(position)) {
                allEmployees.add(employee);
            }
        }
        return ResponseEntity.ok(allEmployees);

    }


@GetMapping("/search-age/{min}/{max}") // Search employees by age
public ResponseEntity searchEmployee(@PathVariable int min, @PathVariable int max) {

    if (min < 0 || max < 0 || min > max) {
        return ResponseEntity.status(401).body(new ApiResponse(" invalid "));
    }
    ArrayList<Employee> searchAge = new ArrayList<>();
    for (Employee employee : employees) {
        if (employee.getAge() >= min && employee.getAge() <= max) {
            searchAge.add(employee);
        }
    }
    return ResponseEntity.ok(searchAge);
}



    @GetMapping("/annual-leave/{id}")//Allow employees to apply for annual leave.
    public ResponseEntity annual_leave(@PathVariable String id ) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                if(employee.getOnLeave().equals(false)){
                    if(employee.getAnnualLeave() >1 ) {
                        employee.setOnLeave(true);
                        employee.setAnnualLeave(employee.getAnnualLeave()-1);
                        return ResponseEntity.ok(new ApiResponse(" succseful "));
                    }
                }
            }
        }
        return ResponseEntity.ok(new ApiResponse(" Employee Not Found "));
    }



    @GetMapping("/no-annual/{id}")//Get Employees with No Annual Leave: Retrieves a list of employees who have used up all their annual leave
    public ResponseEntity noAnnual(@PathVariable String id ) {

        ArrayList<Employee> allEmployees = new ArrayList();
        for(Employee employee : employees) {

            if(employee.getAnnualLeave() == 0 ){
                allEmployees.add(employee);
            }

//            else  {
//                return  ResponseEntity.ok(new ApiResponse(" Not Found "));
//            }
        }
        return ResponseEntity.ok(allEmployees);
      }



    @PutMapping("/promote/{employeId}/{requistId}") // Promote Employee
    public ResponseEntity promoteEmployee( @PathVariable String employeId, @PathVariable String requistId) {

        for (Employee employee : employees) {
            if (employee.getId().equals(requistId)) {
                if (employee.getPosition().equalsIgnoreCase("supervisor")) {
                    for (Employee emp : employees) {
                        if (emp.getId().equals(employeId)) {
                            if (emp.getAge() >= 30) {
                                if (emp.getOnLeave().equals(false)) {
                                    emp.setPosition("Supervisior");
                                    return ResponseEntity.ok(new ApiResponse(" succseful "));
                                }
                            }
                        }
                    }
                 }
              }
            }
            return ResponseEntity.status(400).body(new ApiResponse(" Employee Not Found "));
    }

//        for (Employee employee : employees) {
//            if (employee.getId().equals(employeId)) {
//                return employee;
//            }
//        }
//        if (position.equals("supervisor")) {
//
//              for (Employee emp : employees) {
//                 if (emp.getId().equals(id) &&  emp.getAge() >= 30 && emp.isOnLeave()) {
//                            emp.setPosition("supervisor");
//                        return ResponseEntity.ok(new ApiResponse(" Employee promoted successfully"));
//                }
//            }
//        }
//        return ResponseEntity.ok(new ApiResponse(" Employee Not Found "));
//    }


    }