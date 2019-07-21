package pe.edu.cibertec.retrofitgitflow.domain.comment_interactor;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Comment;

public interface ICommentInteractor {
    interface commentCallBack{
        void onSuccess(List<Comment> commentList);
        void onError(String errorMsg);
    }
    void getPost(commentCallBack callBack, int id);
}
