package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.pharmacyapp.model.Purchase;
import com.chainsys.pharmacyapp.service.purchaseService;

@WebServlet("/AddPurchaseDetails")

public class AddPurchaseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  int  productId=Integer.parseInt(request.getParameter("productId"));
				int companyId=Integer.parseInt(request.getParameter("companyId"));
				int purchaseQuantity=Integer.parseInt(request.getParameter("purchaseQuantity"));
				int Amount=Integer.parseInt(request.getParameter("Amount"));
			    purchaseService p=new purchaseService();
				//PurchaseImplementation p=new PurchaseImplementation();
				Purchase Pu=new Purchase();
				Pu.setProductId(productId);
				Pu.setCompanyId(companyId);
				Pu.setPurchaseQuantity(purchaseQuantity);
				Pu.setAmount(Amount);
				try {
					int n=p.addPurchaseDetails(Pu);
					System.out.println(n);
					if(n==1)
					{

						PrintWriter out = response.getWriter();
				   		 out.println("\n");
				   			out.println("\n<h1>PurchaseDetails Added</h1>");
					}
					else
					{

						PrintWriter out = response.getWriter();
				   		 out.println("\n");
				   			out.println("\n<h1>PurchaseDetails already exist</h1>");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	

}
