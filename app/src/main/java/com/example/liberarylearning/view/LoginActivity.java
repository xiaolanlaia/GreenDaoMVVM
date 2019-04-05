package com.example.liberarylearning.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.example.liberarylearning.R;
import com.example.liberarylearning.databinding.LoginBinding;
import com.example.liberarylearning.viewmodel.LoginPresenter;


/**
 * Created by W on 2019/2/12.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,ILoginView{



    private CheckBox checkBox;
    public static String account;
    private LoginPresenter loginPresenter = new LoginPresenter(this);
    private LoginBinding loginBinding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstance){

        super.onCreate(savedInstance);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.login);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sharedPreferences = getSharedPreferences("checked",0);
        loginBinding.setOnClickListener(this);
        checkBox = (CheckBox)findViewById(R.id.check_box);
        firstRun();
        checkChecked();
        restoreChecked();

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.logon: {
                loginPresenter.logon();
                break;
            }
            case R.id.login:{
                loginPresenter.login(LoginActivity.this);
                break;
            }
            default:
                break;
        }
    }





    @Override
    public void checkChecked(){
        loginPresenter.checkChecked(LoginActivity.this);
    }
    @Override
    public void restoreChecked(){
        loginPresenter.restoreChecked(LoginActivity.this);
    }
    @Override
    public void firstRun() {
        loginPresenter.firstRun(LoginActivity.this);

    }
    @Override
    public void loginFailed(){
        Toast.makeText(this,"账号或密码错误", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginSuccess(){
        //account为全局变量，在答题界面中作为SharedPreference缓存名称的一部分;
        account =loginBinding.getUsername();
        sharedPreferences = getSharedPreferences("checked",0);
        sharedPreferences.edit().putString("account",getAccount()).apply();
        sharedPreferences.edit().putString("password",getPassword()).apply();

        Intent intent = new Intent(LoginActivity.this,QuestionListActivity.class);
        startActivity(intent);
    }
    @Override
    public void loginEmpty(){
        Toast.makeText(this,"账号密码不能为空", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logonFailed(){
        Toast.makeText(this,"账号已存在", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logonSuccess(){
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logonEmpty(){
        Toast.makeText(this,"账号密码不能为空", Toast.LENGTH_SHORT).show();
    }
    @Override
    public String getAccount(){
        return loginBinding.getUsername();
    }
    @Override
    public String getPassword(){
        return loginBinding.getPassword();
    }
    @Override
    public CheckBox getCheckBox(){
        return checkBox;
    }

    @Override
    public void restoreCheckListener(){
        loginBinding.setUsername(sharedPreferences.getString("account",""));
        loginBinding.setPassword(sharedPreferences.getString("password",""));

    }


    @Override
    public void firstRunToast(){
        Toast.makeText(this,"欢迎", Toast.LENGTH_SHORT).show();
    }

}