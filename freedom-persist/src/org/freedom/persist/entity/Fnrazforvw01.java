package org.freedom.persist.entity;

// Generated 12/05/2014 09:11:34 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Fnrazforvw01 generated by hbm2java
 */
@Entity
@Table(name = "FNRAZFORVW01")
public class Fnrazforvw01 implements java.io.Serializable {

	private Fnrazforvw01Id id;

	public Fnrazforvw01() {
	}

	public Fnrazforvw01(Fnrazforvw01Id id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codempfr", column = @Column(name = "CODEMPFR")),
			@AttributeOverride(name = "codfilialfr", column = @Column(name = "CODFILIALFR")),
			@AttributeOverride(name = "codfor", column = @Column(name = "CODFOR")),
			@AttributeOverride(name = "razfor", column = @Column(name = "RAZFOR", length = 60)),
			@AttributeOverride(name = "codemppg", column = @Column(name = "CODEMPPG")),
			@AttributeOverride(name = "codfilialpg", column = @Column(name = "CODFILIALPG")),
			@AttributeOverride(name = "codempsl", column = @Column(name = "CODEMPSL")),
			@AttributeOverride(name = "codfilialsl", column = @Column(name = "CODFILIALSL")),
			@AttributeOverride(name = "codempvd", column = @Column(name = "CODEMPVD")),
			@AttributeOverride(name = "codfilialvd", column = @Column(name = "CODFILIALVD")),
			@AttributeOverride(name = "data", column = @Column(name = "DATA", length = 10)),
			@AttributeOverride(name = "tipo", column = @Column(name = "TIPO", length = 1)),
			@AttributeOverride(name = "tiposublanca", column = @Column(name = "TIPOSUBLANCA", length = 1)),
			@AttributeOverride(name = "doc", column = @Column(name = "DOC")),
			@AttributeOverride(name = "vlrdeb", column = @Column(name = "VLRDEB", precision = 0, scale = 5)),
			@AttributeOverride(name = "vlrcred", column = @Column(name = "VLRCRED", precision = 0, scale = 5)) })
	public Fnrazforvw01Id getId() {
		return this.id;
	}

	public void setId(Fnrazforvw01Id id) {
		this.id = id;
	}

}
