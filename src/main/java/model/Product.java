package model;

public class Product {

    private int productId;
    private String location;
    private int price;
    private String description;
    private int status;
    private String image;
    private String name;
    private int type1;
    private int type2;
    private int type3;
    
    // getter setter
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getType1() {
        return type1;
    }
    public void setType1(int type1) {
        this.type1 = type1;
    }
    public int getType2() {
        return type2;
    }
    public void setType2(int type2) {
        this.type2 = type2;
    }
    public int getType3() {
        return type3;
    }
    public void setType3(int type3) {
        this.type3 = type3;
    }
    //constructor
    public Product() {
        
    }
    
    public Product(int productId, String location, int price, String description, int status, String image, String name,
            int type1, int type2, int type3) {
        super();
        this.productId = productId;
        this.location = location;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
    }
    
    
    
    public Product(String location, int price, String description, int status, String image, String name, int type1, int type2, int type3) {
        super();
        this.location = location;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
    }
    
    //toString
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", location=" + location + ", price=" + price + ", description="
				+ description + ", status=" + status + ", image=" + image + ", name=" + name + ", type1=" + type1
				+ ", type2=" + type2 + ", type3=" + type3 + "]";
	}
}
