package qman;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by sukhi on 18-03-2016.
 */
public interface CreationDAO {
    public void addContact(users user);
    public Boolean CheckLogin(String Username, String Password);
    public String FetchName(String Username);
    public Boolean isAdmin(String Username, HttpServletRequest request);
    public String getExistingPass(String Username, HttpServletRequest request);
    public Boolean setNewPass(String Username, String oldPass, String newPass, HttpServletRequest request);
    public String FetchUsername(String Name);
    public users getUser(String Username, HttpServletRequest request);
    public Boolean UpdateZenToken(String Username, String ZenToken, HttpServletRequest request);
    public String FetchEmail(String Name);
    public String FetchToken(String Name);
    public void Queue(HttpServletRequest request);
}

