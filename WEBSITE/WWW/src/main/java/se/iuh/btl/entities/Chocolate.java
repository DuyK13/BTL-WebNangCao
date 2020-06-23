package se.iuh.btl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Chocolate")
public class Chocolate implements Serializable{

	private static final long serialVersionUID = 2281637492511209363L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int chocolateId;
	private String name;
	private int amount;
	private double cost;
	private String description;
	@ElementCollection()
	private List<String> listImage;
	private int discount;
	
	@OneToMany(mappedBy = "pk.chocolate")
	private List<BillDetail> listChiTietBill;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	public Chocolate(int chocolateId, String name, int amount, double cost, String description, List<String> listImage,
			int discount, List<BillDetail> listChiTietBill, Category category) {
		super();
		this.chocolateId = chocolateId;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.description = description;
		this.listImage = listImage;
		this.discount = discount;
		this.listChiTietBill = listChiTietBill;
		this.category = category;
	}

	public Chocolate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chocolate(int chocolateId, String name, int amount, double cost, String description, List<String> listImage,
			int discount) {
		super();
		this.chocolateId = chocolateId;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
		this.description = description;
		this.listImage = listImage;
		this.discount = discount;
	}

	public int getChocolateId() {
		return chocolateId;
	}

	public void setChocolateId(int chocolateId) {
		this.chocolateId = chocolateId;
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

	public List<String> getListImage() {
		return listImage;
	}

	public void setListImage(List<String> listImage) {
		this.listImage = listImage;
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
		return "Chocolate [chocolateId=" + chocolateId + ", name=" + name + ", amount=" + amount + ", cost=" + cost + ", description="
				+ description + ", listImage=" + listImage + ", discount=" + discount + ", listChiTietBill="
				+ listChiTietBill + ", category=" + category + "]";
	}
}
