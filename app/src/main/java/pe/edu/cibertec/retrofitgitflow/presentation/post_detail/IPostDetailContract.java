package pe.edu.cibertec.retrofitgitflow.presentation.post_detail;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;

public interface IPostDetailContract {
    interface IView{
        void showError(String errorMsg);
        void showProgressBar();
        void hideProgressBar();
        void getPostSuccess(Post post);
    }
    interface IPresenter{
        void attachView(IView view);
        void detachView();
        boolean isViewAttached();
        void getPost(int id);
    }
}
