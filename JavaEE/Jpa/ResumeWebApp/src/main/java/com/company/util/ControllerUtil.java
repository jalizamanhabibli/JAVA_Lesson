package com.company.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse response,Exception ex){
        try {
            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage().substring(0,10));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
