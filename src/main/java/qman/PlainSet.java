package qman;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by sukhi on 15-04-2016.
 */
public class PlainSet {

    @Autowired
    CreationDAO crDAO;

    public Set GetTableSet(HttpServletRequest request){
        Set sr = crDAO.Queue(request);
        return sr;
    }
}
