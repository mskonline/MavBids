package org.web.beans;

import java.sql.Date;

public class Advertisement {

	private String itemName;
	private String adDuration;
	private double currentBidPrice;
	private double startingBidPrice;
	private Date expiryDate;
	private String description;
	private String status;
	// Image Object
	private int sellerId;
	private String auctionType;
	private Category category;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getAdDuration() {
		return adDuration;
	}
	public void setAdDuration(String adDuration) {
		this.adDuration = adDuration;
	}
	public double getCurrentBidPrice() {
		return currentBidPrice;
	}
	public void setCurrentBidPrice(double currentBidPrice) {
		this.currentBidPrice = currentBidPrice;
	}
	public double getStartingBidPrice() {
		return startingBidPrice;
	}
	public void setStartingBidPrice(double startingBidPrice) {
		this.startingBidPrice = startingBidPrice;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getAuctionType() {
		return auctionType;
	}
	public void setAuctionType(String auctionType) {
		this.auctionType = auctionType;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
