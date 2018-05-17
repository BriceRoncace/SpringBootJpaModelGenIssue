package gov.idaho.isp.bootvalidation.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Widget implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private String name;

  private LocalDate expiration;

  public Widget() {
  }

  public Widget(String name, LocalDate expiration) {
    this.name = name;
    this.expiration = expiration;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getExpiration() {
    return expiration;
  }

  public void setExpiration(LocalDate expiration) {
    this.expiration = expiration;
  }

  @Override
  public String toString() {
    return "Widget{" + "id=" + id + ", name=" + name + ", expiration=" + expiration + '}';
  }
}
