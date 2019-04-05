package com.example.liberarylearning.viewmodel;

import android.content.Context;

import com.example.liberarylearning.model.IFirstRunListener;
import com.example.liberarylearning.model.ILoginListener;
import com.example.liberarylearning.model.ILoginModel;
import com.example.liberarylearning.model.ILogonListener;
import com.example.liberarylearning.model.IRestoreCheckListener;
import com.example.liberarylearning.model.LoginModel;
import com.example.liberarylearning.view.ILoginView;


public class LoginPresenter {

    private ILoginView iLoginView;
    private ILoginModel iLoginModel;

    public LoginPresenter(ILoginView iLoginView){
        this.iLoginModel = new LoginModel();
        this.iLoginView = iLoginView;
    }

    public void login(Context context){
        iLoginModel.login(context,iLoginView.getAccount(), iLoginView.getPassword(), new ILoginListener() {
            @Override
            public void loginSucceed() {
                iLoginView.loginSuccess();
            }

            @Override
            public void loginFailed() {

                iLoginView.loginFailed();
            }

            @Override
            public void loginEmpty() {
                iLoginView.loginEmpty();

            }
        });
    }

    public void logon(){
        iLoginModel.logon(iLoginView.getAccount(), iLoginView.getPassword(), new ILogonListener() {
            @Override
            public void logonSucceed() {
                iLoginView.logonSuccess();
            }

            @Override
            public void logonFailed() {
                iLoginView.logonFailed();
            }

            @Override
            public void logonEmpty() {
                iLoginView.logonEmpty();

            }
        });

    }

    public void checkChecked(final Context context){
        iLoginModel.checkChecked(context,iLoginView.getCheckBox(),iLoginView.getAccount(),iLoginView.getPassword());
    }

    public void restoreChecked(Context context){
        iLoginModel.restoreChecked(context, iLoginView.getAccount(), iLoginView.getCheckBox(), new IRestoreCheckListener() {
            @Override
            public void restoreCheckListener() {
                iLoginView.restoreCheckListener();
            }
        });

    }

    public void firstRun(Context context){
        iLoginModel.firstRun(context, new IFirstRunListener() {
            @Override
            public void firstRun() {
                iLoginView.firstRunToast();
            }
        });
    }
}
