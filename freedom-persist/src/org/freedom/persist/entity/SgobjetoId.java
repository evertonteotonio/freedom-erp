package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SgobjetoId generated by hbm2java
 */
@Embeddable
public class SgobjetoId implements java.io.Serializable {

	private String idobj;
	private int codemp;

	public SgobjetoId() {
	}

	public SgobjetoId(String idobj, int codemp) {
		this.idobj = idobj;
		this.codemp = codemp;
	}

	@Column(name = "IDOBJ", nullable = false, length = 30)
	public String getIdobj() {
		return this.idobj;
	}

	public void setIdobj(String idobj) {
		this.idobj = idobj;
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
		if (!(other instanceof SgobjetoId))
			return false;
		SgobjetoId castOther = (SgobjetoId) other;

		return ((this.getIdobj() == castOther.getIdobj()) || (this.getIdobj() != null
				&& castOther.getIdobj() != null && this.getIdobj().equals(
				castOther.getIdobj())))
				&& (this.getCodemp() == castOther.getCodemp());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdobj() == null ? 0 : this.getIdobj().hashCode());
		result = 37 * result + this.getCodemp();
		return result;
	}

}
