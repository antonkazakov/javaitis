package itis.controllers;

import itis.dao.AuthorizationDAO;
import itis.factories.DaoFactory;
import itis.services.AuthorizationServiceImpl;

/**
 * Created by antonkazakov on 24.11.16.
 */
public class Main {

    public static void main(String[] args) {
        AuthorizationServiceImpl authorizationService = new AuthorizationServiceImpl(DaoFactory.getDaoFactory().getAuthorizationDAO());

        System.out.println(authorizationService.register("tes22232212q2t2w", "tetet")+"");
    }

}
