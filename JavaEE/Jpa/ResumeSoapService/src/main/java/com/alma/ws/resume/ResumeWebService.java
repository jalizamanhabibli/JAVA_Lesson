package com.alma.ws.resume;

import com.alma.ws.resume.bean.User;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alizaman
 */
@WebService(serviceName = "ResumeWebService")
public class ResumeWebService {

    /**
     * This is a sample web service operation
     * @param name
     * @return 
     */
    @WebMethod(operationName = "getUser")
    public User getUser(@WebParam(name = "name") String name) {
        System.out.println("User tapildi ve parametr olaraq " + name + " tapildi!");
        return new User(1,name,null);
    }
    
    /**
     * This is a sample web service operation
     * @param name
     * @param surname
     * @return 
     */
    @WebMethod(operationName = "getAllUser")
    public List<User> getAllUser(@WebParam(name = "name") String name, @WebParam(name = "surname") String surname) {
        return Arrays.asList(new User(1,name,surname), new User(2,name,surname));
    }
    
}
