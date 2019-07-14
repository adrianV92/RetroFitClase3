package pe.edu.cibertec.retrofitgitflow.presentation.post_detail.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import pe.edu.cibertec.retrofitgitflow.R;
import pe.edu.cibertec.retrofitgitflow.data.entities.Post;
import pe.edu.cibertec.retrofitgitflow.domain.postDetailInteractor.PostDetailInteractorImpl;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.IPostDetailContract;
import pe.edu.cibertec.retrofitgitflow.presentation.post_detail.presenter.PostDetailPresenter;

public class PostDetailActivity extends AppCompatActivity implements IPostDetailContract.IView {
    TextView tvTitleDetail;
    TextView tvBodyDetail;
    PostDetailPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        tvTitleDetail= findViewById(R.id.tvTitleDetail);
        tvBodyDetail= findViewById(R.id.tvBodyDetail);
        presenter= new PostDetailPresenter(new PostDetailInteractorImpl());
        presenter.attachView(this);

        int id= getIntent().getIntExtra("post_id",0);
        presenter.getPost(id);
    }

    @Override
    public void showError(String errorMsg) {
        tvTitleDetail.setText("ERROR");
        tvBodyDetail.setText(errorMsg);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void getPostSuccess(Post post) {
        tvTitleDetail.setText(post.getTitle());
        tvBodyDetail.setText(post.getText());
    }
}
