package com.lab4u.hannahchen.teacherlogin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
@TargetApi(11)
public class RegistrationActivity extends Activity implements RegistrationContract.View{
    private Button submitButton;
    private EditText first_name;
    private EditText last_name;
    private EditText email;
    private EditText password;
    private RadioGroup genderGrp;
    private RadioGroup typeGrp;
    private RegistrationPresenter presenter;
    private WebService mWebService;
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        submitButton = (Button) findViewById(R.id.submitButton);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        genderGrp = (RadioGroup) findViewById(R.id.genderGrp);
        typeGrp = (RadioGroup) findViewById(R.id.typeGrp);

        mWebService = ServiceGenerator.createService(WebService.class);
        sharedPref= getPreferences(Context.MODE_PRIVATE);
        //create the presenter
        presenter = new RegistrationPresenter(this, mWebService);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.initRegisterLab4UApplication();
                }
        });
    }

    //methods for the view
    @Override
    public void showInvalid(){
        Toast.makeText(getApplicationContext(), "Email address is invalid or already in use.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showRegistration(){
        password.setKeyListener(null);
        email.setKeyListener(null);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.registration_toast));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, Gravity.CENTER_HORIZONTAL,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public String getEmail(){
        return String.valueOf(((EditText)findViewById(R.id.email)).getText());
    }

    @Override
    public String getFirstName() {
        return String.valueOf(((EditText) findViewById(R.id.first_name)).getText());
    }

    @Override
    public String getLastName() {
        return String.valueOf(((EditText) findViewById(R.id.last_name)).getText());
    }

    /**
     * Shows a message to the user that the registration is complete
     * Redirects bck to the sign in activity
     */
    @Override
    public void onCompleteRegisterLoginLab4UApplication() {
        showRegistration();
        //change to a new blank window
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                fragmentTransaction.add(android.R.id.content, homeFragment);
                fragmentTransaction.commit();
            }
        }, 3000);
    }


    @Override
    public String getPassword(){
        return String.valueOf(((EditText)findViewById(R.id.password)).getText());
    }

    @Override
    public String getGender(){
        int selectedID = genderGrp.getCheckedRadioButtonId();
        Button radioBtn = (Button)(findViewById(selectedID));
        return radioBtn.getText().toString();

    }

    @Override
    public String getType() {
        int selectedID = typeGrp.getCheckedRadioButtonId();
        Button radioBtn = (Button)(findViewById(selectedID));
        return radioBtn.getText().toString();
    }

    @Override
    public void clearText(){
        email.setText("");
        password.setText("");
    }

    @Override
    public String getLanguage(){
        return Locale.getDefault().toString();
    }

    @Override
    public SharedPreferences getPreference(){
        return sharedPref;
    }

//    @Override
//    public goToHome(){
//
//    }
}
