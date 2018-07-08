package com.alfainmo.beans;

@SuppressWarnings("serial")
public class OficinaPortal extends OficinaAlfa {
  private String pais;
  private String provincia;
  private String poblacion;
  public String getPais() {
    return pais;
  }
  public void setPais(String pais) {
    this.pais = pais;
  }
  public String getProvincia() {
    return provincia;
  }
  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }
  public String getPoblacion() {
    return poblacion;
  }
  public void setPoblacion(String poblacion) {
    this.poblacion = poblacion;
  }
}
