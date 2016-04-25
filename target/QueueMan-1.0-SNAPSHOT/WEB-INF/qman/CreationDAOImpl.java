package qman;

/**
 * Created by sukhi on 18-03-2016.
 */

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@Repository
public class CreationDAOImpl implements CreationDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private Boolean status;
    private Boolean TokenStatus;
    private String Name;
    private Boolean isAdmin;
    private String oldPass;
    private users user;
    private Boolean passChangeStatus;
    private String Username;

    public void addContact(users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public Boolean CheckLogin(String Username, String Password) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from users where username= :name");
            query.setString("name", Username);
            Object obj = query.uniqueResult();
            users usr = (users) obj;
            if (usr != null && usr.getPassword().trim().equals(Password)) {
                status = true;
            } else {
                status = false;
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return status;
    }

    public Boolean UpdateToken(String Username, String TokenValue) {

        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "UPDATE users set AccessToken = :TokenValue " +
                    "WHERE username = :Username";
            Query query = session.createQuery(hql);
            query.setParameter("TokenValue", TokenValue);
            query.setParameter("Username", Username);
            int result = query.executeUpdate();
            if (result == 1) {
                TokenStatus = true;
            } else {
                TokenStatus = false;
            }
            return TokenStatus;
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return status;
    }

    public String FetchName(String Username) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query NameQuery = session.createQuery("from users where username= :name");
            NameQuery.setString("name", Username);
            Object obj = NameQuery.uniqueResult();
            users usr = (users) obj;
            if (usr != null && usr.getName() !=null)
            {
                Name = usr.getName().trim();
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return Name;
    }

    public String FetchUsername(String Name) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query UsernameQuery = session.createQuery("from users where name= :Name");
            UsernameQuery.setString("Name", Name);
            Object obj = UsernameQuery.uniqueResult();
            users usr = (users) obj;
            if (usr != null && usr.getName() !=null)
            {
                Username = usr.getUsername();
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return Username;
    }

    public Boolean isAdmin(String Username, HttpServletRequest request) {
        try {
            users usr = getUser(Username, request);
            if (usr != null)
            {
                isAdmin = usr.getIsAdmin();
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return isAdmin;
    }

    public String getExistingPass(String Username, HttpServletRequest request) {
        try {
            users usr = getUser(Username, request);
            if (usr != null)
            {
                oldPass = usr.getPassword();
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return oldPass;
    }

    public users getUser(String Username, HttpServletRequest request) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query userQuery = session.createQuery("from users where name= :name");
            userQuery.setString("name", (String)request.getSession().getAttribute("UserSessionName"));
            Object obj = userQuery.uniqueResult();
            users usr = (users) obj;
            if (usr != null)
            {
                user = usr;
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return user;
    }

    public Boolean setNewPass(String Username, String oldPass, String newPass, HttpServletRequest request)
    {
        try {
            users usr = getUser(Username, request);
            if (usr != null)
            {
                Session session = sessionFactory.getCurrentSession();
                String updatePass = "UPDATE users set password = :Password " + "WHERE name = :Username";
                Query query = session.createQuery(updatePass);
                query.setParameter("Password", newPass);
                query.setParameter("Username", Username);
                int passUpdateresult = query.executeUpdate();
                if (passUpdateresult == 1) {
                    passChangeStatus = true;
                } else {
                    passChangeStatus = false;
                }
            }
            else{
                passChangeStatus = false;
            }
        } catch (Exception e) {
            System.out.println("Exception Caught" + e);
        }
        return passChangeStatus;
    }
}
