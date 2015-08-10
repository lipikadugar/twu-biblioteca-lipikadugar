package com.twu.biblioteca.view;

public class WelcomeView implements IView {

    private View view;

    public WelcomeView(View view) {
        this.view = view;
    }

    @Override
    public IView execute() {
        String WELCOME_MESSAGE = "\t!!..Welcome to the Bibliotica..!!";
        view.print(WELCOME_MESSAGE);
        return new LoginMenuView(view).execute();
    }
}
