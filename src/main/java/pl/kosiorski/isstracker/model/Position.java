package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double latitude;
  private double longitude;

  public Position() {}

  public Position(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
