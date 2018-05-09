import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class p04_Employees_with_Salary {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> result = em.
                createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.salary > 50000")
                .getResultList();

        for (Employee employee : result) {
            System.out.println(employee.getFirstName());
        }
        em.getTransaction().commit();
        em.close();
    }
}
