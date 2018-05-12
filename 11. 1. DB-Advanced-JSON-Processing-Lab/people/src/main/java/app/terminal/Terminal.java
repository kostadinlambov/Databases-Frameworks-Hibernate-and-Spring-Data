package app.terminal;

import app.domain.dto.PersonDto;
import app.io.JSONParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private PersonService personService;
    private JSONParser parser;

    @Autowired
    public Terminal(PersonService personService) {
        this.personService = personService;
        this.parser = new JSONParser();
    }

    @Override
    public void run(String... strings) throws Exception {
        //Read from person.json
        PersonDto[] personDto = this.parser.importJson(PersonDto[].class,
                "/files/persons.json");

        for (PersonDto dto : personDto) {
            this.personService.create(dto);
        }
        
        //write to writeToFile.json
        PersonDto dto = this.personService.findById(1);
        this.parser.outputJson(dto, "C:\\Users\\valch\\Desktop\\Java DB Projects\\02. Databases Frameworks - Hibernate & Spring Data - March 2018\\11. 1. DB-Advanced-JSON-Processing-Lab\\people\\src\\main\\resources\\files\\writeToFile.json");
    }
}
