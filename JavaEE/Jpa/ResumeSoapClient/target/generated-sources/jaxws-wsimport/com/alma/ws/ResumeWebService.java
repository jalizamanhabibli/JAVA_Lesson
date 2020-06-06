
package com.alma.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ResumeWebService", targetNamespace = "http://resume.ws.alma.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ResumeWebService {


    /**
     * 
     * @param surname
     * @param name
     * @return
     *     returns java.util.List<com.alma.ws.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllUser", targetNamespace = "http://resume.ws.alma.com/", className = "com.alma.ws.GetAllUser")
    @ResponseWrapper(localName = "getAllUserResponse", targetNamespace = "http://resume.ws.alma.com/", className = "com.alma.ws.GetAllUserResponse")
    @Action(input = "http://resume.ws.alma.com/ResumeWebService/getAllUserRequest", output = "http://resume.ws.alma.com/ResumeWebService/getAllUserResponse")
    public List<User> getAllUser(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "surname", targetNamespace = "")
        String surname);

    /**
     * 
     * @param name
     * @return
     *     returns com.alma.ws.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://resume.ws.alma.com/", className = "com.alma.ws.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://resume.ws.alma.com/", className = "com.alma.ws.GetUserResponse")
    @Action(input = "http://resume.ws.alma.com/ResumeWebService/getUserRequest", output = "http://resume.ws.alma.com/ResumeWebService/getUserResponse")
    public User getUser(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
