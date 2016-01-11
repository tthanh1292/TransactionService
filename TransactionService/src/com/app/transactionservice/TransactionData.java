/**
 *
 */
package com.app.transactionservice;

/**
 * @author Thanh Trieu
 */
public class TransactionData {

	private double	amount;
	private String	type;
	private long		patent_id;

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

	public long getPatent_id() {
		return this.patent_id;
	}

	public void setPatent_id(long patent_id) {
		this.patent_id = patent_id;
	}

	@Override
	public String toString() {
		return "TransactionData {amount=" + this.amount + ", type=" + this.type
				+ ", patent_id=" + this.patent_id + "}";
	}

}
