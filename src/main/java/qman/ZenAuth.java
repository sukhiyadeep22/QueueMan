package qman;

import java.io.IOException;

/**
 * Created by sukhi on 22-03-2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ZenAuth {

    @RequestMapping(value="/ZenAuth", method=RequestMethod.GET)
    public ModelAndView ZenAuthForm() {
        ModelAndView Auth2ZenDesk = new ModelAndView("ZenAuth");
        return Auth2ZenDesk;
    }

    @RequestMapping(value="/ZenAuth", method = RequestMethod.POST)
    public String Navigate2URL(){
    	String resultIP = null, resultport=null;
    	try {
			resultIP = new getServerInfo().getPropValueIP();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			resultport = new getServerInfo().getPropValuePort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String redirectUrl = "https://cliqr.zendesk.com/oauth/authorizations/new?response_type=code&redirect_uri=http://"+resultIP+":"+resultport+"/TokenCode&client_id=queueman&scope=read%20write";
        return "redirect:" + redirectUrl;
    }
}
