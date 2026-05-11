package com.estacionamento.controller;

import java.util.List;
import java.util.Scanner;

import com.estacionamento.model.Vaga;
import com.estacionamento.service.VagaService;

public class VagaController {

    private VagaService service = new VagaService();

    public void iniciar() {

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== SISTEMA DE VAGAS =====");
            System.out.println("1 - Cadastrar vaga");
            System.out.println("2 - Listar vagas");
            System.out.println("3 - Listar vagas disponíveis");
            System.out.println("4 - Ocupar vaga");
            System.out.println("5 - Liberar vaga");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID da vaga: ");
                    Long id = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Número da vaga: ");
                    String numero = sc.nextLine();

                    Vaga vaga = new Vaga(id, numero, false);

                    service.cadastrar(vaga);

                    System.out.println("Vaga cadastrada!");

                    break;

                case 2:

                    List<Vaga> vagas = service.listar();

                    if (vagas.isEmpty()) {

                        System.out.println("Nenhuma vaga cadastrada.");

                    } else {

                        for (Vaga v : vagas) {
                            System.out.println(v);
                        }
                    }

                    break;

                case 3:

                    List<Vaga> disponiveis = service.listarDisponiveis();

                    if (disponiveis.isEmpty()) {

                        System.out.println("Nenhuma vaga disponível.");

                    } else {

                        for (Vaga v : disponiveis) {
                            System.out.println(v);
                        }
                    }

                    break;

                case 4:

                    System.out.print("Digite o número da vaga: ");
                    String ocupar = sc.nextLine();

                    if (service.ocuparVaga(ocupar)) {

                        System.out.println("Vaga ocupada!");

                    } else {

                        System.out.println("Não foi possível ocupar a vaga.");
                    }

                    break;

                case 5:

                    System.out.print("Digite o número da vaga: ");
                    String liberar = sc.nextLine();

                    if (service.liberarVaga(liberar)) {

                        System.out.println("Vaga liberada!");

                    } else {

                        System.out.println("Não foi possível liberar a vaga.");
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado!");

                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
