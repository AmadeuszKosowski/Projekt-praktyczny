package pl.sda.projekt;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

public class Main {

    SessionFactory sessionFactory = new Configuration()
            .configure().buildSessionFactory();

    public void init() throws IOException {
        RaceDataReader readerFile =
                new RaceDataReader("C:\\Users\\Agent\\IdeaProjects\\Projekt-praktyczny\\src\\main\\resources\\pigeon-racing.csv");

        List<Pigeon> pigeons = readerFile.getPigeons();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for(Pigeon pigeon : pigeons) {
            session.save(pigeon);
        }

        transaction.commit();
        session.close();
    }

}
