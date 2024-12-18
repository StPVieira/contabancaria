package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {
	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scanner = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaCorrente cp1 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaCorrente cp2 = new ContaCorrente(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

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
			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

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
				System.out.println("Digite o número da agência: ");
				agencia = scanner.nextInt();
				System.out.println("Digite o nome do titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta (R$): ");
				saldo = scanner.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$): ");
						limite = scanner.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da conta: ");
						aniversario = scanner.nextInt();
						contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Listar todas as contas                                    \n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Consultar dados da conta - por número                     \n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados da conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				var buscaConta = contas.buscarNaCollection(numero);

				if (buscaConta != null) {

					tipo = buscaConta.getTipo();

					System.out.println("Digite o número da agência: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o nome do titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();

					System.out.println("Digite o saldo da conta (R$): ");
					saldo = scanner.nextFloat();

					switch (tipo) {
						case 1 -> {
							System.out.println("Digite o limite de crédito (R$): ");
							limite = scanner.nextFloat();

							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));

						}
						case 2 -> {
							System.out.println("Digite o dia do aniversario da conta: ");
							aniversario = scanner.nextInt();

							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

						}
						default -> {
							System.out.println("Tipo de conta inválido!");
						}
					}
				} else {
					System.out.println("Tipo de conta inválido!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Apagar a conta                                            \n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Saque                                                     \n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = scanner.nextFloat();
				}while(valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Depósito                                                  \n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor do depósito (R$): ");
					valor = scanner.nextFloat();
				} while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLACK_BACKGROUND
						+ "Transferência entre contas                                \n\n");
				
				System.out.println("Digite o numero da conta de origem: ");
				numero = scanner.nextInt();
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor da transferência (R$): ");
					valor = scanner.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
			pause(1000);
		}
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND
				+ "\n**********************************************************");
		System.out.println("Projeto Desenvolvido por:                                 ");
		System.out.println("Pedro Vieira - pedrohq.vieira168@gmail.com                ");
		System.out.println("github.com/StPVieira                                      ");
		System.out.println("**********************************************************");
	}

	public static void pause(long milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
			System.err.println("Thread interrompida durante o pause de " + milissegundos + " milissegundos.");
		}
	}

}
