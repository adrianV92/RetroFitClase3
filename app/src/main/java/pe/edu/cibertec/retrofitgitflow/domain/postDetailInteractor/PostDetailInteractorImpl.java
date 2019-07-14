package pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.network.ApiClient;
import pe.edu.cibertec.retrofitgitflow.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailInteractorImpl implements IPostDetailInteractor {

    @Override
    public void getPost(postDetailCallBack callBack, int id) {
        JsonPlaceHolderApi jsonPlaceHolderApi= ApiClient.getClient().create(JsonPlaceHolderApi.class) ;
        Call<Post> call = jsonPlaceHolderApi.getPostId(id);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code: "+response.code());
                } else {
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
