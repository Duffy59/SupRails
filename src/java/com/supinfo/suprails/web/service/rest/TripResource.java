package com.supinfo.suprails.web.service.rest;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author Binarymachine
 */
@Path("/trips")
@Produces(MediaType.APPLICATION_JSON)
public class TripResource {
    
    @EJB
    private TripService tripService;
    
    @GET
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}