package itis.services;

import com.sun.istack.internal.NotNull;

/**
 * Created by antonkazakov on 22.11.16.
 */
public interface AuthorizationService {

    @NotNull
    long register(String login, String password);

    String login(String login, String password);

}
