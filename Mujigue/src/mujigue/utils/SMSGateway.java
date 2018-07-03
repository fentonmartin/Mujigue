/*
 *THIS CODE WRITTEN WITH LOVE BY MUHAMMAD HERMAS YUDA P
 *https://github.com/hermasyp
 */
package mujigue.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import org.smslib.*;

/**
 *
 * @author herma
 */
public class SMSGateway {

    SerialModemGateway gateway;

    /**
     * @param args the command line arguments
     */
    public void setConfiguration(String port, int bitRate, String modemName,String modemType, String modemPin, String SMSC) {
        try {
            OutboundNotification outboundNotification = new OutboundNotification();
            gateway = new SerialModemGateway("modem."+port, port, bitRate, modemName, modemType);
            gateway.setInbound(true);
            gateway.setOutbound(true);
            gateway.setSimPin(modemPin);
            gateway.setSmscNumber(SMSC);
            Service.getInstance().setOutboundMessageNotification(outboundNotification);
            Service.getInstance().addGateway(gateway);
            Service.getInstance().startService();
            System.out.println();
            System.out.println("Modem Information:");
            System.out.println("  Manufacturer: " + gateway.getManufacturer());
            System.out.println("  Model: " + gateway.getModel());
            System.out.println("  Serial No: " + gateway.getSerialNo());
            System.out.println("  SIM IMSI: " + gateway.getImsi());
            System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
            System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
            System.out.println();
        } catch (GatewayException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SMSLibException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OutboundMessage sendMessage(String number,String message) {
        OutboundMessage msg = msg = new OutboundMessage(number, message);
        try {
            Service.getInstance().sendMessage(msg);
            System.out.println(msg);
            Service.getInstance().stopService();
        } catch (TimeoutException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GatewayException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SMSLibException ex) {
            Logger.getLogger(SMSGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    public class OutboundNotification implements IOutboundMessageNotification {

        public void process(AGateway gateway, OutboundMessage msg) {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }
    /*
    public static void main(String[] args) {
    // TODO code application logic here
    SMSGateway app = new SMSGateway();
    try {
    app.setConfiguration("COM11", 9600, "Huawei", "E153", "0000", "+628315000032");
    OutboundMessage msg = app.sendMessage("083806757678", "Test Message from HermasSMS");
    System.out.println("Status SMS : "+ msg.getMessageStatus());
    } catch (Exception e) {
    e.printStackTrace();
    }
    
    }*/

}
