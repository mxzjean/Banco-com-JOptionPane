package bancoDigital;
import java.util.*;
import java.text.*;

import javax.swing.JOptionPane;
public class ContaPoupanca {
	Random rd = new Random();
	DecimalFormat df = new DecimalFormat("0.0");
	private int numero;
	private String agencia;
	private boolean ativa=false;;
	private double saldo;
	private Pessoa pessoa;
	
	//Construtor
	public ContaPoupanca(String agencia, Pessoa pessoa) {
		this.numero = rd.nextInt(999) + 1;
		this.agencia = agencia;
		this.saldo = 50d;
		this.pessoa = pessoa;
		this.ativa = true;
		JOptionPane.showMessageDialog(null, "Sr(a) " + pessoa.getNome() + " seu numero da conta é: " + getNumero());
	}
	//Metodos da classe
	
	public void consultarSaldo(ContaPoupanca conta) {
		JOptionPane.showMessageDialog(null, "Ola Sr(a) "+ conta.getPessoa().getNome() + " o saldo da sua conta(numero " + conta.getNumero() + ") é de R$"+ df.format(conta.getSaldo()) );
	}
	
	public void transferir(ContaPoupanca transferindo,ContaPoupanca recebendo,double valor) {
		if(transferindo.getNumero()!= recebendo.getNumero()) {
			if(transferindo.getSaldo()> valor) {
				transferindo.setSaldo(transferindo.getSaldo() - valor);
				recebendo.setSaldo(recebendo.getSaldo() + valor);
				JOptionPane.showMessageDialog(null, "Valor de R$ " + df.format(valor) + " transferido para conta de numero " + recebendo.getNumero());
			}else {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			}
	}else {
		JOptionPane.showMessageDialog(null, "Nao e possivel transferir para si mesmo,deposite na sua propria conta.");
	}
	}
	
	public void transferirContaCorrente(ContaPoupanca transferindo, ContaCorrente recebendo, double valor) {
		if(transferindo.getSaldo() > valor) {
			transferindo.setSaldo(transferindo.getSaldo() - valor);
			recebendo.setSaldo(recebendo.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Valor de R$" + df.format(valor) + " transferido para a conta C de numero " + recebendo.getNumero());
		}
	}
	
	public void depositar(ContaPoupanca conta,double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		JOptionPane.showMessageDialog(null, "Valor de R$"+ df.format(valor) + " depositado na conta de numero " + conta.getNumero());
	}
	
	public void sacar(ContaPoupanca conta,double valor) {
		if(conta.getSaldo()>= valor) {
			conta.setSaldo(conta.getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Voce acaba de sacar R$" + df.format(valor) + " da sua conta(numero " + conta.getNumero() + ")");
		}
		else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente");
		}
	}
	
	
	
	
	//Getters e Setters
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public boolean isAtiva() {
		return ativa;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	@Override
	public String toString() {
		return "[numero=" + numero + ", agencia=" + agencia + ", ativa=" + ativa + ", saldo=" + saldo
				+ ", pessoa=" + pessoa.getNome() + "]";
	}
}
