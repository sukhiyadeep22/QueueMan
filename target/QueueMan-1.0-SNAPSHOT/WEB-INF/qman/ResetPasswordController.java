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
public class ResetPasswordController {
    @Autowired
    private CreationService crudService;

    @RequestMapping(value="/resetpass", method= RequestMethod.GET)
    public ModelAndView ResetPassword(HttpServletRequest request) {
        ModelAndView model;
        if( request.getSession().getAttribute("UserSessionId") != null)
        {
            if(crudService.isAdmin((String)request.getSession().getAttribute("UserSessionName"),request).equals(true))
            {
                request.getSession().setAttribute("UserSessionPage", "Reset Password");
                model = new ModelAndView("Resetpassword");
            }
            else {
                model = new ModelAndView("Queue");
            }
            return model;
        }
        else{
            model = new ModelAndView("index");
            return model;
        }

    }

    @RequestMapping(value="/resetpass", method = RequestMethod.POST)
    public ModelAndView ResetPass(@RequestParam("CurrentPassword") String CurrentPassword, @RequestParam("NewPassword") String NewPassword,@RequestParam("ReTypeNewPassword") String ReTypeNewPassword,HttpServletRequest request) {
        ModelAndView NewPass;
        Boolean status;
        String Name = crudService.FetchName((String)request.getSession().getAttribute("UserSessionName")) ;
        users usr = crudService.getUser(Name, request);
        String password = usr.getPassword();
        if(CurrentPassword != NewPassword && NewPassword.equals(ReTypeNewPassword) && password.trim().equals(CurrentPassword))
        {
            String userName= (String)request.getSession().getAttribute("UserSessionName");
            status = crudService.setNewPass(userName,CurrentPassword, NewPassword, request);
            if(status = true)
            {
                NewPass =  new ModelAndView("Resetpassword");
            }

            else
            {
                NewPass = new ModelAndView("Error");
            }
            return NewPass;
        }
        else {
            NewPass = new ModelAndView("Resetpassword");
            return NewPass;
        }
    }
}
