package com.alfainmo.beans;

public class OficinaAlfa extends BeanObject {
  
  private String cp;
  private String email;
  private String escalera;
  private String nombre;
  private String nombre_via;
  private String numero_via;
  private int oficina;
  private int id_poblacion;
  private int id_provincia;
  private int id_pais;
  
  private String piso;
  private String puerta;
  private String telefonos;
  private String tipo_via;
  private String web;
  private String marca_act;
  private String observaciones;
  private String dir_libre;
  
  public String getCp() {
    return cp;
  }
  public String getEmail() {
    return email;
  }
  public String getEscalera() {
    return escalera;
  }
  public int getId_pais() {
    return id_pais;
  }
  public int getId_poblacion() {
    return id_poblacion;
  }
  public int getId_provincia() {
    return id_provincia;
  }
  public String getMarca_act() {
    return marca_act;
  }
  public String getNombre() {
    return nombre;
  }
  public String getNombre_via() {
    return nombre_via;
  }
  public String getNumero_via() {
    return numero_via;
  }
  public String getObservaciones() {
    return observaciones;
  }
  public int getOficina() {
    return oficina;
  }
  public String getPiso() {
    return piso;
  }
  public String getPuerta() {
    return puerta;
  }
  public String getTelefonos() {
    return telefonos;
  }
  public String getTipo_via() {
    return tipo_via;
  }
  public String getWeb() {
    return web;
  }
  public void setCp(String cp) {
    this.cp = cp;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setEscalera(String escalera) {
    this.escalera = escalera;
  }
  public void setId_pais(int id_pais) {
    this.id_pais = id_pais;
  }
  public void setId_poblacion(int id_poblacion) {
    this.id_poblacion = id_poblacion;
  }
  public void setId_provincia(int id_provincia) {
    this.id_provincia = id_provincia;
  }
  public void setMarca_act(String marca_act) {
    this.marca_act = marca_act;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setNombre_via(String nombre_via) {
    this.nombre_via = nombre_via;
  }
  public void setNumero_via(String numero_via) {
    this.numero_via = numero_via;
  }
  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }
  public void setOficina(int oficina) {
    this.oficina = oficina;
  }
  public void setPiso(String piso) {
    this.piso = piso;
  }
  public void setPuerta(String puerta) {
    this.puerta = puerta;
  }
  public void setTelefonos(String telefonos) {
    this.telefonos = telefonos;
  }
  public void setTipo_via(String tipo_via) {
    this.tipo_via = tipo_via;
  }
  public void setWeb(String web) {
    this.web = web;
  }
  public String getDir_libre() {
    if (dir_libre != null) {
      return dir_libre.replaceAll("(\r\n)|(\r)|(\n)", ".");
    } else {
      return null;
    }
  }
  public void setDir_libre(String dir_libre) {
    this.dir_libre = dir_libre;
  }
}
