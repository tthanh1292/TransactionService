package com.app.transactionservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.app.transactionservice.dao.TransactionServiceDAO;

// **********
// Implementation of Service which will be exposed to clients
@Path("/transaction/service")
public class TransactionService {

	// GetTransaction
	@GET
	@Path("/getTransactionByType")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByType(String transactionType) {
		TransactionData data = new TransactionData();
		TransactionServiceDAO transactionDAO = new TransactionServiceDAO();

		List<Integer> txIdLst =
				transactionDAO.getTransactionsByType(transactionType);
		data.setType(transactionType);
		return Response.ok(txIdLst.toArray()).build();
	}

	// SaveTransaction

	// PUT

	// POST

}
