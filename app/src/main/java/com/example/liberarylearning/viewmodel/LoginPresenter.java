package com.example.liberarylearning.viewmodel;

import android.content.Context;

import com.example.liberarylearning.model.ICheckCheckedListener;
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

    public void checkChecked(final boolean ifChecked){

        iLoginModel.checkChecked(ifChecked,new ICheckCheckedListener() {
            @Override
            public void isChecked() {

            }

            @Override
            public void noChecked() {

            }
        });
    }

    public void restoreChecked(boolean ifRestoreChecked){

        iLoginModel.restoreChecked(ifRestoreChecked, new IRestoreCheckListener() {
            @Override
            public void isRestoreCheck() {
                iLoginView.isRestoreCheck();
            }

            @Override
            public void noRestoreCheck() {
                iLoginView.noRestoreCheck();
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
