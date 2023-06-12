import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeJogador;

        System.out.print("Digite o nome do jogador: ");
        nomeJogador = scanner.nextLine();

        Ranking ranking = new Ranking();

        int opcao;
        do {
            exibirMenuPrincipal();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    iniciarNovoJogo(scanner, nomeJogador, ranking);
                    break;
                case 2:
                    consultarRanking(scanner, ranking);
                    break;
                case 3:
                    System.out.println("\nJogo encerrado.\n");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    break;
            }

            System.out.println(); 

        } while (opcao != 3);

        scanner.close();
    }

    public static void exibirMenuPrincipal() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.print("1 - Iniciar Novo Jogo\n" +
                         "2 - Consultar Ranking\n" +
                         "3 - Sair\n\n" +
                         "Digite sua opção: ");
    }

    public static void iniciarNovoJogo(Scanner scanner, String nomeJogador, Ranking ranking) {
        exibirMenuModoJogo();
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println(); 

        if (opcao == 1) {
            BancoDePalavras bancoDePalavras = new BancoDePalavras();
            FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
            Embaralhador embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
            Jogador jogador = new Jogador(nomeJogador);
            jogador.setTipoMecanica("padrao");
            FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
            MecanicaDoJogo mecanicaDoJogo = fabricaMecanicaDoJogo.getMecanicaDoJogo(bancoDePalavras, embaralhador, jogador.getTipoMecanica());
            jogar(scanner, jogador, mecanicaDoJogo, ranking);
        } else if (opcao == 2) {
            BancoDePalavras bancoDePalavras = new BancoDePalavras();
            FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
            Embaralhador embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
            Jogador jogador = new Jogador(nomeJogador);
            jogador.setTipoMecanica("limite_tempo");
            FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
            MecanicaDoJogo mecanicaDoJogo = fabricaMecanicaDoJogo.getMecanicaDoJogo(bancoDePalavras, embaralhador, jogador.getTipoMecanica());
            jogar(scanner, jogador, mecanicaDoJogo, ranking);
        } else {
            System.out.println("\nOpção inválida. Retornando ao menu principal.\n");
        }
    }

    public static void exibirMenuModoJogo() {
        System.out.println("--- MODO DE JOGO ---");
        System.out.println("1 - Padrão          (fim de jogo = 03 erros)");
        System.out.println("2 - Limite de Tempo (fim de jogo = 30 segundos)");
        System.out.print("Digite sua opção: ");
    }

    public static void jogar(Scanner scanner, Jogador jogador, MecanicaDoJogo mecanicaDoJogo, Ranking ranking) {
        System.out.println("\n--- NOVO JOGO ---\n");

        while (!mecanicaDoJogo.isFimDeJogo()) {
            System.out.println("Palavra embaralhada: " + mecanicaDoJogo.getPalavraEmbaralhada());
            System.out.print("Digite sua resposta: ");
            String resposta = scanner.nextLine();

            if (mecanicaDoJogo.tentarAcertar(resposta)) {
                System.out.println("\nParabéns! Você acertou.\n");
            } else {
                System.out.println("\nVocê errou.\n");
            }
        }

        System.out.println("Fim de jogo.");
        int pontuacao = mecanicaDoJogo.getPontuacao();
        System.out.println("Pontuação final: " + pontuacao);

        jogador.setPontuacao(pontuacao);
        ranking.adicionarJogador(jogador);

        System.out.println("\nRetornando ao menu principal.\n");
    }

    public static void consultarRanking(Scanner scanner, Ranking ranking) {
        exibirMenuModalidadeRanking();
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println(); 

        if (opcao == 1) {
            System.out.println("--- RANKING PADRÃO ---");
            ranking.exibirRankingPadrao();
        } else if (opcao == 2) {
            System.out.println("--- RANKING LIMITE DE TEMPO ---");
            ranking.exibirRankingLimiteTempo();
        } else {
            System.out.println("Opção inválida. Retornando ao menu principal.");
        }
    }

    public static void exibirMenuModalidadeRanking() {
        System.out.println("--- MODALIDADE DO RANKING ---");
        System.out.println("1 - Padrão");
        System.out.println("2 - Limite de Tempo");
        System.out.print("Digite sua opção: ");
    }
}

