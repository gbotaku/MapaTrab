package com.example.feto.mapatrab;

/**
 * Created by feto on 25/01/2017.
 */

public class Animal {
    private int id;
    private String nomep;
    private String nomec;
    private String distgeo;
    private String habitat;
    private String alimentacao;
    private String reproducao;
    private String caracteristicas;
    private int fav;
    private String tipo;

    public Animal(){}

    public Animal(int id, String nomep, String nomec, String distgeo, String habitat, String alimentacao, String reproducao, String caracteristicas, int fav, String tipo){
        this.id = id;
        this.nomep = nomep;
        this.nomec = nomec;
        this.distgeo = distgeo;
        this.habitat = habitat;
        this.alimentacao = alimentacao;
        this.reproducao = reproducao;
        this.caracteristicas = caracteristicas;
        this.fav = fav;
        this.tipo = tipo;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNomep(){
        return nomep;
    }
    public void setNomep(String nomep){
        this.nomep = nomep;
    }
    public String getNomec(){
        return nomec;
    }
    public void setNomec(String nomec){
        this.nomec = nomec;
    }
    public String getDistgeo(){
        return distgeo;
    }
    public void setDistgeo(String distgeo){
        this.distgeo = distgeo;
    }
    public String getHabitat(){
        return habitat;
    }
    public void setHabitat(String habitat){
        this.habitat = habitat;
    }
    public String getAlimentacao(){
        return alimentacao;
    }
    public void setAlimentacao(String alimentacao){
        this.alimentacao = alimentacao;
    }
    public String getReproducao(){
        return reproducao;
    }
    public void setReproducao(String reproducao){
        this.reproducao = reproducao;
    }
    public String getCaracteristicas(){
        return caracteristicas;
    }
    public void setCaracteristicas(String caracteristicas){
        this.caracteristicas = caracteristicas;
    }
    public int getFav(){
        return fav;
    }
    public void setFav(int fav){
        this.fav = fav;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

}


