package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class AstronautData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;
  private int number;

  @ElementCollection
  @CollectionTable(name = "people", joinColumns = @JoinColumn(name = "astronaut_id"))
  private List<Astronaut> people;
}
