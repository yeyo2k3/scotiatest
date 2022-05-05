
package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "status")
public class Status implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  private Long id;

  private String name;

  @Id
  public Long getId() {
    return id;
  }

  @Column
  public String getName() {
    return name;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public void setName(String name) {
    this.name = name;
  }


}
