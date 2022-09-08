package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "deptid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;

	@Column(name = "deptname")
	private String deptname;

	public int getDeptid() {
		return deptid;
	}

	public Department() {
		super();
	}

	public Department(String deptname) {
		super();
		this.deptname = deptname;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
