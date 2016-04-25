package qman;

/**
 * Created by sukhi on 25-02-2016.
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;


/**
 * @author sukhi
 *
 */
@Controller
public class LoginController {

    @Autowired
    private qman.CreationService CreationService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ModelAndView loginFormSubmit(@RequestParam("Username") String Username, @RequestParam("Password") String Password,HttpServletRequest request)
    {
        try{
            request.getSession().setAttribute("UserSessionPage", "Login");
            ModelAndView loginModel;
            Boolean Loginstatus = CreationService.CheckLogin(Username, Password);
            if (Loginstatus.equals(true))
            {
                loginModel = new ModelAndView("Queue");
                request.getSession().setAttribute("UserSessionId", request.getSession().getId().toString());
                request.getSession().setAttribute("UserSessionName",CreationService.FetchName(Username));
            }
            else{
                loginModel = new ModelAndView("index");
            }
            return loginModel;
        }
        catch(Exception e){
            System.out.println(e);
            ModelAndView loginModel = new ModelAndView("Error");
            return loginModel;
        }


    }
}

