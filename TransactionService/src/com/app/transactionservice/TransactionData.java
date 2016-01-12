/**
 *
 */
package com.app.transactionservice;

/**
 * @author Thanh Trieu
 * 
 */
public class TransactionData {

	private int transactionId;
	private double	amount;
	private String	type;
	private double patent_id;

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPatent_id() {
		return this.patent_id;
	}

	public void setPatent_id(double patent_id) {
		this.patent_id = patent_id;
	}
	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "TransactionData {amount=" + this.amount + ", type=" + this.type
				+ ", patent_id=" + this.patent_id + "}";
	}

}
