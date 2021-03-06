/**
 * @version 01/06/2001 <BR>
 * @author Setpoint Inform�tica Ltda./Fernando Oliveira da Silva <BR>
 *
 * Projeto: Freedom <BR>
 * Pacote: org.freedom.telas <BR>
 * Classe: @(#)FRelatorio.java <BR>
 * 
 * Este arquivo � parte do sistema Freedom-ERP, o Freedom-ERP � um software livre; voc� pode redistribui-lo e/ou <BR>
 * modifica-lo dentro dos termos da Licen�a P�blica Geral GNU como publicada pela Funda��o do Software Livre (FSF); <BR>
 * na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o. <BR>
 * Este programa � distribuido na esperan�a que possa ser  util, mas SEM NENHUMA GARANTIA; <BR>
 * sem uma garantia implicita de ADEQUA��O a qualquer MERCADO ou APLICA��O EM PARTICULAR. <BR>
 * Veja a Licen�a P�blica Geral GNU para maiores detalhes. <BR>
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU junto com este programa, se n�o, <BR>
 * escreva para a Funda��o do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA <BR> <BR>
 *
 * Formul�rio modelo para relat�rios.
 */

package org.freedom.library.swing.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;

import org.freedom.bmps.Icone;
import org.freedom.infra.beans.Sgestacao;
import org.freedom.library.business.component.PrintConstant;
import org.freedom.library.swing.component.JButtonPad;
import org.freedom.library.swing.component.JButtonXLS;
import org.freedom.library.swing.component.JLabelPad;
import org.freedom.library.swing.component.JPanelPad;
import org.freedom.library.swing.dialog.DLLoading;
import org.freedom.library.type.TYPE_PRINT;

public abstract class FRelatorio extends FFilho implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;

	private JPanelPad pinCli = new JPanelPad(350, 170);

	private JPanelPad pnRod = new JPanelPad(JPanelPad.TP_JPANEL, new BorderLayout());

	private JPanelPad pnCentRod = new JPanelPad(JPanelPad.TP_JPANEL, new FlowLayout(FlowLayout.CENTER, 0, 0));

	public JPanelPad pnBotoes = new JPanelPad(JPanelPad.TP_JPANEL, new GridLayout(1, 2));

	protected JButtonPad btImp = new JButtonPad(Icone.novo("btImprime.png"));

	protected JButtonPad btPrevimp = new JButtonPad(Icone.novo("btPrevimp.png"));
	
	protected JButtonXLS btExportXLS = new JButtonXLS();

	private JButtonPad btSair = new JButtonPad("Sair", Icone.novo("btSair.png"));

	private final DLLoading wait = new DLLoading();
	
	boolean setArea = true;

	boolean bCtrl = false;

	Container c = null;

	private Sgestacao sgestacao = null;

	public FRelatorio() {
		this(true);
	}

	public FRelatorio(boolean comScroll) {
		super(comScroll);
		setSgestacao(Aplicativo.getInstance().getSgestacao());
		setTitulo("Requisi�ao de Relat�rio", this.getClass().getName());
		setAtribos(100, 100, 350, 200);
		c = super.getTela();
		pnRod.setBorder(BorderFactory.createEtchedBorder());
		c.add(pnRod, BorderLayout.SOUTH);
		pnRod.setPreferredSize(new Dimension(350, 32));
		btSair.setPreferredSize(new Dimension(100, 30));
		pnRod.add(btSair, BorderLayout.EAST);
		pnRod.add(pnCentRod, BorderLayout.CENTER);
		pnBotoes.setPreferredSize(new Dimension(120, 28));
		pnCentRod.add(pnBotoes);
		pnBotoes.add(btImp);
		pnBotoes.add(btPrevimp);
		pnBotoes.add(btExportXLS);
		btExportXLS.addActionListener( this );
		if (getSgestacao()==null || !"S".equalsIgnoreCase(getSgestacao().getPrintpdf())) {
			btImp.setToolTipText(PrintConstant.TEXTOIMP01);
			btPrevimp.setToolTipText(PrintConstant.TEXTOPREVIMP01);
		} else  {
			btImp.setIcon(Icone.novo("btPrevimp.png"));
			btPrevimp.setIcon(Icone.novo("btPdf.gif"));
			btImp.setToolTipText(PrintConstant.TEXTOIMP02);
			btPrevimp.setToolTipText(PrintConstant.TEXTOPREVIMP02);
		}
		btSair.setToolTipText("Sair (ESC)");
		btImp.addActionListener(this);
		btPrevimp.addActionListener(this);
		btSair.addActionListener(this);
		btImp.addKeyListener(this);
		btPrevimp.addKeyListener(this);
		btSair.addKeyListener(this);
	}

	public void setPanel(JPanelPad pn) {

		c.remove(pinCli);
		c.add(pn, BorderLayout.CENTER);
		setArea = false;
	}

	public void setPainel(JPanelPad pin) {

		pinCli = pin;
		setArea = false;
	}

	public void setAreaComp() {
		pinCli = new JPanelPad(( int ) getSize().getWidth() - 10, ( int ) getSize().getHeight() - 65);
		pnCliente.add(pinCli, BorderLayout.CENTER);
		setArea = false;
	}

	public void adic(Component comp, int iX, int iY, int iLarg, int iAlt) {

		if (setArea)
			setAreaComp();
		comp.addKeyListener(this);
		pinCli.adic(comp, iX, iY, iLarg, iAlt);
	}
	
	public JLabelPad adic(Component comp, int X, int Y, int Larg, int Alt, String label) {

		if (setArea)
			setAreaComp();
		comp.addKeyListener(this);
		
		JLabelPad lbTmp = new JLabelPad(label);
		pinCli.adic(lbTmp, X, Y - 20, Larg, 20);
		pinCli.adic(comp, X, Y, Larg, Alt);
		
		return lbTmp;

	}

	

	/**
	 * 
	 * Retorna o container do rootPane. Sobrep�s o getTela do FFilho por ele
	 * 'resetar' o Layout.
	 * 
	 * @see FFilho#getTela
	 * 
	 */
	public Container getTela() {

		return c;
	}

	public Sgestacao getSgestacao() {
		return sgestacao;
	}

	public void setSgestacao(Sgestacao sgestacao) {
		this.sgestacao = sgestacao;
	}

	public abstract void imprimir(TYPE_PRINT typeprint);

	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == btSair) {
			wait.stop();
			dispose();
		}
		else if (evt.getSource() == btImp) {
			imprimir(TYPE_PRINT.PRINT);
		}
		else if (evt.getSource() == btPrevimp) {
			// wait.start();
			// Thread th = new Thread( new Runnable() {
			// public void run() {
			imprimir(TYPE_PRINT.VIEW);
			// wait.stop();
			// }
			// } );
			// th.start();
		}
		else if (evt.getSource() == btExportXLS) {
			// wait.start();
			// Thread th = new Thread( new Runnable() {
			// public void run() {
			imprimir(TYPE_PRINT.EXPORT);
			// wait.stop();
			// }
			// } );
			// th.start();
		}
	}

	public void keyPressed(KeyEvent kevt) {

		if (kevt.getKeyCode() == KeyEvent.VK_CONTROL) {
			bCtrl = true;
		}
		else if (kevt.getKeyCode() == KeyEvent.VK_P) {
			if (bCtrl)
				btImp.doClick();
		}
		else if (kevt.getKeyCode() == KeyEvent.VK_R) {
			if (bCtrl)
				btPrevimp.doClick();
		}
		else if (kevt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			btSair.doClick();
		}
	}

	public void keyReleased(KeyEvent kevt) {

		if (kevt.getKeyCode() == KeyEvent.VK_CONTROL) {
			bCtrl = false;
		}
	}

	public void keyTyped(KeyEvent kevt) {

	}
}
