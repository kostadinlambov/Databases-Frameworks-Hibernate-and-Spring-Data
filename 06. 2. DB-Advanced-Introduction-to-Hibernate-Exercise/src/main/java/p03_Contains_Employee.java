import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class p03_Contains_Employee {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        String[] input = reader.readLine().split("\\s+");
        String firstName = input[0];
        String lastName = input[1];

        em.getTransaction().begin();

        List<Employee> result = em.
                createQuery("SELECT e FROM Employee AS e WHERE e.firstName  like ? and e.lastName like ?")
                .setParameter(0, firstName)
                .setParameter(1, lastName)
                .getResultList();

       if(result.size() == 1){
           System.out.println("Yes");
       }else{
           System.out.println("No");
       }
        em.getTransaction().commit();
        em.close();
    }
}
