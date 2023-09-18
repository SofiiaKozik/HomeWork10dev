package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int ID;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client client;

        @Column(name = "created_at")
        private Date createdAt;


        @ManyToOne
        @JoinColumn(name = "from_planet_id")
        private Planet fromPlanet;

        @ManyToOne
        @JoinColumn(name = "to_planet_id")
        private Planet toPlanet;

        @Override
        public String toString() {
                return "Ticket{" +
                        "ID=" + ID +
                        ", client=" + client.getID() +
                        ", createdAt=" + createdAt +
                        ", fromPlanet=" + fromPlanet.getID() +
                        ", toPlanet=" + toPlanet.getID() +
                        '}';
        }
}
