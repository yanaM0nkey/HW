package com.gmail.ioanna.myandroidapp.classwork21;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.classwork9.Classwork9Activity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz111Binding;
import com.gmail.ioanna.myandroidapp.dz11.Dz11_1Activity;
import com.gmail.ioanna.myandroidapp.dz11.Dz11_1ViewModel;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterBasePresenter presenter;

    private ProgressBar progressBar;
    private Button registerButton;


    public static void show(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork21);

        presenter = new RegisterPresenter(this);

        progressBar = (ProgressBar)findViewById(R.id.progressBar21);
        registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onRegisterButtonClick("username", "password");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();;

    }

    @Override
    public void goToMainActivity() {
        //для примера переход на какую-нибудь activity
        Classwork9Activity.show(this);

    }
}
