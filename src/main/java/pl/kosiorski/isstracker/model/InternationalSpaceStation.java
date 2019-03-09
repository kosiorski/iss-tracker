package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class InternationalSpaceStation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String message;

  private String timestamp;

  @OneToOne
  @JoinColumn(name = "position_id")
  private Position iss_position;
}
