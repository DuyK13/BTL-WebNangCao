package se.iuh.btl.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import se.iuh.btl.entities.BillDetail;
import se.iuh.btl.entities.Category;

public class SaveChocolateModel {

	private static final long serialVersionUID = 2281637492511209363L;

	private int id;
	private String name;
	private int amount;
	private double cost;
	private String description;
	private String image;
	private int discount;
	
	private List<BillDetail> listChiTietBill;


	public SaveChocolateModel(int id, String name, int amount, double cost, String description, String image,
			int discount, List<BillDetail> listChiTietBill, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.description = description;
		this.image = image;
		this.discount = discount;
		this.listChiTietBill = listChiTietBill;
		this.category = category;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public List<BillDetail> getListChiTietBill() {
		return listChiTietBill;
	}

	public void setListChiTietBill(List<BillDetail> listChiTietBill) {
		this.listChiTietBill = listChiTietBill;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Chocolate [id=" + id + ", name=" + name + ", amount=" + amount + ", cost=" + cost
				+ ", description=" + description + ", image=" + image + ", discount=" + discount + ", listChiTietBill="
				+ listChiTietBill + ", category=" + category + "]";
	}
}
