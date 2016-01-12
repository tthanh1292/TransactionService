/**
 *
 */
package com.app.transactionservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.transactionservice.TransactionData;
import com.app.transactionservice.common.DBUtils;

/**
 * @author Thanh Trieu
 */

public class TransactionServiceDAO {

	/**
	 * This method queries hsql db TransactionMaster Table and get the 
	 * transaction ids by type
	 * @param transactionType
	 * @return
	 */
	public List<Integer> getTransactionsByType(String transactionType) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int tranctionId;
		List<Integer> txIdLst = new ArrayList<Integer>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet =statement.executeQuery("SELECT TransactionID FROM TransactionMaster tm WHERE tm.Type='"+transactionType+"'");
			while (resultSet.next()) {
				tranctionId = Integer.parseInt(resultSet.getString("TransactionId"));
				txIdLst.add(tranctionId);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return txIdLst;
	}

	public TransactionData getTransactionsId(Integer transactionId) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		TransactionData data = new  TransactionData();
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet =statement.executeQuery("SELECT * FROM TransactionMaster tm WHERE tm.TransactionID="+transactionId);
			while (resultSet.next()) {
				data.setAmount(Double.parseDouble(resultSet.getString("Amount")));
				data.setType(resultSet.getString("Type"));
				data.setPatent_id(Double.parseDouble((resultSet.getString("PatentID"))));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public Double getSumByParentId(Integer parentId) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		Double sum = null;
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet =statement.executeQuery("SELECT SUM(Amount) totalAmount FROM TransactionMaster tm WHERE tm.PatentID="+parentId);
			while (resultSet.next()) {
				sum= Double.parseDouble((resultSet.getString("totalAmount")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sum;
	}

	public Boolean saveTransaction(TransactionData jsonObj) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		Boolean flag= false;
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO TransactionMaster VALUES("+jsonObj.getTransactionId()+","+jsonObj.getPatent_id()+","+jsonObj.getType()+","+jsonObj.getAmount()+")");
			flag = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

}
