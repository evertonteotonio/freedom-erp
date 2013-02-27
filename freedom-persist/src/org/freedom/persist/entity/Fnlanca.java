package org.freedom.persist.entity;

// Generated 30/01/2013 08:30:43 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fnlanca generated by hbm2java
 */
@Entity
@Table(name = "FNLANCA")
public class Fnlanca implements java.io.Serializable {

	private FnlancaId id;
	private Sgfilial sgfilial;
	private Fnitpagar fnitpagar;
	private Fnitreceber fnitreceber;
	private Fnsinal fnsinal;
	private Cpforneced cpforneced;
	private Vdcliente vdcliente;
	private Fnplanejamento fnplanejamento;
	private Fnpagtocomi fnpagtocomi;
	private Vdcomissao vdcomissao;
	private Date dtcomplanca;
	private Date datalanca;
	private String doclanca;
	private String histblanca;
	private String histlanca;
	private Character transflanca;
	private String statuslanca;
	private Date dtprevlanca;
	private Date dtprevsublanca;
	private BigDecimal vlrlanca;
	private Character flag;
	private char tipolanca;
	private char pdvitrec;
	private char emmanut;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set<Fnsublanca> fnsublancas = new HashSet<Fnsublanca>(0);

	public Fnlanca() {
	}

	public Fnlanca(FnlancaId id, Sgfilial sgfilial,
			Fnplanejamento fnplanejamento, Vdcomissao vdcomissao,
			Date dtcomplanca, Date datalanca, String histblanca,
			char tipolanca, char pdvitrec, char emmanut, Date dtins, Date hins,
			String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.fnplanejamento = fnplanejamento;
		this.vdcomissao = vdcomissao;
		this.dtcomplanca = dtcomplanca;
		this.datalanca = datalanca;
		this.histblanca = histblanca;
		this.tipolanca = tipolanca;
		this.pdvitrec = pdvitrec;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Fnlanca(FnlancaId id, Sgfilial sgfilial, Fnitpagar fnitpagar,
			Fnitreceber fnitreceber, Fnsinal fnsinal, Cpforneced cpforneced,
			Vdcliente vdcliente, Fnplanejamento fnplanejamento,
			Fnpagtocomi fnpagtocomi, Vdcomissao vdcomissao, Date dtcomplanca,
			Date datalanca, String doclanca, String histblanca,
			String histlanca, Character transflanca, String statuslanca,
			Date dtprevlanca, Date dtprevsublanca, BigDecimal vlrlanca,
			Character flag, char tipolanca, char pdvitrec, char emmanut,
			Date dtins, Date hins, String idusuins, Date dtalt, Date halt,
			String idusualt, Set<Fnsublanca> fnsublancas) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.fnitpagar = fnitpagar;
		this.fnitreceber = fnitreceber;
		this.fnsinal = fnsinal;
		this.cpforneced = cpforneced;
		this.vdcliente = vdcliente;
		this.fnplanejamento = fnplanejamento;
		this.fnpagtocomi = fnpagtocomi;
		this.vdcomissao = vdcomissao;
		this.dtcomplanca = dtcomplanca;
		this.datalanca = datalanca;
		this.doclanca = doclanca;
		this.histblanca = histblanca;
		this.histlanca = histlanca;
		this.transflanca = transflanca;
		this.statuslanca = statuslanca;
		this.dtprevlanca = dtprevlanca;
		this.dtprevsublanca = dtprevsublanca;
		this.vlrlanca = vlrlanca;
		this.flag = flag;
		this.tipolanca = tipolanca;
		this.pdvitrec = pdvitrec;
		this.emmanut = emmanut;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.fnsublancas = fnsublancas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codlanca", column = @Column(name = "CODLANCA", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public FnlancaId getId() {
		return this.id;
	}

	public void setId(FnlancaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Sgfilial getSgfilial() {
		return this.sgfilial;
	}

	public void setSgfilial(Sgfilial sgfilial) {
		this.sgfilial = sgfilial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPAG", referencedColumnName = "CODPAG"),
			@JoinColumn(name = "NPARCPAG", referencedColumnName = "NPARCPAG"),
			@JoinColumn(name = "CODFILIALPG", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPPG", referencedColumnName = "CODEMP") })
	public Fnitpagar getFnitpagar() {
		return this.fnitpagar;
	}

	public void setFnitpagar(Fnitpagar fnitpagar) {
		this.fnitpagar = fnitpagar;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODREC", referencedColumnName = "CODREC"),
			@JoinColumn(name = "NPARCITREC", referencedColumnName = "NPARCITREC"),
			@JoinColumn(name = "CODFILIALRC", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPRC", referencedColumnName = "CODEMP") })
	public Fnitreceber getFnitreceber() {
		return this.fnitreceber;
	}

	public void setFnitreceber(Fnitreceber fnitreceber) {
		this.fnitreceber = fnitreceber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODSINAL", referencedColumnName = "CODSINAL"),
			@JoinColumn(name = "CODEMPSN", referencedColumnName = "CODEMP"),
			@JoinColumn(name = "CODFILIALSN", referencedColumnName = "CODFILIAL") })
	public Fnsinal getFnsinal() {
		return this.fnsinal;
	}

	public void setFnsinal(Fnsinal fnsinal) {
		this.fnsinal = fnsinal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODFOR", referencedColumnName = "CODFOR"),
			@JoinColumn(name = "CODFILIALFR", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPFR", referencedColumnName = "CODEMP") })
	public Cpforneced getCpforneced() {
		return this.cpforneced;
	}

	public void setCpforneced(Cpforneced cpforneced) {
		this.cpforneced = cpforneced;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI"),
			@JoinColumn(name = "CODFILIALCL", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCL", referencedColumnName = "CODEMP") })
	public Vdcliente getVdcliente() {
		return this.vdcliente;
	}

	public void setVdcliente(Vdcliente vdcliente) {
		this.vdcliente = vdcliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPLAN", referencedColumnName = "CODPLAN", nullable = false),
			@JoinColumn(name = "CODFILIALPN", referencedColumnName = "CODFILIAL", nullable = false),
			@JoinColumn(name = "CODEMPPN", referencedColumnName = "CODEMP", nullable = false) })
	public Fnplanejamento getFnplanejamento() {
		return this.fnplanejamento;
	}

	public void setFnplanejamento(Fnplanejamento fnplanejamento) {
		this.fnplanejamento = fnplanejamento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODPCOMI", referencedColumnName = "CODPCOMI"),
			@JoinColumn(name = "CODFILIALCI", referencedColumnName = "CODFILIAL"),
			@JoinColumn(name = "CODEMPCI", referencedColumnName = "CODEMP") })
	public Fnpagtocomi getFnpagtocomi() {
		return this.fnpagtocomi;
	}

	public void setFnpagtocomi(Fnpagtocomi fnpagtocomi) {
		this.fnpagtocomi = fnpagtocomi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODCOMI", referencedColumnName = "CODCOMI", insertable = false, updatable = false),
			@JoinColumn(name = "CODFILIAL", referencedColumnName = "CODFILIAL", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", nullable = false, insertable = false, updatable = false) })
	public Vdcomissao getVdcomissao() {
		return this.vdcomissao;
	}

	public void setVdcomissao(Vdcomissao vdcomissao) {
		this.vdcomissao = vdcomissao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTCOMPLANCA", nullable = false, length = 10)
	public Date getDtcomplanca() {
		return this.dtcomplanca;
	}

	public void setDtcomplanca(Date dtcomplanca) {
		this.dtcomplanca = dtcomplanca;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATALANCA", nullable = false, length = 10)
	public Date getDatalanca() {
		return this.datalanca;
	}

	public void setDatalanca(Date datalanca) {
		this.datalanca = datalanca;
	}

	@Column(name = "DOCLANCA", length = 15)
	public String getDoclanca() {
		return this.doclanca;
	}

	public void setDoclanca(String doclanca) {
		this.doclanca = doclanca;
	}

	@Column(name = "HISTBLANCA", nullable = false, length = 250)
	public String getHistblanca() {
		return this.histblanca;
	}

	public void setHistblanca(String histblanca) {
		this.histblanca = histblanca;
	}

	@Column(name = "HISTLANCA", length = 10000)
	public String getHistlanca() {
		return this.histlanca;
	}

	public void setHistlanca(String histlanca) {
		this.histlanca = histlanca;
	}

	@Column(name = "TRANSFLANCA", length = 1)
	public Character getTransflanca() {
		return this.transflanca;
	}

	public void setTransflanca(Character transflanca) {
		this.transflanca = transflanca;
	}

	@Column(name = "STATUSLANCA", length = 2)
	public String getStatuslanca() {
		return this.statuslanca;
	}

	public void setStatuslanca(String statuslanca) {
		this.statuslanca = statuslanca;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTPREVLANCA", length = 10)
	public Date getDtprevlanca() {
		return this.dtprevlanca;
	}

	public void setDtprevlanca(Date dtprevlanca) {
		this.dtprevlanca = dtprevlanca;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTPREVSUBLANCA", length = 10)
	public Date getDtprevsublanca() {
		return this.dtprevsublanca;
	}

	public void setDtprevsublanca(Date dtprevsublanca) {
		this.dtprevsublanca = dtprevsublanca;
	}

	@Column(name = "VLRLANCA", precision = 15, scale = 5)
	public BigDecimal getVlrlanca() {
		return this.vlrlanca;
	}

	public void setVlrlanca(BigDecimal vlrlanca) {
		this.vlrlanca = vlrlanca;
	}

	@Column(name = "FLAG", length = 1)
	public Character getFlag() {
		return this.flag;
	}

	public void setFlag(Character flag) {
		this.flag = flag;
	}

	@Column(name = "TIPOLANCA", nullable = false, length = 1)
	public char getTipolanca() {
		return this.tipolanca;
	}

	public void setTipolanca(char tipolanca) {
		this.tipolanca = tipolanca;
	}

	@Column(name = "PDVITREC", nullable = false, length = 1)
	public char getPdvitrec() {
		return this.pdvitrec;
	}

	public void setPdvitrec(char pdvitrec) {
		this.pdvitrec = pdvitrec;
	}

	@Column(name = "EMMANUT", nullable = false, length = 1)
	public char getEmmanut() {
		return this.emmanut;
	}

	public void setEmmanut(char emmanut) {
		this.emmanut = emmanut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTINS", nullable = false, length = 10)
	public Date getDtins() {
		return this.dtins;
	}

	public void setDtins(Date dtins) {
		this.dtins = dtins;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HINS", nullable = false, length = 8)
	public Date getHins() {
		return this.hins;
	}

	public void setHins(Date hins) {
		this.hins = hins;
	}

	@Column(name = "IDUSUINS", nullable = false, length = 8)
	public String getIdusuins() {
		return this.idusuins;
	}

	public void setIdusuins(String idusuins) {
		this.idusuins = idusuins;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTALT", length = 10)
	public Date getDtalt() {
		return this.dtalt;
	}

	public void setDtalt(Date dtalt) {
		this.dtalt = dtalt;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HALT", length = 8)
	public Date getHalt() {
		return this.halt;
	}

	public void setHalt(Date halt) {
		this.halt = halt;
	}

	@Column(name = "IDUSUALT", length = 8)
	public String getIdusualt() {
		return this.idusualt;
	}

	public void setIdusualt(String idusualt) {
		this.idusualt = idusualt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fnlanca")
	public Set<Fnsublanca> getFnsublancas() {
		return this.fnsublancas;
	}

	public void setFnsublancas(Set<Fnsublanca> fnsublancas) {
		this.fnsublancas = fnsublancas;
	}

}