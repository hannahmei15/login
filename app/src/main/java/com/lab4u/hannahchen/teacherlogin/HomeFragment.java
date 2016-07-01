package com.lab4u.hannahchen.teacherlogin;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by hannahchen on 6/30/16.
 */
@TargetApi(11)
public class HomeFragment extends Fragment{
    private WebService mWebService;
    private SharedPreferences sharedPref;
    private Button successButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.home_fragment, container, false);
        successButton = (Button) inflatedView.findViewById(R.id.successButton);
        sharedPref= getActivity().getPreferences(Context.MODE_PRIVATE);
        String accessToken = sharedPref.getString("AccessToken", "None");
        Log.d("HomeFragment", accessToken);
        mWebService = ServiceGenerator.createService(WebService.class, accessToken);

        successButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWebService.getResponse(new Callback<ExampleResponse>() {
                    @Override
                    public void success(ExampleResponse exampleResponse, Response response) {
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        return inflatedView;



    }
}
