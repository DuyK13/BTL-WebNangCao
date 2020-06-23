package se.iuh.btl.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	
	private static final long serialVersionUID = -2324727536666057968L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String userid;
	private String name;
	@Embedded
	private Address Addresss;
	private String PhoneNumber;

	/**
	 * 1: male
	 * 2: female
	 */
	private int gender;
	private String username;
	private String password;
	/**
	 * 0: admin
	 * 1: staff
	 * 2: customer
	 */
	private int status;
	private String email;

	@OneToMany(mappedBy = "user")
	private List<Bill> listBill;

	public User(String userid, String name, Address addresss, String phoneNumber, int gender, String username,
			String password, int status, String email, List<Bill> listBill) {
		super();
		this.userid = userid;
		this.name = name;
		Addresss = addresss;
		PhoneNumber = phoneNumber;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.status = status;
		this.email = email;
		this.listBill = listBill;
	}

	public User(String userid, String name, Address addresss, String phoneNumber, int gender, String username,
			String password, int status, String email) {
		super();
		this.userid = userid;
		this.name = name;
		Addresss = addresss;
		PhoneNumber = phoneNumber;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.status = status;
		this.email = email;
	}

	public User() {
		super();
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddresss() {
		return Addresss;
	}

	public void setAddresss(Address addresss) {
		Addresss = addresss;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Bill> getListBill() {
		return listBill;
	}

	public void setListBill(List<Bill> listBill) {
		this.listBill = listBill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", Addresss=" + Addresss + ", PhoneNumber=" + PhoneNumber
				+ ", gender=" + gender + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", email=" + email + ", listBill=" + listBill + "]";
	}
}
