package com.alfainmo.beans;

/**
 * Created by dmonje on 09/02/14.
 */
public class MyAgenciaDb extends AbstractPgObject {
	private int id;
	private String nombre_agencia;
	private int numero_agencia;
	private String cif;
	private int pais_id;
	private String codigo_postal;
	private String poblacion;
	private String nombre_calle;
	private String numero_calle;
	private String nombre_contacto;
	private String email_contacto;
	private String telefono1_contacto;
	private String telefono2_contacto;
	private String fax;
	private String Web;
	private int poblacion_id;
  private int provincia_id;
  private double coord_x;
  private double coord_y;

  private String nombre_fiscal;
	private String marca_act;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_agencia() {
		return nombre_agencia;
	}

	public void setNombre_agencia(String nombre_agencia) {
		this.nombre_agencia = nombre_agencia;
	}

	public int getNumero_agencia() {
		return numero_agencia;
	}

	public void setNumero_agencia(int numero_agencia) {
		this.numero_agencia = numero_agencia;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public int getPais_id() {
		return pais_id;
	}

	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}

	public String getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(String codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getNombre_calle() {
		return nombre_calle;
	}

	public void setNombre_calle(String nombre_calle) {
		this.nombre_calle = nombre_calle;
	}

	public String getNumero_calle() {
		return numero_calle;
	}

	public void setNumero_calle(String numero_calle) {
		this.numero_calle = numero_calle;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getEmail_contacto() {
		return email_contacto;
	}

	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}

	public String getTelefono1_contacto() {
		return telefono1_contacto;
	}

	public void setTelefono1_contacto(String telefono1_contacto) {
		this.telefono1_contacto = telefono1_contacto;
	}

	public String getTelefono2_contacto() {
		return telefono2_contacto;
	}

	public void setTelefono2_contacto(String telefono2_contacto) {
		this.telefono2_contacto = telefono2_contacto;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWeb() {
		return Web;
	}

	public void setWeb(String web) {
		Web = web;
	}

	public int getPoblacion_id() {
		return poblacion_id;
	}

	public void setPoblacion_id(int poblacion_id) {
		this.poblacion_id = poblacion_id;
	}

	public String getMarca_act() {
		return marca_act;
	}

	public void setMarca_act(String marca_act) {
		this.marca_act = marca_act;
	}

  public int getProvincia_id() {
    return provincia_id;
  }

  public void setProvincia_id(int provincia_id) {
    this.provincia_id = provincia_id;
  }

  public double getCoord_x() {
    return coord_x;
  }

  public void setCoord_x(double coord_x) {
    this.coord_x = coord_x;
  }

  public double getCoord_y() {
    return coord_y;
  }

  public void setCoord_y(double coord_y) {
    this.coord_y = coord_y;
  }

  public String getNombre_fiscal() {
    return nombre_fiscal;
  }

  public void setNombre_fiscal(String nombre_fiscal) {
    this.nombre_fiscal = nombre_fiscal;
  }
  
}
