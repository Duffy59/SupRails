package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TrainStationService;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.TableRowSorter;
import java.io.IOException;

/**
 *
 * @author bargenson
 */
@WebServlet(name = "AddCustomerOrderServlet", urlPatterns = {"/trips/addCustomerOrder"})
public class AddCustomerOrderServlet extends HttpServlet {

    @EJB
    private CustomerOrderService customerOrderService;

    @EJB
    private TripService tripService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idTrip = req.getParameter("id") != null ? Long.valueOf(req.getParameter("id")) : null;

        if(idTrip != null) {
            Trip trip = tripService.findTripById(idTrip);
            req.setAttribute("trip", trip);
            req.getRequestDispatcher("/jsp/addCustomerOrder.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/trips");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CustomerOrder customerOrder = new CustomerOrder();

        Customer customer = new Customer();
        customer.setEmail(req.getParameter("email"));
        customer.setFirstName(req.getParameter("firstName"));
        customer.setLastName(req.getParameter("lastName"));

        customerOrder.setCustomer(customer);

        Long idTrip = req.getParameter("id") != null ? Long.valueOf(req.getParameter("id")) : null;
        Trip trip = tripService.findTripById(idTrip);
        customerOrder.setTrip(trip);

        customerOrderService.processCustomerOrder(customerOrder);

        resp.sendRedirect(req.getContextPath() + "/trips");
    }
    
}
