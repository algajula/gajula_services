package com.gajula.faqs;

import java.util.Objects;

public class Product{
    public int id;
	public String name;
	public int qty;
	public float price;
   
    public Product(int id, String name, float price, int qty) {
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;
		this.qty = qty;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int Qty) {
		this.qty = Qty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return getId() == product.getId() && getQty() == product.getQty() && Float.compare(product.getPrice(), getPrice()) == 0 && Objects.equals(getName(), product.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getQty(), getPrice());
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", qty=" + qty +
				", price=" + price +
				'}';
	}
}