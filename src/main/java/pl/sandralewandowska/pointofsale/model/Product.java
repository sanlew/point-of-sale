package pl.sandralewandowska.pointofsale.model;

import java.math.BigDecimal;

import pl.sandralewandowska.pointofsale.tool.CalculatingAmount;

public class Product {
	
	private Long id;
	private String barCode;
	private String name;
	private BigDecimal price;
	
	public Product(Long id, String barCode, String name, BigDecimal price) {
		this.id = id;
		this.barCode = barCode;
		this.name = name;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
    @Override    
    public int hashCode() {        
        int result = (int) (id ^ (id >>> 32));        
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);        
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;    
    }    
	 
    @Override    
    public boolean equals(Object o) {        
        if (this == o) return true;        
        if (o == null || getClass() != o.getClass()) return false;        
        Product product = (Product) o;        
        if (id != product.id) return false;        
        if (barCode != null ? !barCode.equals(product.barCode) : product.barCode != null) return false;        
        if (name != null ? !name.equals(product.name) : product.name != null) return false;        
        return price != null ? price.equals(product.price) : product.price == null;    
    }    
	
	@Override
	public String toString() {
		return "Product [id=" + this.id + ", barCode=" + this.barCode
                + ", name=" + this.name + ", price=" + CalculatingAmount.roundPrice(this.price) + "]";
	}
	
	public String toMessageString(){
		return this.name + " " + CalculatingAmount.roundPrice(this.price);
	}
	
}
