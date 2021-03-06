package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TksitcampId generated by hbm2java
 */
@Embeddable
public class TksitcampId implements java.io.Serializable {

	private String codcamp;
	private int seqsitcamp;
	private char tipocto;
	private short codfilial;
	private int codemp;

	public TksitcampId() {
	}

	public TksitcampId(String codcamp, int seqsitcamp, char tipocto,
			short codfilial, int codemp) {
		this.codcamp = codcamp;
		this.seqsitcamp = seqsitcamp;
		this.tipocto = tipocto;
		this.codfilial = codfilial;
		this.codemp = codemp;
	}

	@Column(name = "CODCAMP", nullable = false, length = 13)
	public String getCodcamp() {
		return this.codcamp;
	}

	public void setCodcamp(String codcamp) {
		this.codcamp = codcamp;
	}

	@Column(name = "SEQSITCAMP", nullable = false)
	public int getSeqsitcamp() {
		return this.seqsitcamp;
	}

	public void setSeqsitcamp(int seqsitcamp) {
		this.seqsitcamp = seqsitcamp;
	}

	@Column(name = "TIPOCTO", nullable = false, length = 1)
	public char getTipocto() {
		return this.tipocto;
	}

	public void setTipocto(char tipocto) {
		this.tipocto = tipocto;
	}

	@Column(name = "CODFILIAL", nullable = false)
	public short getCodfilial() {
		return this.codfilial;
	}

	public void setCodfilial(short codfilial) {
		this.codfilial = codfilial;
	}

	@Column(name = "CODEMP", nullable = false)
	public int getCodemp() {
		return this.codemp;
	}

	public void setCodemp(int codemp) {
		this.codemp = codemp;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TksitcampId))
			return false;
		TksitcampId castOther = (TksitcampId) other;

		return ((this.getCodcamp() == castOther.getCodcamp()) || (this
				.getCodcamp() != null && castOther.getCodcamp() != null && this
				.getCodcamp().equals(castOther.getCodcamp())))
				&& (this.getSeqsitcamp() == castOther.getSeqsitcamp())
				&& (this.getTipocto() == castOther.getTipocto())
				&& (this.getCodfilial() == castOther.getCodfilial())
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodcamp() == null ? 0 : this.getCodcamp().hashCode());
		result = 37 * result + this.getSeqsitcamp();
		result = 37 * result + this.getTipocto();
		result = 37 * result + this.getCodfilial();
		result = 37 * result + this.getCodemp();
		return result;
	}

}
