package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;


public class TicketCrudService {

    public void create(int client_id, String from_planet_id, String to_planet_id) {
        Date currentDate = new Date();

        Ticket ticket = new Ticket();
        ticket.setClient(clientcheck(client_id));
        ticket.setFromPlanet(planetcheck(from_planet_id));
        ticket.setToPlanet(planetcheck(to_planet_id));
        ticket.setCreatedAt(currentDate);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket read(int ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = new Ticket();
        ticket = session.get(Ticket.class, ID);
        session.close();

        return ticket;
    }

    public void delete(int ID) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Ticket ticket = session.get(Ticket.class, ID);
        session.remove(ticket);
        transaction.commit();
        session.close();
    }

    public void update(int ID, int client_id, String from_planet_id, String to_planet_id) {
        Date currentDate = new Date();

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();


        Ticket ticket = session.get(Ticket.class, ID);
        ticket.setClient(clientcheck(client_id));
        ticket.setFromPlanet(planetcheck(from_planet_id));
        ticket.setToPlanet(planetcheck(to_planet_id));
        ticket.setCreatedAt(currentDate);
        session.merge(ticket);
        transaction.commit();
        session.close();
    }

    private Client clientcheck(int id) {
            ClientCrudService clientCrudService = new ClientCrudService();
            Client client = clientCrudService.read(id);
            if (client == null) {
                throw new IllegalArgumentException("Invalid client IDs");
            }
            return client;
    }

    private Planet planetcheck(String id) {
            PlanetCrudService planetCrudService = new PlanetCrudService();
            Planet planet = planetCrudService.read(id);
            if (planet == null) {
                throw new IllegalArgumentException("Invalid planet IDs");
            }
            return planet;
    }

}
