package model;


public class Bookmark {
	private String userId;
	private int productId;
	private String name;

	public Bookmark(String userId, int productId, String name) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.name = name;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bookmark [userId=" + userId + ", productId=" + productId + ", name=" + name + "]";
    }
}