/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso3disenobank;

import Adapter.IBankAdapter;
import Adapter.XBankCreditAdaptee;
import Adapter.YBankCreditAdaptee;
import Factory.AdapterFactory;
import Request.BankCreditRequest;
import Response.BankCreditResponse;

/**
 *
 * @author Gabriel
 */
public class Caso3DisenoBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdapterFactory factory =  new AdapterFactory();
        BankCreditRequest request = new BankCreditRequest();
        request.setCustomer("Oscar Blancarte");
        request.setAmount(3000);
        
        IBankAdapter xBank = factory.getInstace("X");
        BankCreditResponse xresponse = xBank.sendCreditRequest(request);
        System.out.println("xBank approved>"+xresponse.isApproval()+"\n");
        
        IBankAdapter yBank = factory.getInstace("Y");
        BankCreditResponse yresponse = yBank.sendCreditRequest(request);
        System.out.println("yBank approved>"+yresponse.isApproval()+"\n");
        
        IBankAdapter zBank = factory.getInstace("Z");
        BankCreditResponse zresponse = zBank.sendCreditRequest(request);
        System.out.println("zBank approved>"+zresponse.isApproval()+"\n");
        
        if(yresponse.isApproval()){
            System.out.println("yBank aprobo su credito,felicidas");
        }
        else if(xresponse.isApproval()){
            System.out.println("xBank aprobo su credito,felicidas");
        }
        else{
            System.out.println("Lo sentimos su credito no ha sido aprovado");
        }
    }
    
}
