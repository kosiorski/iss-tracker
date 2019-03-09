package pl.kosiorski.isstracker.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IssPositionTest {

  @Test
  public void setLatitude() {
    IssPosition issPosition = new IssPosition();

    issPosition.setLatitude(27.9848);
    assertEquals(27.9848, issPosition.getLatitude(), 0.001);
  }

  @Test
  public void setLongitude() {
    IssPosition issPosition = new IssPosition();

    issPosition.setLongitude(-44.2789);
    assertEquals(-44.2789, issPosition.getLongitude(), 0.001);
  }

  @Test
  public void getLatitude() {
    IssPosition issPosition = new IssPosition();

    issPosition.setLatitude(27.9848);
    assertEquals(27.9848, issPosition.getLatitude(), 0.001);
  }

  @Test
  public void getLongitude() {
    IssPosition issPosition = new IssPosition();

    issPosition.setLongitude(-44.2789);
    assertEquals(-44.2789, issPosition.getLongitude(), 0.001);
  }
}
