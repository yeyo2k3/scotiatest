
package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ladingtrack")
public class LandingTrack implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String name;
  private Status status;

  public void disableTrack() {
    this.status = new Status();
    this.status.setId(new Long(2));
    this.status.setName("Bussy");
  }

  public void enableTrack() {
    this.status = new Status();
    this.status.setId(new Long(1));
    this.status.setName("Active");
  }

  @Id
  public Long getId() {
    return id;
  }

  @Column
  public String getName() {
    return name;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id")
  public Status getStatus() {
    return status;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
