package se.iuh.btl.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = -6519979800001866635L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public int getId() {
		return id;
	}

	public void setId(int id) {
=======
	public int getCategoryId() {
		return id;
	}

	public void setCategoryId(int id) {
>>>>>>> origin/master
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}
