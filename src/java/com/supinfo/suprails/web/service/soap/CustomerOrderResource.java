package com.supinfo.suprails.web.service.soap;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="soap/customerorders")
public class CustomerOrderResource {
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    @EJB
    private TripService tripService;
    
    public CustomerOrder create(@WebParam(name = "firstname") String firstname,
                                @WebParam(name = "lastname") String lastname,
                                @WebParam(name = "email") String email,
                                @WebParam(name = "tripId") Long tripId) {
        
        CustomerOrder customerOrder = new CustomerOrder();
        Customer customer = new Customer();
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmail(email);
        customerOrder.setCustomer(customer);
        
        Trip trip = tripService.findTripById(tripId);
        if(null == trip) {
            return null;
        }
        
        customerOrder.setTrip(trip);
        
        customerOrderService.processCustomerOrder(customerOrder);
        
        return customerOrder;
    }
    
}