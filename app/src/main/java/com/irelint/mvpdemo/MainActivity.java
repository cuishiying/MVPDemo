package com.irelint.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.irelint.mvpdemo.entity.PersonBean;
import com.irelint.mvpdemo.presenter.LoginPresenter;
import com.irelint.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    private static  final  String TAG="MVPTestActivity";

    private EditText ed_username;
    private EditText ed_password;
    private Button btn_login;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_username=(EditText)this.findViewById(R.id.ed_username);
        ed_password=(EditText)this.findViewById(R.id.ed_password);
        btn_login=(Button)this.findViewById(R.id.btn_login);
        mLoginPresenter=new LoginPresenter(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.loginSystem();

            }
        });
    }
    /**
     * 进行返回用户名信息
     * @return
     */
    @Override
    public String getUserName() {
        return ed_username.getText().toString().trim();
    }
    /**
     * 进行返回用户密码信息
     * @return
     */
    @Override
    public String getPassword() {
        return ed_password.getText().toString().trim();
    }
    /**
     * 登录成功 回调
     * @param personBean
     */
    @Override
    public void showSuccessInfo(PersonBean personBean) {
        Log.d(TAG,"showSuccessInfo:"+personBean.toString());
    }
    /**
     * 登录失败 回调
     */
    @Override
    public void showFailedInfo() {
        Log.d(TAG,"showFailedInfo...");
    }
}
