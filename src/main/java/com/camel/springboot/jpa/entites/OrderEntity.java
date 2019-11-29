package com.camel.springboot.jpa.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.camel.springboot.annotations.Consumed;

@Entity
@Table(name = "ORDERS")
@NamedQuery(name ="new-orders", query="SELECT OrderEntity FROM OrderEntity OE WHERE OE.processed = false")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="AMOUNT")
	private int amount;

	@ManyToOne
	@JoinColumn(name="BOOK_ENTITY_ID")
	private BookEntity bookEntity;

	@Column(name="PROCESSED", columnDefinition="NUMBER(1)")
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

	public BookEntity getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", bookEntity=" + bookEntity + ", processed=" + processed
				+ "]";
	}

}
