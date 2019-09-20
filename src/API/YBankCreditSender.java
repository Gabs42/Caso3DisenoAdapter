/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author Gabriel
 */
public class YBankCreditSender {
    
    public void sendCreditForValidate(final YBankCreditApprove request,final YBankCreditSenderListener listener){
        
        new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println("YBank recibio la solicitud en un momento y tendra la respuesta, sea paciente por favor");
               YBankCreditApproveResult response = new YBankCreditApproveResult();
               if(request.getCredit()<=1500){
                   response.setApproved("Y");
               }
               else{
                   response.setApproved("N");
               }
               try{
                   Thread.sleep(1000*3);
               }catch(Exception e){
                   e.printStackTrace();
               }
               listener.notifyCreditResult(response);
            }
        }).start();
            
        }
}

