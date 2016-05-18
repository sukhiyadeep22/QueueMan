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
 * Created by sukhi on 01-05-2016.
 */
@Controller
public class SLABreach {
    @Autowired
    private qman.CreationService creationService;
    ModelAndView slabreach;
    @RequestMapping(value="/breach", method= RequestMethod.GET)
    public ModelAndView Queue(HttpServletRequest request) {
        request.getSession().setAttribute("UserSessionPage", "SLABreach");
        String s = null;
        StringBuilder sb = new StringBuilder();
        try {
            String PyComm = "python E:\\Projects\\QueueMan\\target\\QueueMan-1.0-SNAPSHOT\\resources\\python\\tickets.py " + creationService.FetchToken((String)request.getSession().getAttribute("UserSessionName")).trim();
            Process pe = Runtime.getRuntime().exec(PyComm);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(pe.getInputStream()));
            while ((s = stdInput.readLine()) != null) {
                sb.append(s);
            }
            slabreach = new ModelAndView("breach");
            slabreach.addObject("s",sb);
        }
        catch (Exception e){
            System.out.println("Error occurred on Queue Page");
            e.printStackTrace();
        }
        return slabreach;
    }
}