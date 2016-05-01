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
    ModelAndView loginModel;

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
            Boolean Loginstatus = CreationService.CheckLogin(Username, Password);
            if (Loginstatus.equals(true))
            {

                loginModel = new ModelAndView("LoginSuccess");
                request.getSession().setAttribute("UserSessionId", request.getSession().getId().toString());
                request.getSession().setAttribute("UserSessionName",CreationService.FetchName(Username));
                String s = "Welcome " + CreationService.FetchName(Username) + ", Please start by Authorizing to Zendesk \n Once Authorized you can see all the Tickets";
                loginModel.addObject("s",s);
            }
            else{
                loginModel = new ModelAndView("index");
            }
        }
        catch(Exception e){
            System.out.println(e);
            loginModel = new ModelAndView("Error");
        }
        return loginModel;

    }
}

