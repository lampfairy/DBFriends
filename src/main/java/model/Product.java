package model;

public class Product {

    private int productId;
    private String location;
    private int price;
    private String description;
    private int status;
    private String image;
    private String name;
    private int type;
    
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
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    
    //constructor
    public Product(int productId, String location, int price, String description, int status, String image, String name,
            int type) {
        super();
        this.productId = productId;
        this.location = location;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
        this.name = name;
        this.type = type;
    }
    
    
    
    public Product(String location, int price, String description, int status, String image, String name, int type) {
        super();
        this.location = location;
        this.price = price;
        this.description = description;
        this.status = status;
        this.image = image;
        this.name = name;
        this.type = type;
    }
    //toString
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", location=" + location + ", price=" + price + ", description="
                + description + ", status=" + status + ", image=" + image + ", name=" + name + ", type=" + type + "]";
    }
    

    
    
    
}
