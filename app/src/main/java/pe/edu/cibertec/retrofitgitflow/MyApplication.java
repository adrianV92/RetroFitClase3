package pe.edu.cibertec.retrofitgitflow;

import android.app.Application;

import pe.edu.cibertec.retrofitgitflow.di.component.DaggerIPresentationComponent;
import pe.edu.cibertec.retrofitgitflow.di.component.IPresentationComponent;
import pe.edu.cibertec.retrofitgitflow.di.module.PresentationModule;

public class MyApplication extends Application {
    private IPresentationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inicializarComponent();
    }

    void inicializarComponent(){
        appComponent= DaggerIPresentationComponent.builder().presentationModule(new PresentationModule()).build();
    }

    public IPresentationComponent getAppComponent(){
        return appComponent;
    }
}
