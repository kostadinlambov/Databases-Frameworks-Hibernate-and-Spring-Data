package kl.app.dtos;

import java.math.BigDecimal;

public class EmployeeDto extends NamedDto{
    private BigDecimal salary;


    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
