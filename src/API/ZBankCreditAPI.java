/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Request.ZBankCreditRequest;
import Response.ZBankCreditResponse;

/**
 *
 * @author Gabriel
 */
public class ZBankCreditAPI {
    public ZBankCreditResponse sendCreditRequest(ZBankCreditRequest request) throws Exception{
        ZBankCreditResponse response = new ZBankCreditResponse();
        if(request.getRequestAmount() <= 2000){
            response.setApproval(true);
        }
        else{
            throw new Exception("Creito rechazado");
        }
        return response;
    }
}
