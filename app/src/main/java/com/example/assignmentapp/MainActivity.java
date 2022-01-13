package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.assignmentapp.adapter.AllCategoryAdapter;
import com.example.assignmentapp.databinding.ActivityMainBinding;
import com.example.assignmentapp.model.CategoryResponseModel;
import com.example.assignmentapp.model.Class;
import com.example.assignmentapp.model.Datum;
import com.example.assignmentapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    AllCategoryAdapter adapter;
    String token;
    CategoryResponseModel categoryResponseModel;
    List<Datum> categoryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        SharedPreferences sharedPreferences = getSharedPreferences("tokenSharedPref", MODE_PRIVATE);
        token = sharedPreferences.getString("bearerToken", "");
        getCategoryResponse(token);

    }


    private void getCategoryResponse(String token) {

        Call<CategoryResponseModel> call = RetrofitClient
                .getInstance()
                .getApi()
                .getCategoryList("Bearer "+ token);

        call.enqueue(new Callback<CategoryResponseModel>() {
            @Override
            public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {
                if (response.isSuccessful()){

                    categoryResponseModel = response.body();
                    categoryData = categoryResponseModel.getData();
                    setAdapter(categoryData);


                }
                else {

                }
            }

            @Override
            public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void setAdapter(List<Datum> categoryData) {
        adapter = new AllCategoryAdapter(this, categoryData);
        mainBinding.mainRecyclerViewId.setAdapter(adapter);
    }

}