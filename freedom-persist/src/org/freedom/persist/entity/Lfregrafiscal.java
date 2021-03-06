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
 * Lfregrafiscal generated by hbm2java
 */
@Entity
@Table(name = "LFREGRAFISCAL")
public class Lfregrafiscal implements java.io.Serializable {

	private LfregrafiscalId id;
	private Sgfilial sgfilial;
	private String descregra;
	private Date dtins;
	private Date hins;
	private String idusuins;
	private Date dtalt;
	private Date halt;
	private String idusualt;
	private Set lfitclfiscals = new HashSet(0);
	private Set lfitregrafiscals = new HashSet(0);
	private Set lfclfiscals = new HashSet(0);

	public Lfregrafiscal() {
	}

	public Lfregrafiscal(LfregrafiscalId id, Sgfilial sgfilial, Date dtins,
			Date hins, String idusuins) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
	}

	public Lfregrafiscal(LfregrafiscalId id, Sgfilial sgfilial,
			String descregra, Date dtins, Date hins, String idusuins,
			Date dtalt, Date halt, String idusualt, Set lfitclfiscals,
			Set lfitregrafiscals, Set lfclfiscals) {
		this.id = id;
		this.sgfilial = sgfilial;
		this.descregra = descregra;
		this.dtins = dtins;
		this.hins = hins;
		this.idusuins = idusuins;
		this.dtalt = dtalt;
		this.halt = halt;
		this.idusualt = idusualt;
		this.lfitclfiscals = lfitclfiscals;
		this.lfitregrafiscals = lfitregrafiscals;
		this.lfclfiscals = lfclfiscals;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codregra", column = @Column(name = "CODREGRA", nullable = false, length = 4)),
			@AttributeOverride(name = "codfilial", column = @Column(name = "CODFILIAL", nullable = false)),
			@AttributeOverride(name = "codemp", column = @Column(name = "CODEMP", nullable = false)) })
	public LfregrafiscalId getId() {
		return this.id;
	}

	public void setId(LfregrafiscalId id) {
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

	@Column(name = "DESCREGRA", length = 50)
	public String getDescregra() {
		return this.descregra;
	}

	public void setDescregra(String descregra) {
		this.descregra = descregra;
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

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "lfregrafiscal")
	public Set getLfitclfiscals() {
		return this.lfitclfiscals;
	}

	public void setLfitclfiscals(Set lfitclfiscals) {
		this.lfitclfiscals = lfitclfiscals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lfregrafiscal")
	public Set getLfitregrafiscals() {
		return this.lfitregrafiscals;
	}

	public void setLfitregrafiscals(Set lfitregrafiscals) {
		this.lfitregrafiscals = lfitregrafiscals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lfregrafiscal")
	public Set getLfclfiscals() {
		return this.lfclfiscals;
	}

	public void setLfclfiscals(Set lfclfiscals) {
		this.lfclfiscals = lfclfiscals;
	}
*/
}
