/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resumesoapclient;

import com.alma.ws.User;
import com.alma.ws.services.ResumeWebServiceClient;

/**
 *
 * @author Alizaman
 */
public class Main {
    public static void main(String[] args) {
        User user=ResumeWebServiceClient.getUser("Alizman");
        System.out.println("fount : " + user.getName());
    }
}
