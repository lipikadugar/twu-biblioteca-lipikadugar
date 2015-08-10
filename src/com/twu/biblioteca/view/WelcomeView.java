package com.twu.biblioteca.view;

public class WelcomeView implements IView {

    private View view;
    private LoginMenuView loginMenuView;

    public WelcomeView(View view, LoginMenuView loginMenuView) {
        this.view = view;
        this.loginMenuView = loginMenuView;
    }

    @Override
    public IView execute() {
        String WELCOME_MESSAGE = "\t!!..Welcome to the Bibliotica..!!";
        view.print(WELCOME_MESSAGE);
        return loginMenuView.execute();
    }
}
