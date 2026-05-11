package com.estacionamento.model;

public class Vaga {

    private Long id;
    private String numero;
    private boolean ocupada;

    public Vaga(Long id, String numero, boolean ocupada) {
        this.id = id;
        this.numero = numero;
        this.ocupada = ocupada;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", ocupada=" + ocupada +
                '}';
    }
}