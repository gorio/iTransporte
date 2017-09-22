package br.com.itransporte.model;

import com.google.gson.annotations.SerializedName;

/**
 * A categoria Linhas possibilita a consulta pelas linhas de ônibus da cidade de São Paulo, bem como
 * suas informações cadastrais como por exemplo: horário de operação da linha, dias de operação (dia
 * útil, sábado ou domingo) e extensão da linha (em metros).
 */
public class Linha {

    /**
     * Código identificador da linha. Este é um código identificador único de cada linha do sistema
     * (por sentido de operação)
     */
    @SerializedName("cl")
    private Integer cl;

    /**
     * Indica se uma linha opera no modo circular (sem um terminal secundário)
     */
    @SerializedName("lc")
    private Boolean lc;

    /**
     * Informa a primeira parte do letreiro numérico da linha
     */
    @SerializedName("lt")
    private String lt;

    /**
     * Informa o sentido ao qual a linha atende, onde 1 significa Terminal Principal para Terminal
     * Secundário e 2 para Terminal Secundário para Terminal Principal
     */
    @SerializedName("sl")
    private Integer sl;

    /**
     * Informa a segunda parte do letreiro numérico da linha, que indica se a linha opera nos modos:
     * BASE (10), ATENDIMENTO (21, 23, 32, 41)
     */
    @SerializedName("tl")
    private Integer tl;

    /**
     * Informa o letreiro descritivo da linha no sentido Terminal Principal para Terminal Secundário
     */
    @SerializedName("tp")
    private String tp;

    /**
     * Informa o letreiro descritivo da linha no sentido Terminal Secundário para Terminal Principal
     */
    @SerializedName("ts")
    private String ts;

    public Integer getCl() {
        return cl;
    }

    public void setCl(Integer cl) {
        this.cl = cl;
    }

    public Boolean getLc() {
        return lc;
    }

    public void setLc(Boolean lc) {
        this.lc = lc;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getTl() {
        return tl;
    }

    public void setTl(Integer tl) {
        this.tl = tl;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
