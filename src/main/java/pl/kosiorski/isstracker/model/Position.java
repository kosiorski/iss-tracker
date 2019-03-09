package pl.kosiorski.isstracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double latitude;
  private double longitude;

  @OneToOne(mappedBy = "iss_position")
  private IssData internationalSpaceStation;

  public Position() {}
}
