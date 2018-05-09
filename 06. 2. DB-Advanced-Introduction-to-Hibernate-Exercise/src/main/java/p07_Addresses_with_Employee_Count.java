import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class p07_Addresses_with_Employee_Count {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();

        List<Address> result = em.createQuery("select a from Address  as a order by a.employees.size desc, a.town.id asc ")
                .setMaxResults(10)
                .getResultList();


        for (Address address : result) {
            System.out.printf("%s, %s, - %d employee\n", address.getText(), address.getTown().getName(),
                    address.getEmployees().size());
        }

        em.getTransaction().commit();
        em.close();
    }
}
