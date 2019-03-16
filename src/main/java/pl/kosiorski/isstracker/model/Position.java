package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double latitude;
  private double longitude;
  private String timestamp;

  @OneToOne(mappedBy = "iss_position")
  private IssData internationalSpaceStation;

  public Position() {}

  public Position(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
