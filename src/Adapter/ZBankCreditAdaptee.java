/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import API.ZBankCreditAPI;
import Request.BankCreditRequest;
import Request.ZBankCreditRequest;
import Response.BankCreditResponse;
import Response.ZBankCreditResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class ZBankCreditAdaptee implements IBankAdapter {

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        ZBankCreditRequest zrequest = new ZBankCreditRequest();
        zrequest.setCustomerName(request.getCustomer());
        zrequest.setRequestAmount(request.getAmount());
        ZBankCreditAPI api = new ZBankCreditAPI();
        ZBankCreditResponse zresponse = new ZBankCreditResponse();
        try {
            zresponse = api.sendCreditRequest(zrequest);
        } catch (Exception ex) {
            zresponse.setApproval(false);
        }
        BankCreditResponse response = new BankCreditResponse();
        response.setApproval(zresponse.isApproval());
        return response;
    }
    
}
