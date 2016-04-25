package qman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sukhi on 24-03-2016.
 */
@Controller
public class RegistrationController {
    @Autowired
    private CreationService crudService;
    ModelAndView registration;


    @RequestMapping(value="/registration", method= RequestMethod.GET)
    public ModelAndView RegistrationForm(HttpServletRequest request) {
        ModelAndView model;
        /*if( request.getSession().getAttribute("UserSessionId") != null)
        {
            */if(crudService.isAdmin((String)request.getSession().getAttribute("UserSessionName"),request).equals(true))
            {
                request.getSession().setAttribute("UserSessionPage", "Registration");
                model = new ModelAndView("Registration");
            }
            else {
                model = new ModelAndView("Queue");
            }
            return model;/*
        }
        else{
            model = new ModelAndView("index");
            return model;
        }*/

    }

    @RequestMapping(value="/registration", method = RequestMethod.POST)
    public ModelAndView ResetPass(@RequestParam("Username") String Username,@RequestParam("Name") String Name, @RequestParam("Password") String Password, @RequestParam("ReTypePassword") String ReTypePassword, @RequestParam("mailId") String mailId, HttpServletRequest request) {
        if(crudService.isAdmin((String)request.getSession().getAttribute("UserSessionName"),request).equals(true))
        {
            users newRegisUser = new users();
            newRegisUser.setUsername(Username);
            newRegisUser.setIsFirstLogin(true);
            newRegisUser.setPassword(Password);
            newRegisUser.setName(Name);
            newRegisUser.setMailId(mailId);
            newRegisUser.setIsAdmin(false);

            crudService.addContact(newRegisUser);

            registration = new ModelAndView("Registration");
        }
        return registration;
    }
}
