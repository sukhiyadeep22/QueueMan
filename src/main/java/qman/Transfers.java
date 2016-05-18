package qman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sukhi on 02-05-2016.
 */
@Controller
public class Transfers {
    @Autowired
    private qman.CreationService creationService;

    @RequestMapping(value="/transfers", method= RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView model = new ModelAndView("Transfers");
        return model;
    }
}
