package me.ashif.sunnah.backend.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import me.ashif.sunnah.backend.consts.Constants;
import sun.rmi.runtime.Log;

import static me.ashif.sunnah.backend.consts.Constants.PASSWORD_CAPTION;
import static me.ashif.sunnah.backend.consts.Constants.SIGNIN_CAPTION;
import static me.ashif.sunnah.backend.consts.Constants.USERNAME_CAPTION;

/**
 * Created by Ashif on 13/7/17.
 * github.com/SheikhZayed
 */

@Theme("valo")
@SpringUI(path = "/login")
@SpringView(name = LoginUI.VIEW_NAME)
public class LoginUI extends UI implements View {
    private VerticalLayout mRootLayout;
    public static final String VIEW_NAME = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addLayout();
        addForm();
//        addFooter();
    }

    private void addLayout() {
        mRootLayout = new VerticalLayout();
        mRootLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(mRootLayout);
    }

    private void addForm() {
        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label header = new Label(Constants.WELCOME_NOTE);
        header.addStyleName(ValoTheme.LABEL_H2);
        mRootLayout.addComponent(header);
        mRootLayout.setSpacing(true);

        Panel loginPanel = new Panel("Authenticate ");
        loginPanel.setWidth("30%");


        TextField username = new TextField();
        username.setCaption(USERNAME_CAPTION);
        PasswordField passwordField = new PasswordField();
        passwordField.setCaption(PASSWORD_CAPTION);
        Button loginButton = new Button(SIGNIN_CAPTION);
        loginButton.addClickListener((e)  -> getUI().getPage().setLocation("http://www.ashif.me"));
        loginButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        loginLayout.addComponent(username);
        loginLayout.addComponent(passwordField);
        loginLayout.addComponent(loginButton);
        loginPanel.setContent(loginLayout);

        mRootLayout.addComponent(loginPanel);
    }

    private void addFooter() {
        HorizontalLayout footerLayout = new HorizontalLayout();
        footerLayout.setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
        mRootLayout.addComponent(new Label(Constants.FOOTER_TEXT));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
