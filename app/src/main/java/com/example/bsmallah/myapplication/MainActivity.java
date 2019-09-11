package com.example.bsmallah.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bsmallah.myapplication.Retrofit.RetrofitWebService;
import com.example.bsmallah.myapplication.fragments.fragment1;
import com.example.bsmallah.myapplication.fragments.fragment2;
import com.example.bsmallah.myapplication.fragments.fragment3;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BottomNavigationView bottomNavigationView;
    private FrameLayout container1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        container1 = findViewById(R.id.frame_container);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);

        textView =
                findViewById(R.id.text_xml);

        CreatPost(new Post(1,"ji is bad boy","ji"));

    }

    private void CreatPost(Post post){

        String BaseUrl = "https://jsonplaceholder.typicode.com/";

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitWebService webService
                = retrofit.create(RetrofitWebService.class);

        webService.CreatPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, retrofit2.Response<Post> response) {
             textView.setText(response.body().getId()+" is id");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText("failed");
            }
        });

    }

    private void UpdatePost(Post post){

        String BaseUrl = "https://jsonplaceholder.typicode.com/";

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RetrofitWebService webService
                = retrofit.create(RetrofitWebService.class);

        webService.UpdatePost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, retrofit2.Response<Post> response) {
                textView.setText(response.body().getId()+" is id");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textView.setText("failed");
            }
        });

    }

    private void createNewUser(Employe employe) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
       String BaseUrl = "http://dummy.restapiexample.com/api/v1/";

       Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create());

       Retrofit retrofit = builder.build();

       RetrofitWebService webService
               = retrofit.create(RetrofitWebService.class);

       webService.CreatEmployee(employe).enqueue(new Callback<Employe>() {
           @Override
           public void onResponse(Call<Employe> call, retrofit2.Response<Employe> response) {
              Employe employe1 = response.body();
              textView.setText(employe1.getId());
           }

           @Override
           public void onFailure(Call<Employe> call, Throwable t) {
               textView.setText("failed"+t.getLocalizedMessage());
           }
       });

    }

    private void getEmployeUsingRetrofit() {
      String BaseUrl = "http://dummy.restapiexample.com/api/v1/";

      Retrofit.Builder builder = new Retrofit.Builder()
              .baseUrl(BaseUrl)
              .addConverterFactory(GsonConverterFactory.create());

      Retrofit retrofit = builder.build();
      RetrofitWebService retrofitWebService = retrofit.create(RetrofitWebService.class);

      retrofitWebService.GetEmploye(153351).enqueue(new Callback<Employe>() {
          @Override
          public void onResponse(Call<Employe> call, retrofit2.Response<Employe> response) {
              Employe e = response.body();
              textView.setText(e.getEmployee_name());
          }

          @Override
          public void onFailure(Call<Employe> call, Throwable t) {

          }
      });


    }

    private void getListOfEmployeeUsingRetrofit() {
        String BaseUrl="http://dummy.restapiexample.com/api/v1/";
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        RetrofitWebService retrofitWebService = retrofit.create(RetrofitWebService.class);

       Call<List<Employe>> call =  retrofitWebService.GetEmployesList();
       call.enqueue(new Callback<List<Employe>>() {
           @Override
           public void onResponse(Call<List<Employe>> call, retrofit2.Response<List<Employe>> response) {
               List<Employe> result = response.body();
               String text="";
               for (int i=0;i<result.size();i++)
               {
                   text+=result.get(i).getEmployee_name()+"  ";
               }
               textView.setText(text);
           }

           @Override
           public void onFailure(Call<List<Employe>> call, Throwable t) {

           }
       });


    }

    private void getDataUsingRetrofit() {

        //creat buillder;
       Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create());

        //creat retrofit
       Retrofit retrofit = builder.build();

       RetrofitWebService retrofitWebService = retrofit.create(RetrofitWebService.class);
       Call<List<Comment>> call = retrofitWebService.GetCommentsForUser(1);
       call.enqueue(new Callback<List<Comment>>() {
           @Override
           public void onResponse(Call<List<Comment>> call, retrofit2.Response<List<Comment>> response) {
             List<Comment> result = response.body();
             String text="";
             for (int i=0;i<result.size();i++)
             {
                     text+=result.get(i).getId();
             }
             textView.setText(text);
           }

           @Override
           public void onFailure(Call<List<Comment>> call, Throwable t) {
             textView.setText("fail");
           }
       });

    }


    void LoadDataUsingVolley(){
        String link = "https://jsonplaceholder.typicode.com/users";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, link
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    void LoadData() {
       new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InputStream stream = null;
                     String link = "https://jsonplaceholder.typicode.com/users";
                     // http://developerhendy.16mb.com/getposts.php
                     // String link = "http://developerhendy.16mb.com/getposts.php";

                    URL url = new URL(link);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    stream = httpURLConnection.getInputStream();
                    StringBuffer text = new StringBuffer();
                    int c;
                    while ((c = stream.read()) != -1) {
                        text.append((char) c);
                    }
                    final String result = text.toString();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(result);
                        }
                    });
                }catch (IOException e){
                    Log.e(TAG, "run: "+e.getLocalizedMessage());
                }

            }
        }).start();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.isChecked())
                    {
                        Log.d(TAG, "onNavigationItemSelected return: ");
                        return false;
                    }
                    Fragment selected=null;
                    switch (item.getItemId()){
                        case R.id.first:
                            selected = new fragment1();
                            break;
                        case R.id.second:
                            selected = new fragment2();
                            break;
                        case R.id.third:
                            selected = new fragment3();
                            break;
                    }
                   getSupportFragmentManager().beginTransaction().replace(container1.getId(),selected).commit();
                   return true;
                }
            };
}
