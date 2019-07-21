package pe.edu.cibertec.retrofitgitflow.di.module;

import dagger.Module;
import dagger.Provides;
import pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor.IPostDetailInteractor;
import pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor.PostDetailInteractorImpl;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostDetailPresenter;

@Module
public class PostDetailModule {
    @Provides
    IPostDetailInteractor providesPostDetailInteractor(){
        return new PostDetailInteractorImpl();
    }
}
