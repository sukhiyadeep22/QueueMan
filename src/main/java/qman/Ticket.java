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
 * Created by sukhi on 15-04-2016.
 */
@Controller
public class Ticket {
    @Autowired
    private qman.CreationService creationService;
    ModelAndView ticket;

    @RequestMapping(value="/tickets", method= RequestMethod.GET)
    public ModelAndView Tickets(HttpServletRequest request) {
        request.getSession().setAttribute("UserSessionPage", "Ticket");
        String s = null;
        StringBuilder sb = new StringBuilder();
        try {
            String PyComm = "python /usr/local/tomcat7/webapps/ROOT/resources/python/2day.py " + creationService.FetchToken((String)request.getSession().getAttribute("UserSessionName")).trim();
            Process pe = Runtime.getRuntime().exec(PyComm);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(pe.getInputStream()));
            while ((s = stdInput.readLine()) != null) {
                sb.append(s);
            }

            ticket = new ModelAndView("tickets");
            ticket.addObject("s",sb);
        }
        catch (Exception e){
            System.out.println("Error occurred on Queue Page");
            e.printStackTrace();
        }
        return ticket;
    }
}

