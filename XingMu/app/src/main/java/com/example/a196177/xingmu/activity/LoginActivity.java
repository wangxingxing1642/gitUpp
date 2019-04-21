package com.example.a196177.xingmu.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.a196177.xingmu.R;
import com.example.a196177.xingmu.base.BaseActivity;
import com.example.a196177.xingmu.presenter.LoginPresenter;
import com.example.a196177.xingmu.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.password)
    EditText mPassword;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.btn})
    protected void onClick(View view) {
        mPresenter.login();
    }

    @Override
    public String getUserName() {
        return mUsername.getText().toString().trim();
    }

    @Override
    public String getPsw() {
        return mPassword.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
