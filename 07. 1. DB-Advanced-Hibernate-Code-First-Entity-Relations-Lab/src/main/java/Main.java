import ingrediant.Basic.Mint;
import label.BasicLabel;
import shampoo.FiftyShades;
import shampoo.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("shampoo_company");
        EntityManager em = managerFactory.createEntityManager();

        em.getTransaction().begin();
        BasicLabel l = new BasicLabel("Fresh fresh");
        FreshNuke fresh_fresh = new FreshNuke(l);


        BasicLabel basicLabel = new BasicLabel("50");
        FiftyShades fiftyShades = new FiftyShades(basicLabel);

        em.persist(fresh_fresh);
        em.persist(fiftyShades);

        em.getTransaction().commit();
        em.close();
    }
}
