package com.estacionamento.repository;

import java.util.ArrayList;
import java.util.List;

import com.estacionamento.model.Vaga;

public class VagaRepository {

    private List<Vaga> vagas = new ArrayList<>();

    public void salvar(Vaga vaga) {
        vagas.add(vaga);
    }

    public List<Vaga> listar() {
        return vagas;
    }
}
