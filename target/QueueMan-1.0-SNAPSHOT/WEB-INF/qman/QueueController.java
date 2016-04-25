package qman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sukhi on 25-03-2016.
 */
@Controller
public class QueueController {
    @Autowired
    private qman.CreationService CreationService;
    ModelAndView queue;


    @RequestMapping(value="/queue", method= RequestMethod.GET)
    public ModelAndView Queue(HttpServletRequest request) {
        request.getSession().setAttribute("UserSessionPage", "Queue");
        String username;
        String AccessToken;
        queue = new ModelAndView("Queue");
        return queue;
    }
}
