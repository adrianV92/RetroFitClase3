package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter;

import javax.inject.Inject;


import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor.IPostDetailInteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;

public class PostDetailPresenter implements IPostDetailContract.IPresenter {
    IPostDetailInteractor interactor;
    IPostDetailContract.IView view;

    @Inject
    public PostDetailPresenter(IPostDetailInteractor interactor){
        this.interactor=interactor;
    }

    @Override
    public void attachView(IPostDetailContract.IView view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        this.view=null;
    }

    @Override
    public boolean isViewAttached() {
        return view!=null;
    }

    @Override
    public void getPost(int id) {
        view.showProgressBar();
        interactor.getPost(new IPostDetailInteractor.postDetailCallBack() {
            @Override
            public void onSuccess(Post post) {
                if (isViewAttached()) {
                    view.hideProgressBar();
                    view.getPostSuccess(post);
                }
            }

            @Override
            public void onError(String errorMsg) {
                if (isViewAttached()) {
                    view.hideProgressBar();
                    view.showError(errorMsg);
                }
            }
        }, id);
    }
}
