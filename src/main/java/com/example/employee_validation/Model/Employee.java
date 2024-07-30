package com.example.employee_validation.Model;
//import javax.validation.constraints.PastOrPresent;
import com.fasterxml.jackson.annotation.JsonFormat;
//import javax.validation.constraints.Pattern;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {

    @NotEmpty(message = " Name Cannot be null.")
    @Size(min = 5 , message = " Name Length must be more than 4 characters. ")
    @Pattern(regexp = "^[a-zA-Z]*$", message = " Name Must contain only characters (no numbers). ")
    private String name;


    @NotEmpty(message = " lastname Cannot be null.")
    @Size(min = 4 , message = " lastname Length must be more than 3 characters. ")
    @Pattern(regexp = "^[a-zA-Z]*$", message = " lastname Must contain only characters (no numbers). ")
    private String lastname;


    //@Digits(integer = 3, fraction = 0, message = "Age must be a number")
    @Positive(message = " Age must be a numbers ")
    @NotNull(message = "Age cannot be null") // int
    @Min(value = 26, message = "Age must be more than 25")
    private int age;

    @Size(message = " ID Length must be more than 2 characters.")
    @NotEmpty(message = "ID cannot be null")
    @Pattern(regexp = "\\d+", message = "ID must be a number")
    private String id;

    @NotEmpty(message = "Email is Require..! ")
    @Email(message = " Must be a valid email format. ")
    private String email;

    @NotEmpty(message = "Phone Number is Require..! ")
    @Pattern(regexp = "\\d+", message = "Phone NUmber must be a numbers.")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and contain exactly 10 digits")
    private String phoneNumber;

    @NotEmpty(message = "Position Cannot be Null ")
    @Pattern(regexp = "^(supervisor|coordinator)$", message = " Position Must be either supervisor Or coordinator only. ")
    private String position;

    @NotNull(message = "onLeave is Requier..! ")
    @AssertFalse(message = "OnLeave must be initially set to false")
    private Boolean onLeave;

    //@Positive(message = "AnnualLeave must be a positive number")
    @NotNull(message = "AnnualLeave cannot be null")
    @PositiveOrZero(message = "AnnualLeave must be a positive number or zero")
    private int annualLeave;


    // @Year(regexp = "^(19|20)\\d{2}$", message = "hireDate must be a valid year (e.g., 1900 or later)")
    //  @Pattern(regexp = "^(19\\d{2}|20[0-2]\\d)$", message = "hireDate must be a valid year (e.g., 1900 or later)")
    @PastOrPresent(message = "hireDate should be in the past or the present & must be a valid year (e.g., 1900 or later) "  )
      @NotNull(message = "hireDate Cannot be null. ")
      @JsonFormat(pattern = "yyyy-MM-dd")
       private LocalDate hireDate;


}
