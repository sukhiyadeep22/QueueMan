package qman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sukhi on 11-04-2016.
 */
@Controller
public class Logout {
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        request.getSession().invalidate();
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}
