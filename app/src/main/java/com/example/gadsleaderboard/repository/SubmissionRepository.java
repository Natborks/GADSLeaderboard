package com.example.gadsleaderboard.repository;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gadsleaderboard.Network.LeadersInterface;
import com.example.gadsleaderboard.models.FormEntry;
import com.example.gadsleaderboard.util.DialogUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.gadsleaderboard.Network.ApiClient.BASE_URL;

public class SubmissionRepository {

    Application mContext;

    public SubmissionRepository(Application context) {
        mContext = context;
    }

    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public MutableLiveData<FormEntry> saveGitHubLink(String firstName, String lastName,
                                   String email, String link){

        final MutableLiveData<FormEntry> data = new MutableLiveData();
        final String[] result = {""};

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

//        builder.addInterceptor(new UnauthorisedInterceptor(context));
        OkHttpClient client = builder.build();

        LeadersInterface leadersInterface = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .build()
                .create(LeadersInterface.class);

        Call<ResponseBody> call = leadersInterface.saveLink(firstName, lastName,
                email, link);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful())
                    data.setValue(new FormEntry("ok"));
                else
                    data.setValue(new FormEntry("failed"));;
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                data.setValue(new FormEntry(t));
            }
        });

        return data;
    }
}
