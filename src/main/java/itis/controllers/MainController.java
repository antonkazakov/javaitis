package itis.controllers;

import itis.factories.DaoFactory;
import itis.services.AuthorizationService;
import itis.services.AuthorizationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by antonkazakov on 22.11.16.
 */
public class MainController extends HttpServlet{

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        RequestDispatcher requestDispatcher = null;

        AuthorizationService authorizationService = new AuthorizationServiceImpl(DaoFactory.getDaoFactory().getAuthorizationDAO());
        authorizationService.register(login,password);

        if (authorizationService.register(login,password)!=-1){
            requestDispatcher = req.getRequestDispatcher("/error.jsp");
        }else{
            requestDispatcher = req.getRequestDispatcher("/success.jsp");
        }

        requestDispatcher.forward(req,resp);
    }

}
