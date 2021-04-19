package br.edu.insper.desagil.redesocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private List<Video> videos;
	
	public Usuario(String nome) {
		this.nome = nome;
		this.videos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	
	public void postaVideo(int id, Produto produto) {
		videos.add(new Video(id, this, produto));
	}
	
	public double totalAvaliacoes() {
		int total = 0;
		for (Video video : videos) {
			total += video.mediaAvaliacoes();
		}
		return Math.round(total);
	}
	
}
