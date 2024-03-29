package com.camel.springboot.response.models;

public class OrderResponse {

	private int id;

	private int amount;

	private BookResponse bookResponse;

	private boolean processed;

	public void setProcessed() {
		processed = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BookResponse getBookResponse() {
		return bookResponse;
	}

	public void setBookResponse(BookResponse bookResponse) {
		this.bookResponse = bookResponse;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", bookResponse=" + bookResponse + ", processed=" + processed + "]";
	}

}
