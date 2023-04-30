package bancoDigital;

public class Pessoa {
	private String nome;
	private int genero; // 1 = Homem // 2 = Mulher
	private String cpf;
	private String dataDeNascimento;
	
	//Construtor
	public Pessoa(String nome, String cpf, int genero, String dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
}
