package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    String ID;

    @Column(name = "name", nullable = false, length = 500)
    String NAME;

}
