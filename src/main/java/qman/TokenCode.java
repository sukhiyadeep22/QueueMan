package qman;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sukhi on 26-03-2016.
 */


@Controller
public class TokenCode {

    @Autowired
    CreationService creationService;
    ModelAndView model;
    

    @RequestMapping(value="/TokenCode", method= RequestMethod.GET)
    public String ZenAuthForm(HttpServletRequest request) throws IOException{
        try {
        	String resultIP = new getServerInfo().getPropValueIP();
            String resultport = new getServerInfo().getPropValuePort();
            Boolean updateStatus;
            Client client = Client.create();
            String Code = request.getParameter("code");
            WebResource webResource = client
                    .resource("https://cliqr.zendesk.com/oauth/tokens");
            String input = "{\"grant_type\": \"authorization_code\", \"code\": \"" + Code + "\", \"client_id\": \"queueman\", \"client_secret\": \"6b3dccc4ac61ae7c11b617767ef381b08609006b54a570fbe68bff57577a12a4\", \"redirect_uri\": \"http://"+resultIP+":"+resultport+"/TokenCode\", \"scope\": \"read write\" }";
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, input);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            JSONObject jsonObj = new JSONObject(output);
            String ZenToken = jsonObj.getString("access_token");
            System.out.println(ZenToken);
            String Name = creationService.FetchName((String)request.getSession().getAttribute("UserSessionName")) ;
            updateStatus = creationService.UpdateZenToken(Name,ZenToken,request);
            if (updateStatus.equals(true)){
                model = new ModelAndView("Queue");
                String test = "redirect:" + "http://"+resultIP+":"+resultport+"/queue";
                return test;
            }
            else{
                model = new ModelAndView("Error");
                String test = "redirect:" + "http://"+resultIP+":"+resultport+"/Error";
                return test;
            }
        } catch (Exception e) {
        	String resultIP = new getServerInfo().getPropValueIP();
            String resultport = new getServerInfo().getPropValuePort();
            e.printStackTrace();
            model = new ModelAndView("Error");
            //return  model;
            String test = "redirect:" + "http://"+resultIP+":"+resultport+"/Error";
            return test;
        }
    }
}
