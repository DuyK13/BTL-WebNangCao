package se.iuh.btl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{
	
	private static final long serialVersionUID = -6519979800001866635L;
	@Id
	private int id;
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Chocolate> listChocolate;

	public Category(int id, String name, List<Chocolate> listChocolate) {
		super();
		this.id = id;
		this.name = name;
		this.listChocolate = listChocolate;
	}

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chocolate> getListChocolate() {
		return listChocolate;
	}

	public void setListChocolate(List<Chocolate> listChocolate) {
		this.listChocolate = listChocolate;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", listChocolate=" + listChocolate + "]";
	}
}
