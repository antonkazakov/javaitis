package itis.services;

import com.sun.istack.internal.NotNull;
import itis.dao.AuthorizationDAO;

/**
 * Created by antonkazakov on 22.11.16.
 */
public class AuthorizationServiceImpl implements AuthorizationService{

    private AuthorizationDAO authorizationDAO;

    public AuthorizationServiceImpl(AuthorizationDAO authorizationDAO) {
        this.authorizationDAO = authorizationDAO;
    }


    @NotNull
    public long register(String login, String password) {
        return authorizationDAO.register(login,password);
    }


    public String login(String login, String password) {
        return authorizationDAO.login(login,password);
    }

}
