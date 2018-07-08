package com.alfainmo;

import com.alfainmo.beans.PgAgenciaDb;
import com.alfainmo.extra.AlfaException;
import com.alfainmo.process.Export2Web;
import com.alfainmo.util.BdUtils;
import com.alfainmo.util.ConfigUtils;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.List;
import java.util.Properties;

public class Export2WebMx {

  @SuppressWarnings("ResultOfObjectAllocationIgnored")
  public static void main(String[] args) throws AlfaException, JSchException {
    new Export2WebMx(args);
  }

  private static Session doSshTunnel( String strSshUser, String strSshPassword, String strSshHost,
                                   int nSshPort, String strRemoteHost, int nLocalPort, int nRemotePort ) throws JSchException
  {
    final JSch jsch = new JSch();
    Session session = jsch.getSession( strSshUser, strSshHost, nSshPort );
    session.setPassword( strSshPassword );

    final Properties config = new Properties();
    config.put( "StrictHostKeyChecking", "no" );
    session.setConfig( config );

    session.connect();
    session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);

    return session;
  }

  /**
   *
   * @param args
   * @throws AlfaException
   */
  public Export2WebMx(String[] args) throws AlfaException, JSchException {

    ConfigUtils cfg = ConfigUtils.getInstance();

    Session session = doSshTunnel(
            cfg.getString("fnt_sshUser"),
            cfg.getString("fnt_sshPass"),
            cfg.getString("fnt_sshHost"),
            Integer.parseInt(cfg.getString("fnt_sshPort")),
            cfg.getString("fnt_sshRemoteHost"),
            Integer.parseInt(cfg.getString("fnt_sshRemotePort")),
            Integer.parseInt(cfg.getString("fnt_sshRemotePort")));


    BdUtils bdFnt = new BdUtils(
            cfg.getString("fnt_jdbcDriver"), cfg.getString("fnt_jdbcURL"),
            cfg.getString("fnt_jdbcUser"), cfg.getString("fnt_jdbcPass"));


    BdUtils bdDst = new BdUtils(
            cfg.getString("dst_jdbcDriver"), cfg.getString("dst_jdbcURL"),
            cfg.getString("dst_jdbcUser"), cfg.getString("dst_jdbcPass"));

    bdFnt.connect();
    bdDst.connect();


    try {

      if (args.length == 0) {

        List<PgAgenciaDb> agenciasDb = bdFnt.getDataList("SELECT a.* FROM agencias a WHERE a.active='t' "
                + "AND (a.solo_central IS NULL OR a.solo_central <> 't') ORDER BY a.numero_agencia", PgAgenciaDb.class);

        Export2Web export = new Export2Web(bdFnt, bdDst);

        for (PgAgenciaDb agenciaDb : agenciasDb) {
          System.out.println("Exportando info de " + agenciaDb.getNumero_agencia());

          export.export2InfoAgencia(agenciaDb);
        }

        export.purgarInfoObsoleta();
      }

    } finally {
      bdFnt.disconnect();
      bdDst.disconnect();
      session.disconnect();
    }

  }

}
