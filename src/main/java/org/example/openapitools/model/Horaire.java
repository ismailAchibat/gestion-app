package org.openapitools.model;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Horaire
 */
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-01T16:00:00.000+01:00[Europe/Paris]")
public class Horaire {

  private Integer id;
  private Gare gareDepart;
  private Gare gareArrivee;
  private LocalTime heureDepart;
  private LocalTime heureArrivee;
  private Train train;

  public Horaire id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Horaire gareDepart(Gare gareDepart) {
    this.gareDepart = gareDepart;
    return this;
  }

  /**
   * Get gareDepart
   * @return gareDepart
  */
  public Gare getGareDepart() {
    return gareDepart;
  }

  public void setGareDepart(Gare gareDepart) {
    this.gareDepart = gareDepart;
  }

  public Horaire gareArrivee(Gare gareArrivee) {
    this.gareArrivee = gareArrivee;
    return this;
  }

  /**
   * Get gareArrivee
   * @return gareArrivee
  */
  public Gare getGareArrivee() {
    return gareArrivee;
  }

  public void setGareArrivee(Gare gareArrivee) {
    this.gareArrivee = gareArrivee;
  }

  public Horaire heureDepart(LocalTime heureDepart) {
    this.heureDepart = heureDepart;
    return this;
  }

  /**
   * Get heureDepart
   * @return heureDepart
  */
  public LocalTime getHeureDepart() {
    return heureDepart;
  }

  public void setHeureDepart(LocalTime heureDepart) {
    this.heureDepart = heureDepart;
  }

  public Horaire heureArrivee(LocalTime heureArrivee) {
    this.heureArrivee = heureArrivee;
    return this;
  }

  /**
   * Get heureArrivee
   * @return heureArrivee
  */
  public LocalTime getHeureArrivee() {
    return heureArrivee;
  }

  public void setHeureArrivee(LocalTime heureArrivee) {
    this.heureArrivee = heureArrivee;
  }

  public Horaire train(Train train) {
    this.train = train;
    return this;
  }

  /**
   * Get train
   * @return train
  */
  public Train getTrain() {
    return train;
  }

  public void setTrain(Train train) {
    this.train = train;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Horaire horaire = (Horaire) o;
    return Objects.equals(this.id, horaire.id) &&
        Objects.equals(this.gareDepart, horaire.gareDepart) &&
        Objects.equals(this.gareArrivee, horaire.gareArrivee) &&
        Objects.equals(this.heureDepart, horaire.heureDepart) &&
        Objects.equals(this.heureArrivee, horaire.heureArrivee) &&
        Objects.equals(this.train, horaire.train);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gareDepart, gareArrivee, heureDepart, heureArrivee, train);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Horaire {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    gareDepart: ").append(toIndentedString(gareDepart)).append("\n");
    sb.append("    gareArrivee: ").append(toIndentedString(gareArrivee)).append("\n");
    sb.append("    heureDepart: ").append(toIndentedString(heureDepart)).append("\n");
    sb.append("    heureArrivee: ").append(toIndentedString(heureArrivee)).append("\n");
    sb.append("    train: ").append(toIndentedString(train)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
