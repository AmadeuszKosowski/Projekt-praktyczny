package pl.sda.projekt;

import lombok.Data;

import javax.persistence.*;
import java.time.Duration;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pigeon_id")
    private Pigeon pigeon;
    @ManyToOne
    private Race race;
    //private Duration time;



}
