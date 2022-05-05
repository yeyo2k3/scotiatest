
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
@Table(name = "airplane")
public class Airplane implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private Status status;

  public void activateStatus() {
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
