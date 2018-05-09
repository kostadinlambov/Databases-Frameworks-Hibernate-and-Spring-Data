import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p06_New_Address {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String lastname = reader.readLine();

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        em.persist(newAddress);

        Employee found = (Employee) em.createQuery("select e from Employee as e  where e.lastName = ?")
                .setParameter(0, lastname)
                .setMaxResults(1)
                .getSingleResult();

        found.setAddress(newAddress);

        em.getTransaction().commit();
        em.close();
    }
}
