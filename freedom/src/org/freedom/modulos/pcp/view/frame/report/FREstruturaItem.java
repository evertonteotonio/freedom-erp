/**
 * @version 06/05/2010 <BR>
 * @author Setpoint Inform�tica Ltda. Cristian Ribeiro Mietlicki
 * 
 *         Projeto: Freedom <BR>
 * 
 *         Pacote: org.freedom.modulos.pcp <BR>
 *         Classe:
 * @(#)FREstruturaPCP.java <BR>
 * 
 *                         Este arquivo � parte do sistema Freedom-ERP, o Freedom-ERP � um software livre; voc� pode redistribui-lo e/ou <BR>
 *                         modifica-lo dentro dos termos da Licen�a P�blica Geral GNU como publicada pela Funda��o do Software Livre (FSF); <BR>
 *                         na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o. <BR>
 *                         Este programa � distribuido na esperan�a que possa ser util, mas SEM NENHUMA GARANTIA; <BR>
 *                         sem uma garantia implicita de ADEQUA��O a qualquer MERCADO ou APLICA��O EM PARTICULAR. <BR>
 *                         Veja a Licen�a P�blica Geral GNU para maiores detalhes. <BR>
 *                         Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU junto com este programa, se n�o, <BR>
 *                         de acordo com os termos da LPG-PC <BR>
 * <BR>
 * 
 *                         Tela para cadastro de estruturas de produtos.
 * 
 */

package org.freedom.modulos.pcp.view.frame.report;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperPrintManager;
import org.freedom.infra.model.jdbc.DbConnection;
import org.freedom.library.functions.Funcoes;
import org.freedom.library.persistence.GuardaCampo;
import org.freedom.library.persistence.ListaCampos;
import org.freedom.library.swing.component.JLabelPad;
import org.freedom.library.swing.component.JTextFieldFK;
import org.freedom.library.swing.component.JTextFieldPad;
import org.freedom.library.swing.frame.Aplicativo;
import org.freedom.library.swing.frame.FPrinterJob;
import org.freedom.library.swing.frame.FRelatorio;
import org.freedom.library.type.TYPE_PRINT;

public class FREstruturaItem extends FRelatorio {

	private static final long serialVersionUID = 1L;

	private JTextFieldPad txtDataini = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtDatafim = new JTextFieldPad( JTextFieldPad.TP_DATE, 10, 0 );

	private JTextFieldPad txtCodProd = new JTextFieldPad( JTextFieldPad.TP_INTEGER, 8, 0 );

	private JTextFieldFK txtDescProd = new JTextFieldFK( JTextFieldPad.TP_STRING, 40, 0 );

	private JTextFieldFK txtRefProd = new JTextFieldFK( JTextFieldPad.TP_STRING, 20, 0 );

	private ListaCampos lcProdDE = new ListaCampos( this );

	public FREstruturaItem() {

		super( false );
		setTitulo( "Produ��o" );
		setAtribos( 100, 100, 320, 160 );

		montaTela();
		montaListaCampos();
	}

	private void montaTela() {

		adic( new JLabelPad( "C�d.Prod.Ini." ), 7, 25, 80, 20 );
		adic( txtCodProd, 7, 50, 80, 20 );

		adic( new JLabelPad( "Descri��o do produto inicial" ), 90, 25, 210, 20 );
		adic( txtDescProd, 90, 50, 210, 20 );

		Calendar cPeriodo = Calendar.getInstance();
		txtDatafim.setVlrDate( cPeriodo.getTime() );
		cPeriodo.set( Calendar.DAY_OF_MONTH, cPeriodo.get( Calendar.DAY_OF_MONTH ) - 30 );
		txtDataini.setVlrDate( cPeriodo.getTime() );

	}

	private void montaListaCampos() {

		lcProdDE.add( new GuardaCampo( txtCodProd, "CodProd", "C�d.prod.", ListaCampos.DB_PK, false ) );
		lcProdDE.add( new GuardaCampo( txtRefProd, "RefProd", "Refer�ncia do produto", ListaCampos.DB_SI, false ) );
		lcProdDE.add( new GuardaCampo( txtDescProd, "DescProd", "Descri��o do produto", ListaCampos.DB_SI, false ) );
		lcProdDE.setWhereAdic( "TIPOPROD IN ('F','M') " );
		txtCodProd.setTabelaExterna( lcProdDE, null );
		txtCodProd.setNomeCampo( "CodProd" );
		txtCodProd.setFK( true );
		lcProdDE.setReadOnly( true );
		lcProdDE.montaSql( false, "PRODUTO", "EQ" );

	}

	public void imprimir( TYPE_PRINT b ) {

		StringBuffer sql = new StringBuffer();
		StringBuffer sWhere = new StringBuffer();
		StringBuffer sCab = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			sql.append( "select es.seqest, es.descest,es.codprod, ie.qtditest, fs.descfase " );
			sql.append( "from ppestrutura es, ppitestrutura ie, ppfase fs " );
			sql.append( "where es.codemp=ie.codemp and es.codfilial=ie.codfilial and es.codprod=ie.codprod and es.seqest=ie.seqest " );
			sql.append( "and fs.codemp=ie.codempfs and fs.codfilial=ie.codfilialfs and fs.codfase=ie.codfase " );
			sql.append( "and ie.codemppd=? and ie.codfilialpd=? and ie.codprodpd=?" );

			ps = con.prepareStatement( sql.toString() );

			int iparam = 1;

			ps.setInt( iparam++, Aplicativo.iCodEmp );
			ps.setInt( iparam++, ListaCampos.getMasterFilial( "EQPRODUTO" ) );
			ps.setInt( iparam++, txtCodProd.getVlrInteger() );

			rs = ps.executeQuery();

			sCab.append( "Periodo: " + txtDataini.getVlrString() + " At�: " + txtDatafim.getVlrString() + " - " + "Produto: " + txtCodProd.getVlrString() + "-" + txtDescProd.getVlrString() );

			imprimiGrafico( rs, b, sCab.toString() );

		} catch ( SQLException err ) {
			err.printStackTrace();
			Funcoes.mensagemErro( this, "Erro ao buscar produ��o", true, con, err );
		}
	}

	private void imprimiGrafico( final ResultSet rs, final TYPE_PRINT bVisualizar, final String sCab ) {

		FPrinterJob dlGr = null;
		HashMap<String, Object> hParam = new HashMap<String, Object>();

		StringBuilder sql = new StringBuilder();
		StringBuilder status = new StringBuilder();
		StringBuilder filtros = new StringBuilder();

		hParam.put( "CODFILIAL", ListaCampos.getMasterFilial( "EQPRODUTO" ) );
		hParam.put( "RAZAOEMP", Aplicativo.empresa.toString() );
		hParam.put( "FILTROS", sCab );

		dlGr = new FPrinterJob( "layout/rel/REL_EST_ITEM.jasper", "Relat�rio de Produ��o", sCab, rs, hParam, this );

		if ( bVisualizar==TYPE_PRINT.VIEW ) {
			dlGr.preview();
		}
		else {
			try {
				dlGr.print(true);
			} catch ( Exception err ) {
				Funcoes.mensagemErro( this, "Erro na impress�o de Relat�rio de Produ��o!" + err.getMessage(), true, con, err );
			}
		}
	}

	public void setConexao( DbConnection con ) {

		super.setConexao( con );
		lcProdDE.setConexao( con );

	}
}
