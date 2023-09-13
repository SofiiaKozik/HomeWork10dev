package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetCrudService {

    public void create(String name, String ID) {
        Planet planet = new Planet();
        planet.setID(ID);
        planet.setNAME(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet read(String ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, ID);
        session.close();

        return planet;
    }

    public void delete(String ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Planet planet = session.get(Planet.class, ID);
        session.remove(planet);
        transaction.commit();
        session.close();
    }

    public void update (String name, String ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Planet planet = session.get(Planet.class, ID);
        planet.setNAME(name);
        session.merge(planet);
        transaction.commit();
        session.close();
    }
}
