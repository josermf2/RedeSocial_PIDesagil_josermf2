package br.edu.insper.desagil.redesocial;

import java.util.HashMap;
import java.util.Map;

public class Video {
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();	
	}

	public int getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void adicionaAvaliacao(Usuario usuario, int i) {
		boolean naoPostou = true;
		for (String u : this.avaliacoes.keySet()) {
			if (usuario.getNome().equals(u)) {
				naoPostou = false;
			}
		}
		if(naoPostou){
			if(i >= 1 && i <=5) {
				this.avaliacoes.put(usuario.getNome(), i);
			}
		}	
	}
	
	public int mediaAvaliacoes() {
		int total = 0;
		for(String u : this.avaliacoes.keySet()) {
			total += Math.round(this.avaliacoes.get(u));
		}
		
		return total;
	}
}
