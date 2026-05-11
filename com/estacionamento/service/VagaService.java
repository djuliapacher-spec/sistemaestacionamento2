package com.estacionamento.service;

import java.util.ArrayList;
import java.util.List;

import com.estacionamento.model.Vaga;
import com.estacionamento.repository.VagaRepository;

public class VagaService {

    private VagaRepository repository = new VagaRepository();

    public void cadastrar(Vaga vaga) {
        repository.salvar(vaga);
    }

    public List<Vaga> listar() {
        return repository.listar();
    }

    public List<Vaga> listarDisponiveis() {

        List<Vaga> disponiveis = new ArrayList<>();

        for (Vaga vaga : repository.listar()) {

            if (!vaga.isOcupada()) {
                disponiveis.add(vaga);
            }
        }

        return disponiveis;
    }

    public boolean ocuparVaga(String numero) {

        for (Vaga vaga : repository.listar()) {

            if (vaga.getNumero().equalsIgnoreCase(numero)) {

                if (!vaga.isOcupada()) {

                    vaga.setOcupada(true);

                    return true;
                }
            }
        }

        return false;
    }

    public boolean liberarVaga(String numero) {

        for (Vaga vaga : repository.listar()) {

            if (vaga.getNumero().equalsIgnoreCase(numero)) {

                if (vaga.isOcupada()) {

                    vaga.setOcupada(false);

                    return true;
                }
            }
        }

        return false;
    }
}
