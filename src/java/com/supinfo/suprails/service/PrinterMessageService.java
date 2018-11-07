package com.supinfo.suprails.service;

import com.supinfo.suprails.entity.CustomerOrder;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Binarymachine
 */
@Stateless
public class PrinterMessageService {
    
    @Resource(mappedName="jms/suprailsConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(mappedName="jms/suprailsQueue")
    private Destination destination;
    
    
    public void printCustomerOrder(CustomerOrder customerOrder) {
        
        Connection connection = null;
        
        try {
            connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(destination);
            
            
            StringBuilder messageContent = new StringBuilder("Order for ");
            
            messageContent.append(customerOrder.getCustomer().getFirstName());
            messageContent.append(" ");
            messageContent.append(customerOrder.getCustomer().getLastName());
            
            
            TextMessage message = session.createTextMessage(messageContent.toString());
            
            producer.send(message);
            
        } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(null != connection) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }
}