package se.iuh.btl.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.Transient;

@Entity
//@AssociationOverrides({
//	@AssociationOverride(name = "pk.bill", joinColumns = @JoinColumn(referencedColumnName = "bill")),
//	@AssociationOverride(name = "pk.chocolate", joinColumns = @JoinColumn(referencedColumnName = "chocolate"))
//})
public class BillDetail implements Serializable{

	private static final long serialVersionUID = 1569042832156018465L;

	@EmbeddedId
	private BillDetail_PK id;

	@MapsId("id")
	private Bill bill;

	@MapsId("id")
	private Chocolate chocolate;
	private int quantity;

	public BillDetail(BillDetail_PK id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public BillDetail() {
		super();
	}

	public BillDetail_PK getId() {
		return id;
	}

	public void setId(BillDetail_PK id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Transient
	public Bill getBill() {
		return getId().getBill();
	}

	public void setBill(Bill bill) {
		getId().setBill(bill);
	}

	@Transient
	public Chocolate getChocolate() {
		return getId().getChocolate();
	}

	public void setBill(Chocolate chocolate) {
		getId().setChocolate(chocolate);
	}

	@Override
	public String toString() {
		return "BillDetail [id=" + id + ", quantity=" + quantity + "]";
	}
}
