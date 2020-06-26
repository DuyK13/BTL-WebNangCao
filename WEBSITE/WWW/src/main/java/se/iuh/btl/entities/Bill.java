package se.iuh.btl.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class Bill implements Serializable {

	private static final long serialVersionUID = -8642096444457151151L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int billId;
	private LocalDate orderdate;
	private double total;
	private boolean billConfirm;

	public boolean isBillConfirm() {
		return billConfirm;
	}

	public void setBillConfirm(boolean billConfirm) {
		this.billConfirm = billConfirm;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userid")
	private User user;

	@OneToMany(mappedBy = "pk.bill")
	private List<BillDetail> listChiTietBill;

	public Bill(int billId, LocalDate orderdate, double total, User user, List<BillDetail> listChiTietBill) {
		super();
		this.billId = billId;
		this.orderdate = orderdate;
		this.total = total;
		this.user = user;
		this.listChiTietBill = listChiTietBill;
	}

	public Bill(int billId, LocalDate orderdate, double total, User user) {
		super();
		this.billId = billId;
		this.orderdate = orderdate;
		this.total = total;
		this.user = user;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BillDetail> getListChiTietBill() {
		return listChiTietBill;
	}

	public void setListChiTietBill(List<BillDetail> listChiTietBill) {
		this.listChiTietBill = listChiTietBill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", orderdate=" + orderdate + ", total=" + total + ", billConfirm="
				+ billConfirm + ", user=" + user + ", listChiTietBill=" + listChiTietBill + "]";
	}
}
