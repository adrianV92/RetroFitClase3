package pe.edu.cibertec.retrofitgitflow.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL="http://jsonplaceholder.typicode.com";
    public static Retrofit retrofit=null;

    public static Retrofit getClient(){
        HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client= new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();
        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
