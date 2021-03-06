/**
 * @version 07/2007 <BR>
 * @author Setpoint Inform�tica Ltda./Alex Rodrigues<BR>
 * 
 *         Projeto: Freedom <BR>
 * 
 *         Pacote: org.freedom.modulos.std <BR>
 *         Classe:
 * @(#)FRetSiacc.java <BR>
 * 
 *                    Este arquivo � parte do sistema Freedom-ERP, o Freedom-ERP � um software livre; voc� pode redistribui-lo e/ou <BR>
 *                    modifica-lo dentro dos termos da Licen�a P�blica Geral GNU como publicada pela Funda��o do Software Livre (FSF); <BR>
 *                    na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o. <BR>
 *                    Este programa � distribuido na esperan�a que possa ser util, mas SEM NENHUMA GARANTIA; <BR>
 *                    sem uma garantia implicita de ADEQUA��O a qualquer MERCADO ou APLICA��O EM PARTICULAR. <BR>
 *                    Veja a Licen�a P�blica Geral GNU para maiores detalhes. <BR>
 *                    Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU junto com este programa, se n�o, <BR>
 *                    de acordo com os termos da LPG-PC <BR>
 * <BR>
 * 
 *                    Tela de leitura do arquivo de retorno de Siacc.
 * 
 */

package org.freedom.modulos.fnc.library.swing.frame;

import java.awt.Cursor;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.freedom.library.business.exceptions.ExceptionSiacc;
import org.freedom.library.functions.Funcoes;
import org.freedom.library.persistence.ListaCampos;
import org.freedom.library.swing.frame.Aplicativo;
import org.freedom.modulos.fnc.business.component.siacc.Reg;
import org.freedom.modulos.fnc.business.component.siacc.RegA;
import org.freedom.modulos.fnc.business.component.siacc.RegB;
import org.freedom.modulos.fnc.business.component.siacc.RegC;
import org.freedom.modulos.fnc.business.component.siacc.RegE;
import org.freedom.modulos.fnc.business.component.siacc.RegF;
import org.freedom.modulos.fnc.business.component.siacc.RegH;
import org.freedom.modulos.fnc.business.component.siacc.RegJ;
import org.freedom.modulos.fnc.business.component.siacc.RegX;
import org.freedom.modulos.fnc.business.component.siacc.RegZ;
import org.freedom.modulos.fnc.library.swing.dialog.DLRegB;
import org.freedom.modulos.fnc.view.frame.crud.tabbed.FPrefereFBB;

public class FRetSiacc extends FRetFBN {

	private static final long serialVersionUID = 1L;

	public FRetSiacc() {

		super( FPrefereFBB.TP_SIACC );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.freedom.modulos.fnc.FRetFBN#execImportar()
	 */
	@ Override
	protected boolean execImportar() {

		boolean retorno = true;
		FileReader fileReaderSiacc = null;
		ArrayList<Reg> list = new ArrayList<Reg>();

		setCursor( Cursor.getPredefinedCursor( Cursor.WAIT_CURSOR ) );

		if ( "".equals( txtCodBanco.getVlrString() ) ) {
			Funcoes.mensagemInforma( this, "Selecione o Banco!!" );
			txtCodBanco.requestFocus();
		}
		else {

			lbStatus.setText( "     Lendo do arquivo ..." );

			FileDialog fileDialogSiacc = null;
			fileDialogSiacc = new FileDialog( Aplicativo.telaPrincipal, "Importar arquivo." );
			fileDialogSiacc.setFile( "*.ret; *.cmp; *.txt" );
			fileDialogSiacc.setVisible( true );

			if ( fileDialogSiacc.getFile() == null ) {
				lbStatus.setText( "" );
				retorno = false;
			}
			else {

				String sFileName = fileDialogSiacc.getDirectory() + fileDialogSiacc.getFile();
				File fileSiacc = new File( sFileName );

				if ( fileSiacc.exists() ) {

					try {

						fileReaderSiacc = new FileReader( fileSiacc );

						if ( leArquivo( fileReaderSiacc, list ) ) {

							if ( !montaGrid( list ) ) {
								Funcoes.mensagemInforma( this, "Nenhum registro de retorno encontrado." );
								lbStatus.setText( "" );
								retorno = false;
							}
						}
					} catch ( IOException ioError ) {
						Funcoes.mensagemErro( this, "Erro ao ler o arquivo: " + sFileName + "\n" + ioError.getMessage() );
						lbStatus.setText( "" );
						retorno = false;
					}
				}
				else {
					Funcoes.mensagemErro( this, "Arquivo " + sFileName + " n�o existe!" );
					retorno = false;
				}
			}
		}

		setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR ) );

		return retorno;
	}

	private boolean leArquivo( final FileReader fileReaderSiacc, final ArrayList<org.freedom.modulos.fnc.business.component.siacc.Reg> list ) throws IOException {

		boolean retorno = true;
		char tipo;
		String line = null;
		BufferedReader in = new BufferedReader( fileReaderSiacc );

		try {
			learquivo : while ( ( line = in.readLine() ) != null ) {

				tipo = line.charAt( 0 );
				switch ( tipo ) {
					case 'A' :
						list.add( new RegA( line ) );
						break;
					case 'B' :
						list.add( new RegB( line ) );
						break;
					case 'C' :
						list.add( new RegC( line ) );
						break;
					case 'E' :
						list.add( new RegE( line ) );
						break;
					case 'F' :
						list.add( new RegF( line ) );
						break;
					case 'J' :
						list.add( new RegJ( line ) );
						break;
					case 'H' :
						list.add( new RegH( line ) );
						break;
					case 'X' :
						list.add( new RegX( line ) );
						break;
					case 'Z' :
						list.add( new RegZ( line ) );
						break;
					default :
						break learquivo;
				}
			}

			lbStatus.setText( "     Arquivo lido ..." );
		} catch ( ExceptionSiacc e ) {
			Funcoes.mensagemErro( this, "Erro lendo o arquivo!\n" + e.getMessage() );
			e.printStackTrace();
			retorno = false;
			lbStatus.setText( "" );
		}

		in.close();

		return retorno;
	}

	private boolean montaGrid( ArrayList<Reg> list ) {

		boolean retorno = true;
		int row = 0;

		if ( list != null ) {

			lbStatus.setText( "     Carregando tabela ..." );

			tab.limpa();

			List<Object> infocli = new ArrayList<Object>();
			List<RegB> regsB = null;
			String regJ = null;

			try {

				for ( Reg reg : list ) {

					if ( reg.getTiporeg() == 'F' ) {

						infocli.clear();

						if ( !setInfoCli( ( (RegF) reg ).getCodRec(), ( (RegF) reg ).getNparcItRec(), infocli ) ) {
							retorno = false;
							break;
						}
						if ( infocli.size() == EColInfoCli.values().length ) {

							tab.adicLinha();

							if ( "00".equals( ( (RegF) reg ).getCodRetorno() ) ) {

								tab.setValor( imgConfBaixa, row, EColTab.STATUS.ordinal() );
								tab.setValor( new Boolean( Boolean.TRUE ), row, EColTab.SEL.ordinal() );
							}
							else {

								updateStatusRetorno( (RegF) reg );

								tab.setValor( imgRejBaixa, row, EColTab.STATUS.ordinal() );
								tab.setValor( new Boolean( Boolean.FALSE ), row, EColTab.SEL.ordinal() );
							}

							String[] mensret = getDetRetorno( txtCodBanco.getVlrString(), ( (RegF) reg ).getCodRetorno(), FPrefereFBB.TP_SIACC );

							tab.setValor( (String) infocli.get( EColInfoCli.RAZCLI.ordinal() ), row, EColTab.RAZCLI.ordinal() ); // Raz�o social do cliente
							tab.setValor( (Integer) infocli.get( EColInfoCli.CODCLI.ordinal() ), row, EColTab.CODCLI.ordinal() ); // C�d.cli.
							tab.setValor( (Integer) infocli.get( EColInfoCli.CODREC.ordinal() ), row, EColTab.CODREC.ordinal() ); // C�d.rec.
							tab.setValor( (String) infocli.get( EColInfoCli.DOCREC.ordinal() ), row, EColTab.DOCREC.ordinal() ); // Doc
							tab.setValor( (Integer) infocli.get( EColInfoCli.NPARCITREC.ordinal() ), row, EColTab.NRPARC.ordinal() ); // Nro.Parc.
							tab.setValor( Funcoes.bdToStr( (BigDecimal) infocli.get( EColInfoCli.VLRAPAGITREC.ordinal() ) ), row, EColTab.VLRAPAG.ordinal() ); // Valor
							tab.setValor( (Date) infocli.get( EColInfoCli.DTITREC.ordinal() ), row, EColTab.DTREC.ordinal() ); // Emiss�o
							tab.setValor( (Date) infocli.get( EColInfoCli.DTVENCITREC.ordinal() ), row, EColTab.DTVENC.ordinal() ); // Vencimento
							tab.setValor( Funcoes.bdToStr( (BigDecimal) ( (RegF) reg ).getValorDebCred() ), row, EColTab.VLRPAG.ordinal() ); // Valor pago
							tab.setValor( Funcoes.dateToStrDate( ( (RegF) reg ).getDataVenc() ), row, EColTab.DTPAG.ordinal() ); // Data pgto.
							tab.setValor( (String) infocli.get( EColInfoCli.NUMCONTA.ordinal() ), row, EColTab.NUMCONTA.ordinal() ); // Conta
							tab.setValor( (String) infocli.get( EColInfoCli.CODPLAN.ordinal() ), row, EColTab.CODPLAN.ordinal() ); // Planejamento
							tab.setValor( Funcoes.bdToStr( new BigDecimal( 0 ) ), row, EColTab.VLRDESC.ordinal() ); // VLRDESC
							tab.setValor( Funcoes.bdToStr( new BigDecimal( 0 ) ), row, EColTab.VLRJUROS.ordinal() ); // VLRJUROS
							tab.setValor( "BAIXA AUTOM�TICA SIACC", row, EColTab.OBS.ordinal() ); // HIST�RICO
							tab.setValor( (String) infocli.get( EColInfoCli.TIPOFEBRABAN.ordinal() ), row, EColTab.TIPOFEBRABAN.ordinal() );
							tab.setValor( ( (RegF) reg ).getCodRetorno(), row, EColTab.CODRET.ordinal() ); // c�digo retorno
							tab.setValor( mensret[ 0 ], row, EColTab.MENSSAGEM.ordinal() ); // Menssagem de erro

							row++;
						}
					}
					else if ( reg.getTiporeg() == 'B' ) {

						if ( regsB == null ) {
							regsB = new ArrayList<RegB>();
						}

						regsB.add( (RegB) reg );
					}
					else if ( reg.getTiporeg() == 'J' ) {

						regJ = ( (RegJ) reg ).getMenssagemInfo();
					}
				}

				if ( row > 0 ) {
					lbStatus.setText( "     Tabela carregada ..." );
				}
				else {
					lbStatus.setText( "     Informa��es do cliente n�o encontradas ..." );
				}

				montaDlRegB( regsB );

				if ( regJ != null && regJ.trim().length() > 0 ) {

					Funcoes.mensagemInforma( this, regJ );
				}

			} catch ( Exception e ) {
				retorno = false;
				Funcoes.mensagemErro( this, "Erro no carregamento da tabela!\n" + e.getMessage() );
				e.printStackTrace();
				lbStatus.setText( "" );
			}
		}
		else {
			retorno = false;
		}

		return retorno;
	}

	private void montaDlRegB( final List<RegB> regs ) {

		if ( regs != null ) {

			DLRegB dl = new DLRegB( this );

			if ( dl.montaGrid( regs, con ) ) {

				dl.setVisible( true );
			}
		}
	}

	private void updateStatusRetorno( final RegF registro ) {

		try {

			StringBuilder sql = new StringBuilder();
			sql.append( "UPDATE FNFBNREC SET SITRETORNO=?" );
			sql.append( "WHERE CODEMP=? AND CODFILIAL=? AND CODREC=? AND NPARCITREC=? " );

			PreparedStatement ps = con.prepareStatement( sql.toString() );
			ps.setString( 1, registro.getCodRetorno() );
			ps.setInt( 2, Aplicativo.iCodEmp );
			ps.setInt( 3, ListaCampos.getMasterFilial( "FNFBNREC" ) );
			ps.setInt( 4, registro.getCodRec() );
			ps.setInt( 5, registro.getNparcItRec() );
			ps.executeUpdate();
			ps.close();

			con.commit();
		} catch ( Exception e ) {
			Funcoes.mensagemErro( this, "Erro ao atualizar status do registro!\n" + e.getMessage(), true, con, e );
		}
	}

	@ Override
	protected boolean loadGrid() {

		return false;
	}

}
