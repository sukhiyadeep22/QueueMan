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
public class QueueController {
    @Autowired
    private qman.CreationService creationService;
    ModelAndView queue;

    @RequestMapping(value="/queue", method= RequestMethod.GET)
    public ModelAndView Queue(HttpServletRequest request) {
        request.getSession().setAttribute("UserSessionPage", "Queue");
        String s = null;
        StringBuilder sb = new StringBuilder();
        try {
            String PyComm = "python E:\\Projects\\QueueMan\\target\\QueueMan-1.0-SNAPSHOT\\resources\\python\\newcases.py " + creationService.FetchToken((String)request.getSession().getAttribute("UserSessionName")).trim();
            Process pe = Runtime.getRuntime().exec(PyComm);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(pe.getInputStream()));
            while ((s = stdInput.readLine()) != null) {
                sb.append(s);
            }
            queue = new ModelAndView("Queue");
            queue.addObject("s",sb);
        }
        catch (Exception e){
            System.out.println("Error occurred on Queue Page");
            e.printStackTrace();
        }
        return queue;
    }
}
