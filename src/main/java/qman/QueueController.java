package qman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import org.zendesk.client.v2.*;

/**
 * Created by sukhi on 25-03-2016.
 */
@Controller
public class QueueController {
    @Autowired
    private qman.CreationService creationService;
    ModelAndView queue;


    @RequestMapping(value="/queue", method= RequestMethod.GET)
    public ModelAndView Queue(HttpServletRequest request) {
        try {
            request.getSession().setAttribute("UserSessionPage", "Queue");
            queue = new ModelAndView("Queue");
        }
        catch (Exception e){
            System.out.println("Error occurred on Queue Page");
            e.printStackTrace();
        }
        return queue;
    }
}
