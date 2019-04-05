package com.example.liberarylearning.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


import com.example.liberarylearning.MyApplication;
import com.example.liberarylearning.bean.User;

import com.example.liberarylearning.greenDao.DaoSession;


import java.util.List;


public class LoginModel implements ILoginModel{

    private DaoSession daoSession = ((MyApplication) MyApplication.getApplication()).getDaoSession();

    @Override
    public void login(Context context, final String account, final String password, final ILoginListener iLoginListener){

        if (TextUtils.isEmpty(account)|| TextUtils.isEmpty(password)){
            iLoginListener.loginEmpty();
        }else {
            List<User> list= daoSession.loadAll(User.class);
            int i = 1;
            for (User user : list){
                if (user.getAccount().equals(account) && user.getPassword().equals(password)){
                    iLoginListener.loginSucceed();
                    break;
                }
                if (list.size() == i){
                    iLoginListener.loginFailed();
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public void logon(final String account, final String password, ILogonListener iLogonListener){
        if (TextUtils.isEmpty(account)|| TextUtils.isEmpty(password)){
            iLogonListener.logonEmpty();
        }else {
            List<User> list= daoSession.loadAll(User.class);
            int i = 1;
            for (User user : list){
                if (account.equals(user.getAccount())){
                    iLogonListener.logonFailed();
                    break;
                }else if (i >= list.size()){
                    User user1 = new User();
                    user1.setAccount(account);
                    user1.setPassword(password);
                    daoSession.insertOrReplace(user1);
                    iLogonListener.logonSucceed();
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public void checkChecked(final boolean ifChecked,ICheckCheckedListener iCheckCheckedListener){
        if (ifChecked){
            iCheckCheckedListener.isChecked();
        }else {
            iCheckCheckedListener.noChecked();
        }
    }
    @Override
    public void restoreChecked(boolean ifRestoreChecked, IRestoreCheckListener iRestoreCheckListener){
        if (ifRestoreChecked){
            iRestoreCheckListener.isRestoreCheck();
        }else {
            iRestoreCheckListener.noRestoreCheck();
        }
    }

    @Override
    public void firstRun(Context context, IFirstRunListener iFirstRunListener){
        SharedPreferences sharedPreferences =  context.getSharedPreferences("FirstRun", 0);
        Boolean firstRun = sharedPreferences.getBoolean("First", true);
        if (firstRun) {
            sharedPreferences.edit().putBoolean("First", false).apply();
            User user = new User();
            user.setAccount("admin");
            user.setPassword("123456");
            daoSession.insertOrReplace(user);
            iFirstRunListener.firstRun();
        }
    }
}
