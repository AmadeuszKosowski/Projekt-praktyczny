package pl.sda.projekt;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@NoArgsConstructor
public class Pigeon {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String owner;
    private String birdId;

    public Pigeon(String nameBird, String ownerName, String birdId) {
        this.name = nameBird;
        this.owner = ownerName;
        this.birdId = birdId;
    }
}


