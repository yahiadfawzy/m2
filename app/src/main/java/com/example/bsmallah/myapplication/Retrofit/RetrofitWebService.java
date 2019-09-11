package com.example.bsmallah.myapplication.Retrofit;

import com.example.bsmallah.myapplication.Comment;
import com.example.bsmallah.myapplication.Employe;
import com.example.bsmallah.myapplication.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetrofitWebService {

    @GET("posts/{user_id}/comments")
    Call<List<Comment>> GetCommentsForUser(@Path("user_id") int userid);

    @PUT("posts/1")
    Call<Post> UpdatePost(@Body Post _post);

    @POST("posts")
    Call<Post> CreatPost(@Body Post _post);

    @GET("employees")
    Call<List<Employe>> GetEmployesList();

    @GET("employee/{id}")
    Call<Employe> GetEmploye(@Path("id") int id);

    @POST("create")
    Call<Employe> CreatEmployee(@Body Employe employe);

    @GET("posts")
    Call<List<Post>> GetPostList();


}
