package pe.edu.cibertec.retrofitgitflow.domain.comment_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comment;
import pe.edu.cibertec.retrofitgitflow.network.ApiClient;
import pe.edu.cibertec.retrofitgitflow.network.JsonPlaceHolderApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentInteractorImpl implements ICommentInteractor {
    @Override
    public void getPost(commentCallBack callBack, int id) {
        JsonPlaceHolderApi jsonPlaceHolderApi= ApiClient.getClient().create(JsonPlaceHolderApi.class) ;
        Call<List<Comment>> call = jsonPlaceHolderApi.getComments();

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    callBack.onError("Code: "+response.code());
                } else {
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });
    }
}
