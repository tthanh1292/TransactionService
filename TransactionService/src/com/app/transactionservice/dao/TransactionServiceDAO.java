/**
 *
 */
package com.app.transactionservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.transactionservice.common.DBUtils;

/**
 * @author Tommy
 */

public class TransactionServiceDAO {

	public List<Integer> getTransactionsByType(String transactionType) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int tranctionId;
		List<Integer> txIdLst = new ArrayList<Integer>();
		try {
			connection = DBUtils.getConnection();
			statement = connection.createStatement();
			resultSet =
					statement
					.executeQuery("SELECT TransactionId FROM TransactionMaster WHERE type="
									+ transactionType);
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

}
