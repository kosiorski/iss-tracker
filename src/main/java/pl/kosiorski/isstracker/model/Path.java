package pl.kosiorski.isstracker.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Path {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double distance;
  private double averageSpeed;

  @OneToMany
  @JoinTable(
      name = "path_issData",
      joinColumns = @JoinColumn(name = "path_id"),
      inverseJoinColumns = @JoinColumn(name = "issData_id"))
  private List<IssData> issDataList;
}
