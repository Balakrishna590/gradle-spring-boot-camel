package com.camel.springboot.jpa.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.camel.springboot.annotations.Consumed;

@Entity
@Table(name = "Order")
public class Order {

	@Id
	@GeneratedValue
	private int id;

	private int amount;

	@ManyToOne
	private BookEntity book;

	private boolean processed;

	@Consumed
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

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", book=" + book + ", processed=" + processed + "]";
	}

}
