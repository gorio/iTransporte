package br.com.itransporte.linha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import br.com.itransporte.api.ApiManager;
import br.com.itransporte.model.Linha;
import br.com.itransporte.model.Posicao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autenticar();
    }

    private void autenticar() {
        Call<Boolean> authenticate = ApiManager.getInstance().getService().authenticator("f7964a3de145a36a468458f74fae5a5fa3a6aa1fb8c291639160add6770956a3");

        authenticate.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response != null) {

                    if (response.body() != null) {
                        try {
                            Boolean resp = response.body();

                            if (resp) {
                                getLinhas();
                                getPosicoes();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getLinhas() {
        Call<List<Linha>> getlinha = ApiManager.getInstance().getService().getLinhas("857R");

        getlinha.enqueue(new Callback<List<Linha>>() {

            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if (response != null) {

                    if (response.body() != null) {
                        try {
                            List<Linha> resp = response.body();

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getPosicoes() {
        Call<Posicao> getposicao = ApiManager.getInstance().getService().getPosicao();

        getposicao.enqueue(new Callback<Posicao>() {

            @Override
            public void onResponse(Call<Posicao> call, Response<Posicao> response) {
                if (response != null) {

                    if (response.body() != null) {
                        try {
                            Posicao resp = response.body();
                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Posicao> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
