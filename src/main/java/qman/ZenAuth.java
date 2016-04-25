package qman;

/**
 * Created by sukhi on 22-03-2016.
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class ZenAuth {

    @RequestMapping(value="/ZenAuth", method=RequestMethod.GET)
    public ModelAndView ZenAuthForm() {
        ModelAndView Auth2ZenDesk = new ModelAndView("ZenAuth");
        return Auth2ZenDesk;
    }

    @RequestMapping(value="/ZenAuth", method = RequestMethod.POST)
    public String Navigate2URL(){
        String redirectUrl = "https://cliqr.zendesk.com/oauth/authorizations/new?response_type=code&redirect_uri=http://localhost:8080/TokenCode&client_id=queueman&scope=read%20write";
        return "redirect:" + redirectUrl;
    }
}
