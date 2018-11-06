package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Local;

@Local
public interface CustomerOrderDao {

    /**
     * Permet de créer une reservation pour un client.
     * @param customerOrder objet representant une reservation.
     */
    CustomerOrder addCustomerOrder(CustomerOrder customerOrder);

}
