package qman;

/**
 * Created by sukhi on 18-04-2016.
 */

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Set;

@Path("/tickets")
public class TicketAPI {
    @Autowired
    CreationService creationService;

    @GET
    @Produces("application/xml")
    public void TicketsXML(HttpServletRequest request) {
        Set qSet = creationService.Queue();
    }
}
