package bancoDigital;
import java.util.*;
import java.text.*;
import javax.swing.*;
public class ContaCorrente {
	Random  rd = new Random();
	DecimalFormat df = new DecimalFormat("0.0");
	private int numero;
	private String agencia;
	private boolean ativa=false;;
	private double saldo;
	private Pessoa pessoa;
	
	//Construtor
	public ContaCorrente(String agencia,Pessoa pessoa) {
		this.numero = rd.nextInt(999) + 1;
		this.agencia = agencia;
		this.pessoa = pessoa;
		this.ativa = true;
		this.saldo = 0;
		JOptionPane.showMessageDialog(null, "Sr(a) " + pessoa.getNome() + " seu numero da conta é: " + getNumero());
		
	}
	//Metodos Da Classe
	
	public void consultarSaldo(ContaCorrente conta) {
		JOptionPane.showMessageDialog(null, "Ola Sr(a) "+ conta.getPessoa().getNome() + " o saldo da sua conta(numero " + conta.getNumero() + ") é de R$"+ df.format(conta.getSaldo()) );
	}
	
	public void transferir(ContaCorrente transferindo, ContaCorrente recebendo,double valor) {
		if(transferindo.getNumero()!= recebendo.getNumero()) {
			if(transferindo.getSaldo()> valor) {
				transferindo.setSaldo(transferindo.getSaldo() - valor);
				recebendo.setSaldo(recebendo.getSaldo() + valor);
				JOptionPane.showMessageDialog(null, "Valor de R$" + df.format(valor) + " transferido para conta de numero " + recebendo.getNumero());
			}else {
				JOptionPane.showMessageDialog(null, "Saldo insuficiente");
			}
	}else {
		JOptionPane.showMessageDialog(null, "Nao e possivel transferir para si mesmo,deposite na sua propria conta.");
	}
		
	}
	public void transferirContaPoupanca(ContaCorrente transferindo, ContaPoupanca recebendo, double valor) {
		if(transferindo.getSaldo() > valor) {
			transferindo.setSaldo(transferindo.getSaldo() - valor);
			recebendo.setSaldo(recebendo.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Valor de R$" + df.format(valor) + " transferido para a conta P de numero " + recebendo.getNumero());
		}
	}
	
	public void depositar(ContaCorrente conta,double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		JOptionPane.showMessageDialog(null, "Valor de R$"+ df.format(valor) + " depositado na conta de numero " + conta.getNumero());
	}
	
	public void sacar(ContaCorrente conta,double valor) {
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
	public boolean getAtiva() {
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
	
	//TO STRING
	@Override
	public String toString() {
		return "[numero=" + numero + ", agencia=" + agencia + ", ativa=" + ativa + ", saldo=" + saldo
				+ ", pessoa=" + pessoa.getNome() + "]";
	}
}
