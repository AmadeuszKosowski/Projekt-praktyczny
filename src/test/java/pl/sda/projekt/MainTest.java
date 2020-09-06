package pl.sda.projekt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import pl.sda.projekt.Main;
import pl.sda.projekt.Pigeon;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();

    @Test
    void shouldPopulated() throws IOException {
        //given
        Main main = new Main();

        //when
        main.init();

        //then
        Session querySession = sessionFactory.openSession();
        CriteriaQuery<Pigeon> cr = querySession.getCriteriaBuilder().createQuery(Pigeon.class);
        Root<Pigeon> root = cr.from(Pigeon.class);

        Query<Pigeon> query = querySession.createQuery(cr);
        List<Pigeon> result = query.getResultList();
        querySession.close();

        assertEquals(400, result.size());

    }

}