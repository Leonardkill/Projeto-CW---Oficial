package com.example.projetocw.Classes;

public class PontoColeta {
    private String id;
    private String nomePontoColeta;
    private Double latitude;
    private Double longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNomePontoColeta() {
        return nomePontoColeta;
    }

    public void setNomePontoColeta(String nomePontoColeta) {
        this.nomePontoColeta = nomePontoColeta;
    }
}
