package pe.edu.cibertec.retrofitgitflow.di.component;

import dagger.Component;
import pe.edu.cibertec.retrofitgitflow.di.module.PostDetailModule;
import pe.edu.cibertec.retrofitgitflow.di.module.PresentationModule;
import pe.edu.cibertec.retrofitgitflow.presentation.main.view.MainActivity;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.view.PostDetailActivity;

@Component(modules= {PresentationModule.class,
        PostDetailModule.class})
public interface IPresentationComponent {
    void inject(MainActivity mainActivity);
    void inject(PostDetailActivity postDetailActivity);
}
