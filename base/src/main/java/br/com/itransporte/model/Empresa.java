package br.com.itransporte.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A categoria Empresas possibilita uma consulta que retorna a relação das empresas operadoras do
 * transporte público na cidade de São Paulo.
 */
public class Empresa {

    /**
     * Horário de referência da geração das informações
     */
    @SerializedName("hr")
    private String hr;

    /**
     * Relação de empresas por área de operação
     */
    @SerializedName("e")
    private List<E> e = null;

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public List<E> getE() {
        return e;
    }

    public void setE(List<E> e) {
        this.e = e;
    }

    public class E {

        /**
         * Código da área de operação
         */
        @SerializedName("a")
        private Integer a;

        /**
         *  Relação de empresas
         */
        @SerializedName("e")
        private List<E_> e = null;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public List<E_> getE() {
            return e;
        }

        public void setE(List<E_> e) {
            this.e = e;
        }

    }

    public class E_ {

        /**
         * Código da área de operação
         */
        @SerializedName("a")
        private Integer a;

        /**
         * Código de referência da empresa
         */
        @SerializedName("c")
        private Integer c;

        /**
         * Nome da empresa
         */
        @SerializedName("n")
        private String n;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getC() {
            return c;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

    }
}
