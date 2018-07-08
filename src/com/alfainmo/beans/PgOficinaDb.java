package com.alfainmo.beans;

/**
 * Created by dmonje on 11/02/14.
 */
public class PgOficinaDb extends AbstractPgObject {
	private int id;
	private int inmueble_id;
	private String tipo_oficina_id;
	private String bloque;
	private String escalera;
	private String piso;
	private String puerta;
	private String urbanizacion;
	private int numero_banos;
	private int area_total_construida;
	private int area_salon;
	private double gastos_comunidad;
	private int numero_ascensores;
	private int altura_edificio;
	private int plazas_parking;
	private int anio_construccion;
	private String estado_conservacion_id;
	private String tipo_calefaccion_id;
	private String tipo_agua_caliente_id;
	private String interior_exterior_id;
	private String tipo_aa_id;
	private String tipo_orientacion_id;
	private String tipo_cableado_id;
	private String con_almacen;
	private String con_zona_carga_descarga;
	private String con_puerta_seguridad;
	private String con_camaras_seguridad;
	private String con_alarma;
	private String con_instalaciones_deportivas;
	private String calificacion_energetica_id;
	private int indice_energetico;
	private String subtipo_calefaccion;
	private int area_total_util;
	private String con_vigilancia_24h;
	private int numero_armarios;
	private int plantas_edificio;
	private int numero_aseos;
	private int numero_habitaciones;
  private String comunidad_moneda_id;

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

	public String getTipo_oficina_id() {
		return tipo_oficina_id;
	}

	public void setTipo_oficina_id(String tipo_oficina_id) {
		this.tipo_oficina_id = tipo_oficina_id;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getUrbanizacion() {
		return urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

	public int getNumero_banos() {
		return numero_banos;
	}

	public void setNumero_banos(int numero_banos) {
		this.numero_banos = numero_banos;
	}

	public int getArea_total_construida() {
		return area_total_construida;
	}

	public void setArea_total_construida(int area_total_construida) {
		this.area_total_construida = area_total_construida;
	}

	public int getArea_salon() {
		return area_salon;
	}

	public void setArea_salon(int area_salon) {
		this.area_salon = area_salon;
	}

	public double getGastos_comunidad() {
		return gastos_comunidad;
	}

	public void setGastos_comunidad(double gastos_comunidad) {
		this.gastos_comunidad = gastos_comunidad;
	}

	public int getAltura_edificio() {
		return altura_edificio;
	}

	public void setAltura_edificio(int altura_edificio) {
		this.altura_edificio = altura_edificio;
	}

	public int getPlazas_parking() {
		return plazas_parking;
	}

	public void setPlazas_parking(int plazas_parking) {
		this.plazas_parking = plazas_parking;
	}

	public int getAnio_construccion() {
		return anio_construccion;
	}

	public void setAnio_construccion(int anio_construccion) {
		this.anio_construccion = anio_construccion;
	}

	public String getEstado_conservacion_id() {
		return estado_conservacion_id;
	}

	public void setEstado_conservacion_id(String estado_conservacion_id) {
		this.estado_conservacion_id = estado_conservacion_id;
	}

	public String getTipo_calefaccion_id() {
		return tipo_calefaccion_id;
	}

	public void setTipo_calefaccion_id(String tipo_calefaccion_id) {
		this.tipo_calefaccion_id = tipo_calefaccion_id;
	}

	public String getTipo_agua_caliente_id() {
		return tipo_agua_caliente_id;
	}

	public void setTipo_agua_caliente_id(String tipo_agua_caliente_id) {
		this.tipo_agua_caliente_id = tipo_agua_caliente_id;
	}

	public String getInterior_exterior_id() {
		return interior_exterior_id;
	}

	public void setInterior_exterior_id(String interior_exterior_id) {
		this.interior_exterior_id = interior_exterior_id;
	}

	public String getTipo_aa_id() {
		return tipo_aa_id;
	}

	public void setTipo_aa_id(String tipo_aa_id) {
		this.tipo_aa_id = tipo_aa_id;
	}

	public String getTipo_orientacion_id() {
		return tipo_orientacion_id;
	}

	public void setTipo_orientacion_id(String tipo_orientacion_id) {
		this.tipo_orientacion_id = tipo_orientacion_id;
	}

	public String getTipo_cableado_id() {
		return tipo_cableado_id;
	}

	public void setTipo_cableado_id(String tipo_cableado_id) {
		this.tipo_cableado_id = tipo_cableado_id;
	}

	public String getCon_almacen() {
		return con_almacen;
	}

	public void setCon_almacen(String con_almacen) {
		this.con_almacen = con_almacen;
	}

	public String getCon_zona_carga_descarga() {
		return con_zona_carga_descarga;
	}

	public void setCon_zona_carga_descarga(String con_zona_carga_descarga) {
		this.con_zona_carga_descarga = con_zona_carga_descarga;
	}

	public String getCon_puerta_seguridad() {
		return con_puerta_seguridad;
	}

	public void setCon_puerta_seguridad(String con_puerta_seguridad) {
		this.con_puerta_seguridad = con_puerta_seguridad;
	}

	public String getCon_camaras_seguridad() {
		return con_camaras_seguridad;
	}

	public void setCon_camaras_seguridad(String con_camaras_seguridad) {
		this.con_camaras_seguridad = con_camaras_seguridad;
	}

	public String getCon_alarma() {
		return con_alarma;
	}

	public void setCon_alarma(String con_alarma) {
		this.con_alarma = con_alarma;
	}

	public String getCon_instalaciones_deportivas() {
		return con_instalaciones_deportivas;
	}

	public void setCon_instalaciones_deportivas(String con_instalaciones_deportivas) {
		this.con_instalaciones_deportivas = con_instalaciones_deportivas;
	}

	public String getCalificacion_energetica_id() {
		return calificacion_energetica_id;
	}

	public void setCalificacion_energetica_id(String calificacion_energetica_id) {
		this.calificacion_energetica_id = calificacion_energetica_id;
	}

	public int getIndice_energetico() {
		return indice_energetico;
	}

	public void setIndice_energetico(int indice_energetico) {
		this.indice_energetico = indice_energetico;
	}

	public String getSubtipo_calefaccion() {
		return subtipo_calefaccion;
	}

	public void setSubtipo_calefaccion(String subtipo_calefaccion) {
		this.subtipo_calefaccion = subtipo_calefaccion;
	}

	public int getArea_total_util() {
		return area_total_util;
	}

	public void setArea_total_util(int area_total_util) {
		this.area_total_util = area_total_util;
	}

	public String getCon_vigilancia_24h() {
		return con_vigilancia_24h;
	}

	public void setCon_vigilancia_24h(String con_vigilancia_24h) {
		this.con_vigilancia_24h = con_vigilancia_24h;
	}

	public int getNumero_armarios() {
		return numero_armarios;
	}

	public void setNumero_armarios(int numero_armarios) {
		this.numero_armarios = numero_armarios;
	}

	public int getPlantas_edificio() {
		return plantas_edificio;
	}

	public void setPlantas_edificio(int plantas_edificio) {
		this.plantas_edificio = plantas_edificio;
	}

	public int getNumero_aseos() {
		return numero_aseos;
	}

	public void setNumero_aseos(int numero_aseos) {
		this.numero_aseos = numero_aseos;
	}

	public int getNumero_habitaciones() {
		return numero_habitaciones;
	}

	public void setNumero_habitaciones(int numero_habitaciones) {
		this.numero_habitaciones = numero_habitaciones;
	}

	public int getNumero_ascensores() {
		return numero_ascensores;
	}

	public void setNumero_ascensores(int numero_ascensores) {
		this.numero_ascensores = numero_ascensores;
	}

  public String getComunidad_moneda_id() {
    return comunidad_moneda_id;
  }

  public void setComunidad_moneda_id(String comunidad_moneda_id) {
    this.comunidad_moneda_id = comunidad_moneda_id;
  }
  
}
