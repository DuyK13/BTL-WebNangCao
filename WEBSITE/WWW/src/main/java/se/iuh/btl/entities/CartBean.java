package se.iuh.btl.entities;

import java.util.ArrayList;

public class CartBean {
	ArrayList<CartChocolate> cartItems = new ArrayList<CartChocolate>();
	private double total;
	public int getItemCount()
	{
		return cartItems.size();
	}

	protected void FinalTotal()
	{
		double t = 0;
		for(CartChocolate c: cartItems)
			total+=c.getTotal();
		setTotal(t);

	}
	public void deleteCartItem(int strIndex)
	{
		try {
			cartItems.remove(strIndex-1);
			FinalTotal();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void updateCartItem(CartChocolate cartChocolate)
	{
		int i=0;
		for (CartChocolate c: cartItems) {
			if(c.getId()==cartChocolate.getId())
			{
				cartItems.set(i, cartChocolate);
			}
			else
				i++;
				
		}
	}
	public void addCartItem(CartChocolate cartChocolate)
	{
		boolean flag= true;
		for(CartChocolate c:cartItems)
		{
			if(c.getId() == cartChocolate.getId())
			{
				c.setQuantity(c.getQuantity()+cartChocolate.getQuantity());
				flag=false;
				break;
			}
		}
		if(flag==true)
			cartItems.add(cartChocolate);
		FinalTotal();
	}
	public CartChocolate getCartItem(int index)
	{
		CartChocolate cart=null;
		if(cartItems.size()>index)
			cart = cartItems.get(index);
		return cart;
	}
	public ArrayList<CartChocolate> getAll()
	{
		return cartItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<CartChocolate> getCartItems() {
		return cartItems;
	}
	public void setCartItems(ArrayList<CartChocolate> cartItems) {
		this.cartItems = cartItems;
	}
}
