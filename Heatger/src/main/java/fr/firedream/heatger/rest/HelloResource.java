package fr.firedream.heatger.rest;

import fr.firedream.heatger.bll.ClockManager;
import fr.firedream.heatger.bo.Zone;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("application/json")
    public String hello() {
        ClockManager cm = null;
        try {
            cm = new ClockManager();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(cm.getRemainingTime(Zone.ZONE1));
    }
}