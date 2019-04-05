package com.example.liberarylearning.view;

import android.widget.CheckBox;
import android.widget.EditText;

public interface ILoginView {

    void loginFailed();
    void loginSuccess();
    void loginEmpty();
    void logonFailed();
    void logonSuccess();
    void logonEmpty();
    void checkChecked();
    void restoreChecked();
    void firstRun();
    String getAccount();
    String getPassword();
    CheckBox getCheckBox();
    void restoreCheckListener();
    void firstRunToast();


}
