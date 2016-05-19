package qman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sukhi on 25-03-2016.
 */
@Controller
public class FollowupController {
    @Autowired
    private qman.CreationService creationService;
    ModelAndView followup;

    @RequestMapping(value="/followup", method= RequestMethod.GET)
    public ModelAndView Followup(HttpServletRequest request) {
        request.getSession().setAttribute("UserSessionPage", "Followup");
        String a = null;
        StringBuilder sa = new StringBuilder();
        try {
            String PyComm1 = "python /usr/local/tomcat7/webapps/ROOT/resources/python/urgent.py " + creationService.FetchToken((String)request.getSession().getAttribute("UserSessionName")).trim();
            Process pa = Runtime.getRuntime().exec(PyComm1);
            BufferedReader stdInput1 = new BufferedReader(new InputStreamReader(pa.getInputStream()));
            while ((a = stdInput1.readLine()) != null) {
                sa.append(a);
            }
            followup = new ModelAndView("Followup");
            followup.addObject("sa",sa);
        }
        catch (Exception e){
            System.out.println("Error occurred on Queue Page");
            e.printStackTrace();
        }
        return followup;
    }
}
