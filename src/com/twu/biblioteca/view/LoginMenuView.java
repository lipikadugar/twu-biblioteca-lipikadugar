package com.twu.biblioteca.view;

public class LoginMenuView implements IView {

    private View view;
    private Dispatcher dispatch;

    public LoginMenuView(View view, Dispatcher dispatch) {
        this.view = view;
        this.dispatch = dispatch;
    }

    @Override
    public IView execute() {
        String LOGIN_MENU = "=========================================\n" +
                "\t1. List Books\n" +
                "\t2. List Movies\n" +
                "\t3. Login as Librarian\n" +
                "\t4. Login as User\n" +
                "\t5. Quit\n" +
                "=========================================\n" +
                "Choose a option: \n";
        view.print(LOGIN_MENU);
        return dispatch.execute();
    }
}
