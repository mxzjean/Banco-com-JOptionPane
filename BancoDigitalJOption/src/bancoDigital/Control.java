package bancoDigital;
import javax.swing.*;
import java.util.*;

public class Control {
	private int opcao = -1;
	private int tipo = 0;
	private String recebendo = "";
	private int numContaAtual = -1;
	List<ContaCorrente> contasCorrentes = new ArrayList<>();
	List<ContaPoupanca> contasPoupanca = new ArrayList<>();

	
	
	public void menuInicial() {
		JOptionPane.showMessageDialog(null, "Bem Vindo Ao Banco Digital J");
		while(opcao!=0) {
			try {
				recebendo = JOptionPane.showInputDialog(null, "Em que podemos ajudar?\n"
						+ "1 - Acessar Conta\n"
						+ "2 - Criar Conta Corrente\n"
						+ "3 - Criar Conta Poupanca\n"
						+ "0 - Sair");
				opcao = Integer.parseInt(recebendo);
				switch(opcao) {
				case 1:
					menuContas();
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "É necessario informar alguns dados para criar a conta");
					String nome = JOptionPane.showInputDialog("Digite seu nome:");
					String cpf = JOptionPane.showInputDialog("Digite seu cpf");
					String genero = JOptionPane.showInputDialog("Digite seu genero\n"
							+ "1 - Para homem\n"
							+ "2 - Para mulher");
					int generoIn = Integer.parseInt(genero);
					if(generoIn == 1 || generoIn ==2 ) {
					String data = JOptionPane.showInputDialog("Digite sua data de nascimento");
					
					Pessoa pessoa = new Pessoa(nome,cpf,generoIn,data);
					String agencia = JOptionPane.showInputDialog("Digite sua agencia:");
					ContaCorrente conta = new ContaCorrente(agencia,pessoa);
					contasCorrentes.add(conta);
					//REMOVER DEPOIS//JOptionPane.showMessageDialog(null, contasCorrentes);
					break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Numero invalido para genero,tente novamente");
						break;
					}
				case 3:
					JOptionPane.showMessageDialog(null, "É necessario informar alguns dados para criar a conta");
					String nome1 = JOptionPane.showInputDialog("Digite seu nome:");
					String cpf1 = JOptionPane.showInputDialog("Digite seu cpf");
					String genero1 = JOptionPane.showInputDialog("Digite seu genero\n"
							+ "1 - Para homem\n"
							+ "2 - Para mulher");
					int genero2 = Integer.parseInt(genero1);
					if(genero2 == 1 || genero2 ==2 ) {
					String data = JOptionPane.showInputDialog("Digite sua data de nascimento");
					
					Pessoa pessoa = new Pessoa(nome1,cpf1,genero2,data);
					String agencia = JOptionPane.showInputDialog("Digite sua agencia:");
					ContaPoupanca contaEs = new ContaPoupanca(agencia,pessoa);
					contasPoupanca.add(contaEs);
					// -- REMOVER DEPOIS --//JOptionPane.showMessageDialog(null, contasPoupanca);
					break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Numero invalido para genero,tente novamente");
						break;
					}
					
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
			}
		}
		
	}
	
	public void menuContas() {
		try {
			recebendo = JOptionPane.showInputDialog(null, "Informe o tipo de conta:\n"
					+ "1 - Conta Corrente\n"
					+ "2 - Conta Poupanca\n"
					+ "0 - Menu anterior");
			int opcao = Integer.parseInt(recebendo);
			switch(opcao) {
				case 0:
					break;
				case 1:
					String nomeC = JOptionPane.showInputDialog("Informe seu nome:");
					String numeroC = JOptionPane.showInputDialog("Informe o numero da conta:");
					int numeroI = Integer.parseInt(numeroC);
					for(ContaCorrente contas : contasCorrentes) {
						if(contas.getNumero() == numeroI && contas.getPessoa().getNome().equalsIgnoreCase(nomeC)) {
							tipo = 1;
							numContaAtual =  numeroI;
							menuOperacoes();
							break;
						}
					}
					break;
				case 2:
					String nome1 = JOptionPane.showInputDialog("Informe seu nome:");
					String numero1 = JOptionPane.showInputDialog("Informe o numero da conta:");
					int numeroIn = Integer.parseInt(numero1);
					for(ContaPoupanca contas : contasPoupanca) {
						if(contas.getNumero() == numeroIn && contas.getPessoa().getNome().equalsIgnoreCase(nome1)) {
							tipo = 2;
							numContaAtual = numeroIn;
							menuOperacoes();
							break;
						}
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Digite um numero valido");
					break;
					
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Opcao Invalida");
			}
	}
	
	
	public void menuOperacoes() {
		try {
			recebendo = JOptionPane.showInputDialog("O que deseja realizar?\n"
					+ "1 - Sacar\n"
					+ "2 - Depositar\n"
					+ "3 - Transferir\n"
					+ "4 - Consultar saldo\n"
					+ "0 - Menu anterior");
			opcao = Integer.parseInt(recebendo);
			switch(opcao){
				case 0:
					break;
				case 1:
					if(tipo ==1) {
						recebendo = JOptionPane.showInputDialog("Digite o numero da conta que deseja sacar");
						int numSaque = Integer.parseInt(recebendo);
						for(ContaCorrente contas : contasCorrentes) {
							if(contas.getNumero() == numSaque) {
								if(numSaque == numContaAtual) {
									String valorSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
									double valor = Double.parseDouble(valorSaque);
									contas.sacar(contas, valor);
								}
							}
						}
						
					}else {
						recebendo = JOptionPane.showInputDialog("Digite o numero da conta que deseja sacar");
						int numSaque = Integer.parseInt(recebendo);
						for(ContaPoupanca contas : contasPoupanca) {
							if(contas.getNumero() == numSaque) {
								if(numSaque == numContaAtual) {
									String valorSaque = JOptionPane.showInputDialog("Digite o valor que deseja sacar:");
									double valor = Double.parseDouble(valorSaque);
									contas.sacar(contas, valor);
								}
							}
						}
					}
					break;
				case 2:
					if(tipo == 1) {
						recebendo = JOptionPane.showInputDialog("Digite o numero da conta que deseja depositar");
						int contaDeposito = Integer.parseInt(recebendo);
						for(ContaCorrente contas : contasCorrentes) {
							if(contaDeposito == contas.getNumero()) {
								String valorDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar");
								double valor = Double.parseDouble(valorDeposito);
								contas.depositar(contas, valor);
								break;
							}
						}
						
					}else {
						recebendo = JOptionPane.showInputDialog("Digite o numero da conta que deseja depositar");
						int contaDeposito = Integer.parseInt(recebendo);
						for(ContaPoupanca contas : contasPoupanca) {
							if(contaDeposito == contas.getNumero()) {
								String valorDeposito = JOptionPane.showInputDialog("Digite o valor que deseja depositar");
								double valor = Double.parseDouble(valorDeposito);
								contas.depositar(contas, valor);
								break;
							}
						}
					}
					break;
				case 3:
					if(tipo ==1) {
						String contaRecebendo = JOptionPane.showInputDialog("Digite o numero da conta que voce deseja transferir:");
						int numRecebendo = Integer.parseInt(contaRecebendo);
						String valor = JOptionPane.showInputDialog("Digite o valor que deseja transferir:");
						double valorTransferindo = Double.parseDouble(valor);
						String conta = JOptionPane.showInputDialog("Digite que tipo de conta que e destinado sua transferencia\n1 - Conta Corrente\n2 - Conta Poupanca");
						int tipoConta = Integer.parseInt(conta);
						//Para transferir de conta Corrente para Conta Corrente
						if(tipoConta == 1) {
							for(ContaCorrente contas : contasCorrentes) {
								if(numContaAtual == contas.getNumero()) {
									for(ContaCorrente  contasTransferir : contasCorrentes) {
										if(numRecebendo == contasTransferir.getNumero()) {
											contas.transferir(contas, contasTransferir, valorTransferindo);
											break;
										}
									}
								}
							}
							//Transferindo de Conta Corrente para Conta Poupanca
						}else if(tipoConta == 2) {
							for(ContaCorrente contaC : contasCorrentes) {
								if(numContaAtual == contaC.getNumero()) {
									for(ContaPoupanca contaP : contasPoupanca) {
										if(numRecebendo == contaP.getNumero()) {
											contaC.transferirContaPoupanca(contaC, contaP, valorTransferindo);
											break;
										}
									}
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "O numero que voce digitou é invalido");
						}
					//Transferindo de Conta Poupanca para Conta poupanca	
					}else {
						String contaRecebendo = JOptionPane.showInputDialog("Digite o numero da conta que voce deseja transferir:");
						int numRecebendo = Integer.parseInt(contaRecebendo);
						String valor = JOptionPane.showInputDialog("Digite o valor que deseja transferir:");
						double valorTransferindo = Double.parseDouble(valor);
						String conta = JOptionPane.showInputDialog("Digite que tipo de conta que e destinado sua transferencia\n1 - Conta Corrente\n2 - Conta Poupanca");
						int tipoConta = Integer.parseInt(conta);
						if(tipoConta == 2) {
							for(ContaPoupanca contas : contasPoupanca) {
								if(numContaAtual == contas.getNumero()) {
									for(ContaPoupanca  contasTransferir : contasPoupanca) {
										if(numRecebendo == contasTransferir.getNumero()) {
											contas.transferir(contas, contasTransferir, valorTransferindo);
											break;
										}
									}
								}
							}
							//Transferindo de Conta Poupanca para Conta Corrente
						}else if(tipoConta == 1) {
							for(ContaPoupanca contaP : contasPoupanca) {
								if(numContaAtual == contaP.getNumero()) {
									for(ContaCorrente contaC : contasCorrentes) {
										if(numRecebendo == contaC.getNumero()) {
											contaP.transferirContaCorrente(contaP, contaC, valorTransferindo);
											break;
										}
									}
								}
							}
						}
						
					}
					break;
				case 4:
					if(tipo == 1) {
						String n = JOptionPane.showInputDialog("Confirme o numero da conta:");
						int numConta = Integer.parseInt(n);
					for(ContaCorrente contas : contasCorrentes) {
						if(numConta == contas.getNumero() && tipo==1) {
							if(numConta == numContaAtual) {
								contas.consultarSaldo(contas);
							}else {
								JOptionPane.showMessageDialog(null, "Entre na conta");
							}
						break;
						}
					}
					}else if(tipo==2) {
						String n = JOptionPane.showInputDialog("Confirme o numero da conta:");
						int numConta = Integer.parseInt(n);
						for(ContaPoupanca contasEs : contasPoupanca) {
							if(numConta == contasEs.getNumero() && tipo==2) {
								if(numConta == numContaAtual) {
									contasEs.consultarSaldo(contasEs);
								}else {
									JOptionPane.showMessageDialog(null, "Entre na conta");
								}
							}
						}
					}
					break;
					
				
				default:
					JOptionPane.showMessageDialog(null, "Digite um numero valido");
					break;
				
						
			}
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Opcao Invalida");
		}
	}
	
	
}
