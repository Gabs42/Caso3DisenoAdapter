/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import API.YBankCreditApprove;
import API.YBankCreditApproveResult;
import API.YBankCreditSender;
import API.YBankCreditSenderListener;
import Request.BankCreditRequest;
import Response.BankCreditResponse;

/**
 *
 * @author Gabriel
 */
public class YBankCreditAdaptee implements IBankAdapter,YBankCreditSenderListener{

    private YBankCreditApproveResult yresponse;
    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        YBankCreditApprove yrequest = new YBankCreditApprove();
        yrequest.setCredit((float)request.getAmount());
        yrequest.setName(request.getCustomer());
        YBankCreditSender sender = new YBankCreditSender();
        sender.sendCreditForValidate(yrequest, this);
        do{
            try{
                Thread.sleep(10000);
                System.out.println("YBank peticion en espera...");
            }catch(Exception e){
                e.printStackTrace();
            }
        }while(yresponse==null);
        BankCreditResponse response = new BankCreditResponse();
        response.setApproval(yresponse.getApproved() == "Y"?true:false);
        return response;
    }

    @Override
    public void notifyCreditResult(YBankCreditApproveResult result) {
        this.yresponse = result;
    }
    
}
