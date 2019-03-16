package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tracker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "position_id", insertable = false, updatable = false)
  private Position startPosition;

  @OneToOne
  @JoinColumn(name = "position_id", insertable = false, updatable = false)
  private Position endPosition;

  private double distance;


}
