package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

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
 * Ppfase generated by hbm2java
 */
@Entity
@Table(name = "PPFASE")
public class Ppfase implements java.io.Serializable {

	private PpfaseId id;
	private Sgfilial sgfilial;
	private String descfase;
	private String tipofase;
	private Character externafase;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set ppopsubprods = new HashSet(0);
	private Set ppopfases = new HashSet(0);
	private Set ppestrufases = new HashSet(0);
	private Set ppitops = new HashSet(0);

	public Ppfase() {
	}

	public Ppfase(PpfaseId id, Sgfilial sgfilial, String descfase,
			String tipofase, Date dtins, Date hins, String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.descfase = descfase;
		this.tipofase = tipofase;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Ppfase(PpfaseId id, Sgfilial sgfilial, String descfase,
			String tipofase, Character externafase, Date dtins, Date hins,
			String idusuins, Date dtalt, Date halt, String idusualt,
			Set ppopsubprods, Set ppopfases, Set ppestrufases, Set ppitops) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.descfase = descfase;
		this.tipofase = tipofase;
		this.externafase = externafase;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.ppopsubprods = ppopsubprods;
		this.ppopfases = ppopfases;
		this.ppestrufases = ppestrufases;
		this.ppitops = ppitops;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codfase", column = @Column(name = "CODFASE", nullable = false)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public PpfaseId getId() {
		return this.id;
	}

	public void setId(PpfaseId id) {
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

	@Column(name = "DESCFASE", nullable = false, length = 50)
	public String getDescfase() {
		return this.descfase;
	}

	public void setDescfase(String descfase) {
		this.descfase = descfase;
	}

	@Column(name = "TIPOFASE", nullable = false, length = 2)
	public String getTipofase() {
		return this.tipofase;
	}

	public void setTipofase(String tipofase) {
		this.tipofase = tipofase;
	}

	@Column(name = "EXTERNAFASE", length = 1)
	public Character getExternafase() {
		return this.externafase;
	}

	public void setExternafase(Character externafase) {
		this.externafase = externafase;
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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppfase")
	public Set getPpopsubprods() {
		return this.ppopsubprods;
	}

	public void setPpopsubprods(Set ppopsubprods) {
		this.ppopsubprods = ppopsubprods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppfase")
	public Set getPpopfases() {
		return this.ppopfases;
	}

	public void setPpopfases(Set ppopfases) {
		this.ppopfases = ppopfases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppfase")
	public Set getPpestrufases() {
		return this.ppestrufases;
	}

	public void setPpestrufases(Set ppestrufases) {
		this.ppestrufases = ppestrufases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ppfase")
	public Set getPpitops() {
		return this.ppitops;
	}

	public void setPpitops(Set ppitops) {
		this.ppitops = ppitops;
	}
*/
}
