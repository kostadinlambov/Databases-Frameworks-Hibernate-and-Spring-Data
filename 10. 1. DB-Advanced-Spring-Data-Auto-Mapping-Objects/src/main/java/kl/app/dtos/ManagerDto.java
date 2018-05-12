package kl.app.dtos;

import kl.app.entities.Employee;

import java.util.List;

public class ManagerDto extends NamedDto{
    public List<EmployeeDto> getServants() {
        return this.servants;
    }

    public void setServants(List<EmployeeDto> servants) {
        this.servants = servants;
    }

    private List<EmployeeDto> servants;

}
