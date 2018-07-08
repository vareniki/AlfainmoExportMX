package com.alfainmo.beans;

/**
 * Created by dmonje on 11/02/14.
 */
public class MyOtroDb extends AbstractPgObject {
	private int id;
	private int inmueble_id;
  	private String tipo_otro_id;
	private int area_total;
	private int anio_construccion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInmueble_id() {
		return inmueble_id;
	}

	public void setInmueble_id(int inmueble_id) {
		this.inmueble_id = inmueble_id;
	}

	public int getArea_total() {
		return area_total;
	}

	public void setArea_total(int area_total) {
		this.area_total = area_total;
	}

	  public String getTipo_otro_id() {
		return tipo_otro_id;
	  }

	  public void setTipo_otro_id(String tipo_otro_id) {
		this.tipo_otro_id = tipo_otro_id;
	  }

	public int getAnio_construccion() {
		return anio_construccion;
	}

	public void setAnio_construccion(int anio_construccion) {
		this.anio_construccion = anio_construccion;
	}
}
