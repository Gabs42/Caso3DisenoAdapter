/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Adapter.IBankAdapter;
import Adapter.XBankCreditAdaptee;
import Adapter.YBankCreditAdaptee;
import Adapter.ZBankCreditAdaptee;

/**
 *
 * @author Gabriel
 */
public class AdapterFactory implements IFactory {

    @Override
    public IBankAdapter getInstace(String type) {
        if(type.compareToIgnoreCase("X")==0){
            return new XBankCreditAdaptee();
        }
        else if(type.compareToIgnoreCase("Y")==0){
            return new YBankCreditAdaptee();
        }
        else if(type.compareToIgnoreCase("Z")==0)
            return new ZBankCreditAdaptee();  
        return null;
    }
    

}
