package com.app.transactionservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.transactionservice.dao.TransactionServiceDAO;

/**
 * @Purpose: Transaction service to perform various operations on transaction.
 * @author Thanh Trieu
 */
@Path("/transaction")
public class TransactionService {

	/**
	 * get transaction ids by type.
	 * 
	 * @param type
	 * @return
	 */
	@GET
	@Path("type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByType(@PathParam("type") String type) {
		TransactionServiceDAO transactionDAO = new TransactionServiceDAO();

		List<Integer> txIdLst = transactionDAO.getTransactionsByType(type);
		return Response.ok(txIdLst.toArray()).build();
	}

	/**
	 * get transaction by transaction id.
	 * 
	 * @param transactionId
	 * @return
	 */
	@GET
	@Path("id/{transactionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionById(
			@PathParam("transactionId") Integer transactionId) {
		TransactionServiceDAO transactionDAO = new TransactionServiceDAO();
		TransactionData data;
		data = transactionDAO.getTransactionsId(transactionId);
		return Response.ok(data).build();
	}

	/**
	 * get sum of transactions having same parent id.
	 * 
	 * @param parentId
	 * @return
	 */
	@GET
	@Path("sum/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSumByParentId(@PathParam("parentId") Integer parentId) {
		TransactionServiceDAO transactionDAO = new TransactionServiceDAO();
		Double sum = transactionDAO.getSumByParentId(parentId);

		return Response.ok("{sum," + sum + "}").build();
	}

	/**
	 * Save transaction.
	 * 
	 * @param jsonObj
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveTransaction(TransactionData jsonObj) {
		TransactionServiceDAO transactionDAO = new TransactionServiceDAO();
		Boolean flag = transactionDAO.saveTransaction(jsonObj);
		return Response.ok("{status:" + "ok" + "}").build();
	}
}
