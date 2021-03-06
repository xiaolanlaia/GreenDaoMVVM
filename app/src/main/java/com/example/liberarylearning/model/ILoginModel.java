package com.example.liberarylearning.model;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.EditText;

public interface ILoginModel {
    void login(Context context, String account, String password, ILoginListener iLoginListener);
    void logon(String account, String password, ILogonListener iLogonListener);
    void checkChecked(boolean ifChecked,ICheckCheckedListener iCheckCheckedListener);
    void restoreChecked(boolean ifRestoreChecked, IRestoreCheckListener iRestoreCheckListener);
    void firstRun(Context context, IFirstRunListener iFirstRunListener);
}
