package com.pkfcooperparry.template.ui.login;

import com.pkfcooperparry.template.data.model.db.User;

public interface LoginViewInterface {

    void handleError(String message);

    void login();

    void openMainActivity(User user);

}
