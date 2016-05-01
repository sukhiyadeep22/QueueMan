package qman;

/**
 * Created by sukhi on 18-03-2016.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class CreationServiceImpl implements CreationService {
    @Autowired
    private CreationDAO cdDAO;

    @Transactional
    public void addContact(users user) {
        cdDAO.addContact(user);
    }

    @Transactional
    public Boolean CheckLogin(String Username, String Password)
    {
        Boolean LoginStatus = cdDAO.CheckLogin(Username, Password);
        return LoginStatus;
    }

    @Transactional
    public String FetchName(String Username){
        String Name = cdDAO.FetchName(Username);
        return Name;
    }

    @Transactional
    public Boolean isAdmin(String Username, HttpServletRequest request)
    {
        Boolean isAdmin = cdDAO.isAdmin(Username,request);
        return  isAdmin;
    }

    @Transactional
    public String getExistingPass(String Username, HttpServletRequest request){
        String currPass = cdDAO.getExistingPass(Username, request);
        return currPass;
    }

    @Transactional
    public Boolean setNewPass(String Username, String oldPass, String newPass, HttpServletRequest request) {
        Boolean passChangeStatus = cdDAO.setNewPass(Username, oldPass, newPass, request);
        return passChangeStatus;
    }

    @Transactional
    public String FetchUsername(String Name){
        String userName = cdDAO.FetchUsername(Name);
        return userName;
    }

    @Transactional
    public users getUser(String Username, HttpServletRequest request){
        users usr = cdDAO.getUser(Username, request);
        return usr;
    }

    @Transactional
    public Boolean UpdateZenToken(String Username, String ZenToken, HttpServletRequest request){
        Boolean tokenChangeStatus = cdDAO.UpdateZenToken(Username, ZenToken, request);
        return tokenChangeStatus;
    }

    @Transactional
    public String FetchEmail(String Name){
        String email = cdDAO.FetchEmail(Name);
        return email;
    }

    @Transactional
    public String FetchToken(String Name){
        String token = cdDAO.FetchToken(Name);
        return token;
    }

    @Transactional
    public void Queue(HttpServletRequest request){
        cdDAO.Queue(request);
    }
}
