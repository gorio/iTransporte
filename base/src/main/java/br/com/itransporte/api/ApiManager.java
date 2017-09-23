package br.com.itransporte.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.itransporte.model.Corredor;
import br.com.itransporte.model.Empresa;
import br.com.itransporte.model.Linha;
import br.com.itransporte.model.Parada;
import br.com.itransporte.model.Posicao;
import br.com.itransporte.model.Previsao;
import br.com.itransporte.utils.Utils;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class ApiManager {

    public final static String BASE_URL = "http://api.olhovivo.sptrans.com.br";
    private static ApiManager instance = null;
    private ApiModule apiModule;

    public interface ApiModule {
        /**
         * Autenticação com API da SPTrans
         *
         * @param token Sua chave de acesso que deve ser gerada na área "Meus Aplicativos".
         *              Para mais informações {@link <a href="http://www.sptrans.com.br/desenvolvedores/APIOlhoVivo/Documentacao.aspx">veja como acessar seu perfil</a>}.
         * @return true / false
         */
        @POST("/v2.1/Login/Autenticar")
        Call<Boolean> authenticator(@Query("token") String token);

        /**
         * Realiza uma busca das linhas do sistema com base no parâmetro informado. Se a linha não é
         * encontrada então é realizada uma busca fonetizada na denominação das linhas.
         *
         * @param termosBusca Aceita denominação ou número da linha (total ou parcial).
         *                    Exemplo: 8000, Lapa ou Ramos
         * @return Lista de linhas
         */
        @GET("/v2.1/Linha/Buscar")
        Call<List<Linha>> getLinhas(@Query("termosBusca") String termosBusca);

        /**
         * Realiza uma busca das linhas do sistema com base no parâmetro informado. Se a linha não é
         * encontrada então é realizada uma busca fonetizada na denominação das linhas. A linha
         * retornada será unicamente aquela cujo sentido de operação seja o informado no parâmetro
         * sentido
         *
         * @param termosBusca Aceita denominação ou número da linha (total ou parcial).
         *                    Exemplo: 8000, Lapa ou Ramos
         * @param sentido     Código identificador do sentido de operação da linha, onde:
         *                    1: Terminal Principal para Terminal Secundário
         *                    2: para Terminal Secundário para Terminal Principal
         * @return Lista de linhas
         */
        @GET("/v2.1/Linha/BuscarLinhaSentido")
        Call<List<Linha>> getLinhas(@Query("termosBusca") String termosBusca,
                                    @Query("sentido") String sentido);

        /**
         * Realiza uma busca fonética das paradas de ônibus do sistema com base no parâmetro informado.
         * A consulta é realizada no nome da parada e também no seu endereço de localização.
         *
         * @param termosBusca Aceita nome da parada ou endereço de localização (total ou parcial).
         *                    Exemplo: Afonso, ou Balthazar da Veiga
         * @return Lista de paradas
         */
        @GET("/v2.1/Parada/Buscar")
        Call<List<Parada>> getParadas(@Query("termosBusca") String termosBusca);


        /**
         * Realiza uma busca por todos os pontos de parada atendidos por uma determinada linha.
         *
         * @param codigoLinha Código identificador da linha. Este é um código identificador único de
         *                    cada linha do sistema (por sentido) e pode ser obtido através do método
         *                    BUSCAR da categoria Linhas
         * @return Lista de paradas
         */
        @GET("/v2.1/Parada/BuscarParadasPorLinha")
        Call<List<Parada>> getParadasPorLinha(@Query("codigoLinha") Integer codigoLinha);


        /**
         * Retorna a lista detalhada de todas as paradas que compõem um determinado corredor.
         *
         * @param codigoCorredor Código identificador do corredor. Este é um código identificador único
         *                       de cada corredor do sistema e pode ser obtido através do método GET da
         *                       categoria Corredores
         * @return Lista de paradas
         */
        @GET("/v2.1/Parada/BuscarParadasPorCorredor")
        Call<List<Parada>> getParadasPorCorredor(@Query("codigoCorredor") Integer codigoCorredor);

        /**
         * Retorna uma lista com todos os corredores inteligentes
         *
         * @return Lista de corredores
         */
        @GET("/v2.1/Corredor")
        Call<List<Corredor>> getCorredor();

        /**
         * Retorna uma lista com todos as empresas operadoras relacionadas por área de operação
         *
         * @return Lista de empresas
         */
        @GET("/v2.1/Empresa")
        Call<List<Empresa>> getEmpresa();

        /**
         * Retorna uma lista completa com a última localização de todos os veículos mapeados com suas
         * devidas posições
         *
         * @return Lista de posições
         */
        @GET("/v2.1/Posicao")
        Call<Posicao> getPosicao();

        /**
         * Retorna uma lista com todos os veículos de uma determinada linha com suas devidas posições
         *
         * @param codigoLinha Código identificador da linha. Este é um código identificador único de
         *                    cada linha do sistema (por sentido) e pode ser obtido através do método
         *                    BUSCAR da categoria Linhas
         * @return Lista de posições
         */
        @GET("/v2.1/Posicao/Linha")
        Call<List<Posicao>> getPosicao(@Query("codigoLinha") String codigoLinha);

        /**
         * Retorna uma lista completa todos os veículos mapeados que estejam transmitindo em uma garagem
         * da empresa informada
         *
         * @param codigoEmpresa Código identificador da empresa. Este é um código identificador único
         *                      que pode ser obtido através do método GET da categoria Empresas
         * @return Lista de posições
         */
        @GET("/v2.1/Posicao/Garagem")
        Call<List<Posicao>> getPosicao(@Query("codigoEmpresa") Integer codigoEmpresa);

        /**
         * Retorna uma lista completa todos os veículos mapeados que estejam transmitindo em uma garagem
         * da empresa informada
         *
         * @param codigoEmpresa Código identificador da empresa. Este é um código identificador único
         *                      que pode ser obtido através do método GET da categoria Empresas
         * @param codigoLinha   Código identificador da linha. Este é um código identificador único de
         *                      cada linha do sistema (por sentido) e pode ser obtido através do método
         *                      BUSCAR da categoria Linhas
         * @return Lista de posições
         */
        @GET("/v2.1/Posicao/Garagem")
        Call<List<Posicao>> getPosicao(@Query("codigoEmpresa") Integer codigoEmpresa,
                                       @Query("codigoLinha") Integer codigoLinha);

        /**
         * Retorna uma lista com a previsão de chegada dos veículos da linha informada que atende ao
         * ponto de parada informado
         *
         * @param codigoParada Código identificador da parada. Este é um código identificador único de
         *                     cada ponto de parada do sistema (por sentido) e pode ser obtido através
         *                     do método BUSCAR da categoria Paradas
         * @param codigoLinha  Código identificador da linha. Este é um código identificador único de
         *                     cada linha do sistema (por sentido) e pode ser obtido através do método
         *                     BUSCAR da categoria Linhas
         * @return Lista de previsões
         */
        @GET("/v2.1/Previsao")
        Call<List<Previsao>> getPrevisao(@Query("codigoParada") Integer codigoParada,
                                         @Query("codigoLinha") Integer codigoLinha);


        /**
         * Retorna uma lista com a previsão de chegada de cada um dos veículos da linha informada em
         * todos os pontos de parada aos quais que ela atende
         *
         * @param codigoLinha Código identificador da linha. Este é um código identificador único de
         *                    cada linha do sistema (por sentido) e pode ser obtido através do método
         *                    BUSCAR da categoria Linhas
         * @return Lista de previsões
         */
        @GET("/v2.1/Previsao/Linha")
        Call<List<Previsao>> getPrevisaoLinha(@Query("codigoLinha") Integer codigoLinha);

        /**
         * Retorna uma lista com a previsão de chegada dos veículos de cada uma das linhas que atendem
         * ao ponto de parada informado
         *
         * @param codigoParada Código identificador da parada. Este é um código identificador único de
         *                     cada ponto de parada do sistema (por sentido) e pode ser obtido através
         *                     do método BUSCAR da categoria Paradas
         * @return Lista de previsões
         */
        @GET("/v2.1/Previsao/Parada")
        Call<List<Previsao>> getPrevisaoParada(@Query("codigoParada") Integer codigoParada);
    }

    private static Map<String, String> headers = new HashMap<>();

    public static void setHeaders(Map<String, String> headers) {
        ApiManager.headers = headers;
    }

    private ApiManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Utils.getUnsafeOkHttpClient())
                .build();

        apiModule = retrofit.create(ApiModule.class);
    }


    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }


    public ApiModule getService() {
        return apiModule;
    }
}