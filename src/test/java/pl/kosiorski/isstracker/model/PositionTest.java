package pl.kosiorski.isstracker.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

  @Test
  public void setLatitude() {
    Position position = new Position();

    position.setLatitude(27.9848);
    assertEquals(27.9848, position.getLatitude(), 0.001);
  }

  @Test
  public void setLongitude() {
    Position position = new Position();

    position.setLongitude(-44.2789);
    assertEquals(-44.2789, position.getLongitude(), 0.001);
  }

  @Test
  public void getLatitude() {
    Position position = new Position();

    position.setLatitude(27.9848);
    assertEquals(27.9848, position.getLatitude(), 0.001);
  }

  @Test
  public void getLongitude() {
    Position position = new Position();

    position.setLongitude(-44.2789);
    assertEquals(-44.2789, position.getLongitude(), 0.001);
  }
}
