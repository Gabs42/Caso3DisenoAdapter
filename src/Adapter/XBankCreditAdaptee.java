/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import API.XBankCreditAPI;
import Request.BankCreditRequest;
import Request.XBankCreditRequest;
import Response.BankCreditResponse;
import Response.XBankCreditResponse;

/**
 *
 * @author Gabriel
 */
public class XBankCreditAdaptee implements IBankAdapter{

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());
        XBankCreditAPI api = new XBankCreditAPI();
        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);
        BankCreditResponse response = new BankCreditResponse();
        response.setApproval(xresponse.isApproval());
        return response;
    }
    
}
