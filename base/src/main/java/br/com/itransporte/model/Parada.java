package br.com.itransporte.model;

import com.google.gson.annotations.SerializedName;

/**
 * A categoria Paradas possibilita a consulta pelos pontos de parada da cidade de São Paulo.
 * Atualmente esta categoria contempla apenas as paradas de corredores.
 */
public class Parada {

    /**
     * Código identificador da parada
     */
    @SerializedName("cp")
    private Integer cp;

    /**
     * Nome da parada
     */
    @SerializedName("np")
    private String np;

    /**
     *  Endereço de localização da parada
     */
    @SerializedName("ed")
    private String ed;

    /**
     * Informação de latitude da localização da parada
     */
    @SerializedName("py")
    private Double py;

    /**
     * Informação de longitude da localização da parada
     */
    @SerializedName("px")
    private Double px;

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getNp() {
        return np;
    }

    public void setNp(String np) {
        this.np = np;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public Double getPy() {
        return py;
    }

    public void setPy(Double py) {
        this.py = py;
    }

    public Double getPx() {
        return px;
    }

    public void setPx(Double px) {
        this.px = px;
    }
}
