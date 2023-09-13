package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientCrudService {

    public void create(String name) {
        Client client = new Client();
        client.setNAME(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client read(int ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, ID);
        session.close();

        return client;
    }

    public void delete(int ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, ID);
        session.remove(client);
        transaction.commit();
        session.close();
    }

    public void update (String name, int ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, ID);
        client.setNAME(name);
        session.merge(client);
        transaction.commit();
        session.close();
    }
}
