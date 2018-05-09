import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class p08_Get_Employee_with_Project {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer employeeId = Integer.parseInt(reader.readLine());

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        Employee found = (Employee) em.createQuery("select e from Employee  as e where e.id = ?")
                .setParameter(0, employeeId)
                .getSingleResult();

        Set<Project> emplProjects = found.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toSet());

        System.out.printf("%s %s - %s%n", found.getFirstName(), found.getLastName(), found.getJobTitle());
        for (Project emplProject : emplProjects) {
            System.out.printf("\t%s%n", emplProject.getName());
        }

        em.getTransaction().commit();
        em.close();
    }
}
