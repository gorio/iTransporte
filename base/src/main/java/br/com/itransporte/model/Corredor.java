package br.com.itransporte.model;

import com.google.gson.annotations.SerializedName;

/**
 * A categoria Corredores possibilita uma consulta que retorna todos os corredores inteligentes da
 * cidade de São Paulo.
 */
public class Corredor {

    /**
     * Código identificador da corredor. Este é um código identificador único de cada corredor
     * inteligente do sistema
     */
    @SerializedName("cc")
    private Integer cc;

    /**
     * Nome do corredor
     */
    @SerializedName("nc")
    private String nc;

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }
}
