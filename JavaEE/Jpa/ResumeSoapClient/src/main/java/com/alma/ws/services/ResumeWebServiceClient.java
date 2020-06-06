package com.alma.ws.services;

import com.alma.ws.*;

/**
 *
 * @author Alizaman
 */
public class ResumeWebServiceClient {
    public static User getUser(String name) {
        User result = null;
        try { // Call Web Service Operation
            ResumeWebService_Service service = new ResumeWebService_Service();
            ResumeWebService port = service.getResumeWebServicePort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
             result = port.getUser(name);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }
}
