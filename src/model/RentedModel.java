package model;

public class RentedModel {

	private String model;
	private int amount=0;
	private int rentCount=0;
	public RentedModel(String model, int amount, int rentCount) {
		super();
		this.model = model;
		this.amount = amount;
		this.rentCount = rentCount;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getRentCount() {
		return rentCount;
	}
	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}
	public RentedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
}
