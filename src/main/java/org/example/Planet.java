package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Table(name = "planet")
@Data
public class Planet {

    @Id
    String ID;

    @Column(name = "name", nullable = false, length = 500)
    String NAME;

    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> departingTickets;

    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> arrivingTickets;

}
