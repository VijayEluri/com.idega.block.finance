package com.idega.block.finance.hibernate.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.idega.user.data.bean.Group;

@Entity
@Cacheable
@Table(name = Period.TABLE_NAME)
public class Period implements Serializable {
	private static final long serialVersionUID = -836514393694719755L;

	public static final String TABLE_NAME = "FIN_PERIOD";

	private static final String COLUMN_ID = "FIN_PERIOD_ID";
	private static final String COLUMN_GROUP_ID = "GROUP_ID";
	private static final String COLUMN_NAME = "NAME";
	private static final String COLUMN_FROM_DATE = "FROM_DATE";
	private static final String COLUMN_TO_DATE = "TO_DATE";

	@Id
	@Column(name = COLUMN_ID)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = COLUMN_GROUP_ID)
	private Group group;

	@Column(name = COLUMN_NAME)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUMN_FROM_DATE)
	private Date fromDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = COLUMN_TO_DATE)
	private Date toDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}




}