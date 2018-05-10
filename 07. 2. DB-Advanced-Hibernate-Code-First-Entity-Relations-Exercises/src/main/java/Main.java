import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("exercise_db");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();



        em.getTransaction().commit();
        em.close();
    }
}
