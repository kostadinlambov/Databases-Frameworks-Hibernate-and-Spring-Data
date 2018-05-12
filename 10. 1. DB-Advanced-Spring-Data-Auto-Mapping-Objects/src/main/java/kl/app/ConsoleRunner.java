package kl.app;

import kl.app.dtos.EmployeeDto;
import kl.app.dtos.ManagerDto;
import kl.app.entities.Employee;
import kl.app.repositories.AddressRepository;
import kl.app.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner {

    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ConsoleRunner(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Address address = new Address();
//        address.setCity("Sofia");
//        address.setCountry("Bulgaria");
//
//        this.addressRepository.save(address);


        //Problem 1
        Employee one =  this.employeeRepository.findById(1L).orElse(null);

        ModelMapper mapper = new ModelMapper();
        EmployeeDto dto = mapper.map(one, EmployeeDto.class);
        //System.out.println(dto.getFirstName());

        //Problem 2
        ManagerDto managerDto = mapper.map(one, ManagerDto.class);

        int size = one.getServants().size();
        System.out.printf("%s | Employees: %d%n",one.getFirstName(), size);
        for (EmployeeDto e : managerDto.getServants()) {
            System.out.printf("   - %s %s %s%n", e.getFirstName(), e.getLastName(), e.getSalary());
        }


        //Problem 3
        List<Employee> employeeList = this.employeeRepository
                .findByBirthDateBeforeOrderBySalaryDesc(LocalDate.parse("1990-01-01"));

        for (Employee employee : employeeList) {
            System.out.println(employee.getFirstName());
            String managerName = employee.getManager() == null ? "no manager" :
                    employee.getManager().getFirstName();
            System.out.println("Namager: "+ managerName);
        }
    }
}
