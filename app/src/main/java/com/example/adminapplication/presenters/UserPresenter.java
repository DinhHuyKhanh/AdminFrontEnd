package com.example.adminapplication.presenters;

import com.example.adminapplication.models.request.ChangePasswordRequest;
import com.example.adminapplication.models.request.CreateUserRequest;
import com.example.adminapplication.models.request.UserRequest;
import com.example.adminapplication.models.response.BaseResponse;
import com.example.adminapplication.services.APIService;
import com.example.adminapplication.views.ResponseView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements IUserPresenter {
    private ResponseView responseView;

    public UserPresenter(ResponseView responseView){
        this.responseView = responseView;
    }


    @Override
    public void login(UserRequest userRequest) {
        APIService.apiService.login(userRequest).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if(response.body() != null){
                    responseView.onComplete(response.body());
                }else{
                    responseView.onError("null");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                responseView.onError(t.getMessage());
            }

        });
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        APIService.apiService.createUser(createUserRequest).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if(response.body() != null){
                    responseView.onComplete(response.body());
                }else{
                    responseView.onError("null");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                responseView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getAllUser() {
        APIService.apiService.getAllUser().enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if(response.body() != null){
                    responseView.onComplete(response.body());
                }else{
                    responseView.onError("null");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                responseView.onError(t.getMessage());
            }
        });
    }

    @Override
    public void changePassword(int id, ChangePasswordRequest changePasswordRequest) {
        APIService.apiService.changePassword(id,changePasswordRequest).enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if(response.body() != null){
                    responseView.onComplete(response.body());
                }else{
                    responseView.onError("null");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                responseView.onError(t.getMessage());
            }
        });
    }
}
