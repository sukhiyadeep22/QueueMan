package qman;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sukhi on 18-03-2016.
 */

public interface CreationService {
    void addContact(users user);
    Boolean CheckLogin(String Username, String Password);
    Boolean UpdateToken(String Username, String TokenValue);
    public String FetchName(String Username);
    public Boolean isAdmin(String Username, HttpServletRequest request);
    public String getExistingPass(String Username, HttpServletRequest request);
    public Boolean setNewPass(String Username, String oldPass, String newPass, HttpServletRequest request);
    public String FetchUsername(String Name);
    public users getUser(String Username, HttpServletRequest request);
}
