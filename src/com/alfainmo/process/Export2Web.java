package com.alfainmo.process;

import com.alfainmo.beans.PgAgenciaInfo;
import com.alfainmo.beans.PgInmuebleInfo;
import com.alfainmo.beans.MyAgenciaDb;
import com.alfainmo.beans.MyAgenciaPortalDb;
import com.alfainmo.beans.MyChaletDb;
import com.alfainmo.beans.MyComercialDb;
import com.alfainmo.beans.MyEdificioDb;
import com.alfainmo.beans.MyGarajeDb;
import com.alfainmo.beans.MyImagenDb;
import com.alfainmo.beans.MyInmuebleDb;
import com.alfainmo.beans.MyInmueblePortalDb;
import com.alfainmo.beans.MyLocalDb;
import com.alfainmo.beans.MyNaveDb;
import com.alfainmo.beans.MyOficinaDb;
import com.alfainmo.beans.MyOtroDb;
import com.alfainmo.beans.MyPisoDb;
import com.alfainmo.beans.MyInmuebleTipoPuerta;
import com.alfainmo.beans.MyInmuebleTipoSuelo;
import com.alfainmo.beans.MyInmuebleTipoVentana;
import com.alfainmo.beans.MyPropietarioDb;
import com.alfainmo.beans.MyTerrenoDb;
import com.alfainmo.beans.MyViviendaDb;
import com.alfainmo.beans.PgAgenciaDb;
import com.alfainmo.beans.PgAgenciaPortalDb;
import com.alfainmo.beans.PgChaletTipoPuerta;
import com.alfainmo.beans.PgChaletTipoSuelo;
import com.alfainmo.beans.PgChaletTipoVentana;
import com.alfainmo.beans.PgImagenDb;
import com.alfainmo.beans.PgInmuebleDb;
import com.alfainmo.beans.PgInmueblePortalDb;
import com.alfainmo.beans.PgLocalTipoPuerta;
import com.alfainmo.beans.PgLocalTipoSuelo;
import com.alfainmo.beans.PgLocalTipoVentana;
import com.alfainmo.beans.PgNaveTipoPuerta;
import com.alfainmo.beans.PgNaveTipoSuelo;
import com.alfainmo.beans.PgNaveTipoVentana;
import com.alfainmo.beans.PgOficinaTipoPuerta;
import com.alfainmo.beans.PgOficinaTipoSuelo;
import com.alfainmo.beans.PgOficinaTipoVentana;
import com.alfainmo.beans.PgPisoTipoPuerta;
import com.alfainmo.beans.PgPisoTipoSuelo;
import com.alfainmo.beans.PgPisoTipoVentana;
import com.alfainmo.extra.AlfaException;
import com.alfainmo.util.BdUtils;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author dmonje
 */
public class Export2Web extends AbstractExport2Web {

  public Export2Web(BdUtils bdFnt, BdUtils bdDst) {
    super(bdFnt, bdDst);
  }

  /**
   *
   * @throws AlfaException
   */
  public void purgarInfoObsoleta() throws AlfaException {
    System.out.println("Actualizando la Web.");

    // Elimina los obsoletos de la nueva Web
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");

    bdDst.executeUpdate("DELETE FROM alfamx_web_info.agencias"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.agencias_portal"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");

    bdDst.executeUpdate("DELETE FROM alfamx_web_info.imagenes"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");

    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles_portal"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles_portal_no"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles_tipo_puerta"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles_tipo_suelo"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles_tipo_ventana"
            + " WHERE (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");
    
    System.out.println("OK");


    bdDst.commit();
  }

  /**
   *
   * @param inmuebleInfo
   * @return
   */
  private static String getVisibleEnWeb(PgInmuebleInfo inmuebleInfo) {

    PgInmuebleDb inmuebleDb = inmuebleInfo.getInmuebleDb();

    if (inmuebleDb.getTipo_contrato_id() != null) {
      switch (inmuebleDb.getTipo_contrato_id()) {
        case "PV":
          return "p";
        case "EV":
          return "v";
        case "AI":
          return "i";
        default:
          break;
      }
    }
  
    return "t";
  }

  private void annadirTipoPuerta(int inmuebleId, String tipoPuertaId) throws AlfaException {
    MyInmuebleTipoPuerta tipoPuertaDst = new MyInmuebleTipoPuerta();
    tipoPuertaDst.setInmueble_id(inmuebleId);
    tipoPuertaDst.setTipo_puerta_id(tipoPuertaId);
    tipoPuertaDst.setMarca_act(marcaAct);
    bdDst.replaceData("alfamx_web_info.inmuebles_tipo_puerta", tipoPuertaDst);
  }

  private void annadirTipoVentana(int inmuebleId, String tipoVentanaId) throws AlfaException {
    MyInmuebleTipoVentana tipoVentanaDst = new MyInmuebleTipoVentana();
    tipoVentanaDst.setInmueble_id(inmuebleId);
    tipoVentanaDst.setTipo_ventana_id(tipoVentanaId);
    tipoVentanaDst.setMarca_act(marcaAct);
    bdDst.replaceData("alfamx_web_info.inmuebles_tipo_ventana", tipoVentanaDst);
  }

  private void annadirTipoSuelo(int inmuebleId, String tipoSueloId) throws AlfaException {
    MyInmuebleTipoSuelo tipoSueloDst = new MyInmuebleTipoSuelo();
    tipoSueloDst.setInmueble_id(inmuebleId);
    tipoSueloDst.setTipo_suelo_id(tipoSueloId);
    tipoSueloDst.setMarca_act(marcaAct);
    bdDst.replaceData("alfamx_web_info.inmuebles_tipo_suelo", tipoSueloDst);
  }

  /**
   *
   * @param agenciaDb
   * @throws AlfaException
   */
  public void export2InfoAgencia(PgAgenciaDb agenciaDb) throws AlfaException {

    PgAgenciaInfo agenciaInfo = cargarAgenciaInfo(agenciaDb);
    
    // Exporta la agencia, portales a los que no debe exportar la agencia y sus inmuebles
    MyAgenciaDb agenciaDst = new MyAgenciaDb();
    try {
      BeanUtils.copyProperties(agenciaDst, agenciaDb);
      agenciaDst.setMarca_act(marcaAct);

      bdDst.replaceData("alfamx_web_info.agencias", agenciaDst);

      for (PgAgenciaPortalDb agenciaPortalDb : agenciaInfo.getPortales()) {
        MyAgenciaPortalDb agenciaPortalDst = new MyAgenciaPortalDb();
        BeanUtils.copyProperties(agenciaPortalDst, agenciaPortalDb);
        agenciaPortalDst.setMarca_act(marcaAct);
        bdDst.replaceData("alfamx_web_info.agencias_portal", agenciaPortalDst);
      }
      
      bdDst.commit();

    } catch (InvocationTargetException | IllegalAccessException e) {
      throw new AlfaException(e);
    }

    final SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");

    // Carga los inmuebles que est·n dados de alta tan sÛlo, y que est·n captados
    String sql = "SELECT * FROM inmuebles WHERE agencia_id=%d"
            + " AND fecha_captacion IS NOT NULL AND fecha_baja IS NULL AND motivo_baja_id IS NULL AND estado_inmueble_id='02'";

    List<PgInmuebleDb> inmueblesDb = bdFnt.getDataList(String.format(sql, agenciaDb.getId()), PgInmuebleDb.class);
    for (PgInmuebleDb inmuebleDb : inmueblesDb) {

      PgInmuebleInfo inmuebleInfo = cargarInmuebleInfo(inmuebleDb);

      MyInmuebleDb inmuebleDst = new MyInmuebleDb();
      try {
        BeanUtils.copyProperties(inmuebleDst, inmuebleDb);
        
        if (inmuebleDb.getDescripcion() != null) {
          inmuebleDst.setDescripcion(inmuebleDb.getDescripcion().replaceAll("([\\ud800-\\udbff\\udc00-\\udfff])", ""));
        }
        
        inmuebleDst.setMarca_act(marcaAct);
        if (inmuebleDb.getModified() != null) {
          inmuebleDst.setModified(dt.format(inmuebleDb.getModified()));
        } else {
          inmuebleDst.setModified(dt.format(Calendar.getInstance().getTime()));
        }
        
        inmuebleDst.setWeb(getVisibleEnWeb(inmuebleInfo));
        
        bdDst.replaceData("alfamx_web_info.inmuebles", inmuebleDst);

        //
        // Pisos
        //
        if (inmuebleInfo.getPisoDb() != null) {
          MyPisoDb pisoDst = new MyPisoDb();
          BeanUtils.copyProperties(pisoDst, inmuebleInfo.getPisoDb());
          bdDst.replaceData("alfamx_web_info.pisos", pisoDst);
          
          MyViviendaDb viviendaDst = new MyViviendaDb();
          BeanUtils.copyProperties(viviendaDst, inmuebleInfo.getPisoDb());
          viviendaDst.setTipo_inmueble_id("01");
          viviendaDst.setTipo_vivienda_id(inmuebleInfo.getPisoDb().getTipo_piso_id());
          bdDst.replaceData("alfamx_web_info.viviendas", viviendaDst);

          if (inmuebleInfo.getPisoTiposPuerta() != null) {
            for (PgPisoTipoPuerta tipoPuerta : inmuebleInfo.getPisoTiposPuerta()) {
              annadirTipoPuerta(inmuebleDb.getId(), tipoPuerta.getTipo_puerta_id());
            }
          }
          if (inmuebleInfo.getPisoTiposSuelo() != null) {
            for (PgPisoTipoSuelo tipoSuelo : inmuebleInfo.getPisoTiposSuelo()) {
              annadirTipoSuelo(inmuebleDb.getId(), tipoSuelo.getTipo_suelo_id());
            }
          }
          if (inmuebleInfo.getPisoTiposVentana() != null) {
            for (PgPisoTipoVentana tipoVentana : inmuebleInfo.getPisoTiposVentana()) {
              annadirTipoVentana(inmuebleDb.getId(), tipoVentana.getTipo_ventana_id());
            }
          }
        }
        //
        // Chalet
        //
        if (inmuebleInfo.getChaletDb() != null) {
          MyChaletDb chaletDst = new MyChaletDb();
          BeanUtils.copyProperties(chaletDst, inmuebleInfo.getChaletDb());
          bdDst.replaceData("alfamx_web_info.chalets", chaletDst);
          
          MyViviendaDb viviendaDst = new MyViviendaDb();
          BeanUtils.copyProperties(viviendaDst, inmuebleInfo.getChaletDb());
          viviendaDst.setTipo_inmueble_id("02");
          viviendaDst.setTipo_vivienda_id(inmuebleInfo.getChaletDb().getTipo_chalet_id());
          bdDst.replaceData("alfamx_web_info.viviendas", viviendaDst);

          if (inmuebleInfo.getChaletTiposPuerta() != null) {
            for (PgChaletTipoPuerta tipoPuerta : inmuebleInfo.getChaletTiposPuerta()) {
              annadirTipoPuerta(inmuebleDb.getId(), tipoPuerta.getTipo_puerta_id());
            }
          }
          if (inmuebleInfo.getChaletTiposSuelo() != null) {
            for (PgChaletTipoSuelo tipoSuelo : inmuebleInfo.getChaletTiposSuelo()) {
              annadirTipoSuelo(inmuebleDb.getId(), tipoSuelo.getTipo_suelo_id());
            }
          }
          if (inmuebleInfo.getChaletTiposVentana() != null) {
            for (PgChaletTipoVentana tipoVentana : inmuebleInfo.getChaletTiposVentana()) {
              annadirTipoVentana(inmuebleDb.getId(), tipoVentana.getTipo_ventana_id());
            }
          }
        }
        //
        // Local
        //
        if (inmuebleInfo.getLocalDb() != null) {
          MyLocalDb localDst = new MyLocalDb();
          BeanUtils.copyProperties(localDst, inmuebleInfo.getLocalDb());
          bdDst.replaceData("alfamx_web_info.locales", localDst);
          
          MyComercialDb comercialDst = new MyComercialDb();
          BeanUtils.copyProperties(comercialDst, inmuebleInfo.getLocalDb());
          comercialDst.setTipo_inmueble_id("03");
          comercialDst.setTipo_comercial_id(inmuebleInfo.getLocalDb().getTipo_local_id());
          bdDst.replaceData("alfamx_web_info.comerciales", comercialDst);

          if (inmuebleInfo.getLocalTiposPuerta() != null) {
            for (PgLocalTipoPuerta tipoPuerta : inmuebleInfo.getLocalTiposPuerta()) {
              annadirTipoPuerta(inmuebleDb.getId(), tipoPuerta.getTipo_puerta_id());
            }
          }
          if (inmuebleInfo.getLocalTiposSuelo() != null) {
            for (PgLocalTipoSuelo tipoSuelo : inmuebleInfo.getLocalTiposSuelo()) {
              annadirTipoSuelo(inmuebleDb.getId(), tipoSuelo.getTipo_suelo_id());
            }
          }
          if (inmuebleInfo.getLocalTiposVentana() != null) {
            for (PgLocalTipoVentana tipoVentana : inmuebleInfo.getLocalTiposVentana()) {
              annadirTipoVentana(inmuebleDb.getId(), tipoVentana.getTipo_ventana_id());
            }
          }
        }
        //
        // Oficina
        //
        if (inmuebleInfo.getOficinaDb() != null) {
          MyOficinaDb oficinaDst = new MyOficinaDb();
          BeanUtils.copyProperties(oficinaDst, inmuebleInfo.getOficinaDb());
          bdDst.replaceData("alfamx_web_info.oficinas", oficinaDst);
          
          MyComercialDb comercialDst = new MyComercialDb();
          BeanUtils.copyProperties(comercialDst, inmuebleInfo.getOficinaDb());
          comercialDst.setTipo_inmueble_id("04");
          comercialDst.setTipo_comercial_id(inmuebleInfo.getOficinaDb().getTipo_oficina_id());
          bdDst.replaceData("alfamx_web_info.comerciales", comercialDst);

          if (inmuebleInfo.getOficinaTiposPuerta() != null) {
            for (PgOficinaTipoPuerta tipoPuerta : inmuebleInfo.getOficinaTiposPuerta()) {
              annadirTipoPuerta(inmuebleDb.getId(), tipoPuerta.getTipo_puerta_id());
            }
          }
          if (inmuebleInfo.getOficinaTiposSuelo() != null) {
            for (PgOficinaTipoSuelo tipoSuelo : inmuebleInfo.getOficinaTiposSuelo()) {
              annadirTipoSuelo(inmuebleDb.getId(), tipoSuelo.getTipo_suelo_id());
            }
          }
          if (inmuebleInfo.getOficinaTiposVentana() != null) {
            for (PgOficinaTipoVentana tipoVentana : inmuebleInfo.getOficinaTiposVentana()) {
              annadirTipoVentana(inmuebleDb.getId(), tipoVentana.getTipo_ventana_id());
            }
          }
        }
        //
        // Garaje
        //
        if (inmuebleInfo.getGarajeDb() != null) {
          MyGarajeDb garajeDst = new MyGarajeDb();
          BeanUtils.copyProperties(garajeDst, inmuebleInfo.getGarajeDb());
          bdDst.replaceData("alfamx_web_info.garajes", garajeDst);
          
          MyEdificioDb edificioDst = new MyEdificioDb();
          BeanUtils.copyProperties(edificioDst, inmuebleInfo.getGarajeDb());
          edificioDst.setTipo_inmueble_id("05");
          edificioDst.setTipo_edificio_id(inmuebleInfo.getGarajeDb().getTipo_garaje_id());
          bdDst.replaceData("alfamx_web_info.edificios", edificioDst);
        }
        //
        // Terreno
        //
        if (inmuebleInfo.getTerrenoDb() != null) {
          MyTerrenoDb terrenoDst = new MyTerrenoDb();
          BeanUtils.copyProperties(terrenoDst, inmuebleInfo.getTerrenoDb());
          bdDst.replaceData("alfamx_web_info.terrenos", terrenoDst);
        }
        //
        // Nave
        //
        if (inmuebleInfo.getNaveDb() != null) {
          MyNaveDb naveDst = new MyNaveDb();
          BeanUtils.copyProperties(naveDst, inmuebleInfo.getNaveDb());
          bdDst.replaceData("alfamx_web_info.naves", naveDst);

          if (inmuebleInfo.getNaveTiposPuerta() != null) {
            for (PgNaveTipoPuerta tipoPuerta : inmuebleInfo.getNaveTiposPuerta()) {
              annadirTipoPuerta(inmuebleDb.getId(), tipoPuerta.getTipo_puerta_id());
            }
          }
          if (inmuebleInfo.getNaveTiposSuelo() != null) {
            for (PgNaveTipoSuelo tipoSuelo : inmuebleInfo.getNaveTiposSuelo()) {
              annadirTipoSuelo(inmuebleDb.getId(), tipoSuelo.getTipo_suelo_id());
            }
          }
          if (inmuebleInfo.getNaveTiposVentana() != null) {
            for (PgNaveTipoVentana tipoVentana : inmuebleInfo.getNaveTiposVentana()) {
              annadirTipoVentana(inmuebleDb.getId(), tipoVentana.getTipo_ventana_id());
            }
          }
        }
        //
        // Otro
        //
        if (inmuebleInfo.getOtroDb() != null) {
          MyOtroDb otroDst = new MyOtroDb();
          BeanUtils.copyProperties(otroDst, inmuebleInfo.getOtroDb());
          bdDst.replaceData("alfamx_web_info.otros", otroDst);
          
          MyEdificioDb edificioDst = new MyEdificioDb();
          BeanUtils.copyProperties(edificioDst, inmuebleInfo.getOtroDb());
          edificioDst.setTipo_inmueble_id("08");
          edificioDst.setTipo_edificio_id(inmuebleInfo.getOtroDb().getTipo_otro_id());
          bdDst.replaceData("alfamx_web_info.edificios", edificioDst);
        }
        if (inmuebleInfo.getPropietarioDb() != null) {
          MyPropietarioDb propietarioDst = new MyPropietarioDb();
          BeanUtils.copyProperties(propietarioDst, inmuebleInfo.getPropietarioDb());
          propietarioDst.setTelefono1_contacto(propietarioDst.getTelefono1_contacto().replaceAll("[^0-9]", ""));
          propietarioDst.setTelefono2_contacto(propietarioDst.getTelefono2_contacto().replaceAll("[^0-9]", ""));
          bdDst.replaceData("alfamx_web_info.propietarios", propietarioDst);
        }
        if (inmuebleInfo.getImagenes() != null) {
          boolean primeraImagen = true;
          for (PgImagenDb imagenDb : inmuebleInfo.getImagenes()) {
            MyImagenDb imagenDst = new MyImagenDb();
            BeanUtils.copyProperties(imagenDst, imagenDb);
            if (primeraImagen && !imagenDb.getTipo_imagen_id().equals("07")) {
              imagenDst.setOrden(-1);
              primeraImagen = false;
            }
            imagenDst.setMarca_act(marcaAct);
            bdDst.replaceData("alfamx_web_info.imagenes", imagenDst);
          }
        }
        if (inmuebleInfo.getPortales() != null) {
          for (PgInmueblePortalDb inmueblePortalDb : inmuebleInfo.getPortales()) {
            MyInmueblePortalDb inmueblePortalDst = new MyInmueblePortalDb();
            BeanUtils.copyProperties(inmueblePortalDst, inmueblePortalDb);
            inmueblePortalDst.setMarca_act(marcaAct);
            bdDst.replaceData("alfamx_web_info.inmuebles_portal", inmueblePortalDst);
          }
        }
        
        if (inmuebleInfo.getNoPortales() != null) {
          for (PgInmueblePortalDb inmuebleNoPortalDb : inmuebleInfo.getNoPortales()) {
            MyInmueblePortalDb inmuebleNoPortalDst = new MyInmueblePortalDb();
            BeanUtils.copyProperties(inmuebleNoPortalDst, inmuebleNoPortalDb);
            inmuebleNoPortalDst.setMarca_act(marcaAct);
            bdDst.replaceData("alfamx_web_info.inmuebles_portal_no", inmuebleNoPortalDst);
          }
        }

        bdDst.commit();

      } catch (AlfaException | InvocationTargetException | IllegalAccessException e) {
        bdDst.rollback();

        System.out.println("Error en referencia " + inmuebleDb.getNumero_agencia() + "/" + inmuebleDb.getCodigo());

        e.printStackTrace();
      }
    }

    System.out.println("Eliminamos obsoletos...");

    bdDst.executeUpdate("DELETE FROM alfamx_web_info.inmuebles"
            + " WHERE numero_agencia=" + agenciaDb.getNumero_agencia()
            + " AND (marca_act IS NULL OR marca_act <> '" + marcaAct + "')");

    System.out.println("OK");
  }
}
