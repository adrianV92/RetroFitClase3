package pe.edu.cibertec.retrofitgitflow.presentation.main.presenter;

import java.util.List;

import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.main_interactor.IMainInteractor;
import pe.edu.cibertec.retrofitgitflow.presentation.main.IMainContract;

public class MainPresenter  implements IMainContract.IPresenter {

    IMainContract.IView view;
    IMainInteractor interactor;

    public MainPresenter(IMainInteractor interactor){
        this.interactor=interactor;
    }

    @Override
    public void attachView(IMainContract.IView view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        view =null;
    }

    @Override
    public boolean isViewAttached() {
        return view!=null;
    }

    @Override
    public void getAllPost() {
        view.showProgressBar();
        interactor.getAllPost(new IMainInteractor.MainCallBack() {
            @Override
            public void onSuccess(List<Post> postList) {
                if (isViewAttached()) {
                    view.hideProgressBar();
                    view.getAllPostSuccess(postList);
                }
            }

            @Override
            public void onError(String errorMsg) {
                if (isViewAttached()) {
                    view.hideProgressBar();
                    view.showError(errorMsg);
                }
            }
        });
        //acá usaremos un interceptor de la capa domain
    }
}