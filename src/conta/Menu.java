package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND
					+ "**********************************************************");
			System.out.println("                                                          ");
			System.out.println("                BANCO DO BRAZIL COM Z                     ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************");
			System.out.println("                                                          ");
			System.out.println("            1 - Criar Conta                               ");
			System.out.println("            2 - Listar todas as Contas                    ");
			System.out.println("            3 - Buscar Conta por Numero                   ");
			System.out.println("            4 - Atualizar Dados da Conta                  ");
			System.out.println("            5 - Apagar Conta                              ");
			System.out.println("            6 - Sacar                                     ");
			System.out.println("            7 - Depositar                                 ");
			System.out.println("            8 - Transferir valores entre Contas           ");
			System.out.println("            9 - Sair                                      ");
			System.out.println("                                                          ");
			System.out.println("**********************************************************");
			System.out.println("Entre com a opção desejada:                               ");
			System.out.println("                                                          " + Cores.TEXT_RESET);

			opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "\nBanco do Brazil com Z - Cresça com a gente, hoje e sempre!" + Cores.TEXT_RESET);
				pause(1000);
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Criar conta                                               \n\n");
				pause(1000);
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Listar todas as contas                                    \n\n");
				pause(1000);
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Consultar dados da conta - por número                     \n\n");
				pause(1000);
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Atualizar dados da conta                                  \n\n");
				pause(1000);
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Apagar a conta                                            \n\n");
				pause(1000);
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Saque                                                     \n\n");
				pause(1000);
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Depósito                                                  \n\n");
				pause(1000);
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Transferência entre contas                                \n\n");
				pause(1000);
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				pause(1000);
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND
				+ "\n**********************************************************");
		System.out.println("Projeto Desenvolvido por:                                 ");
		System.out.println("Generation Brasil - generation@generation.org             ");
		System.out.println("github.com/conteudoGeneration                             ");
		System.out.println("**********************************************************");
	}

	public static void pause(long milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}

}
