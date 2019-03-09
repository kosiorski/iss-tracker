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

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "astronautData_astronaut",
      joinColumns = @JoinColumn(name = "astronautData_id"),
      inverseJoinColumns = @JoinColumn(name = "astronaut_id"))
  private List<Astronaut> people;
}
