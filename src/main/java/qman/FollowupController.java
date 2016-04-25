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
public class FollowupController {
    @Autowired
    private qman.CreationService CreationService;


    @RequestMapping(value="/followup", method= RequestMethod.GET)
    public ModelAndView Followup(HttpServletRequest request) {
        ModelAndView followup = new ModelAndView("Followup");
        request.getSession().setAttribute("UserSessionPage", "Followup");
        return followup;
    }
}
