package model;


public class Bookmark {
	private String userId;
	private int productId;

	public Bookmark(String userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Bookmark [userId=" + userId + ", productId=" + productId + "]";
	}
}
