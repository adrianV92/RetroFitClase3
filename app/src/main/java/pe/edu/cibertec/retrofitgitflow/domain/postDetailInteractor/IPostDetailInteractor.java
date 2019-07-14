package pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IPostDetailInteractor {
    interface postDetailCallBack{
        void onSuccess(Post post);
        void onError(String errorMsg);
    }
    void getPost(postDetailCallBack callBack, int id);

}


