package se.iuh.btl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = -6519979800001866635L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int categoryId;
	private String name;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Chocolate> listChocolate;

	public Category(int categoryId, String name, List<Chocolate> listChocolate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.listChocolate = listChocolate;
	}

	public Category(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
		return "Category [categoryId=" + categoryId + ", name=" + name + ", listChocolate=" + listChocolate + "]";
	}
}
