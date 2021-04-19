package br.edu.insper.desagil.redesocial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testRedeSocial {
	private Usuario usuario;
	private Produto produto;
	
	@BeforeEach
	public void setUp() {
		usuario = new Usuario("José");
		produto = new Produto("Computador", 1000.0);
	}
	
	@Test
	public void notasInvalidas() {
		Video video = usuario.postaVideo(0, produto);
		
		video.adicionaAvaliacao(new Usuario("João"), 0);
		video.adicionaAvaliacao(new Usuario("Maria"), 6);

		assertEquals(0, usuario.totalAvaliacoes());	
	}
	
	@Test
	public void notaValida() {
		Video video = usuario.postaVideo(1, produto);
		video.adicionaAvaliacao(new Usuario("Maria"), 3);
		
		assertEquals(3, usuario.totalAvaliacoes());	
	}
	
	@Test
	public void duasNotasValidas() {
		Video video = usuario.postaVideo(1, produto);
		video.adicionaAvaliacao(new Usuario("Maria"), 3);
		video.adicionaAvaliacao(new Usuario("João"), 2);

		assertEquals(3, usuario.totalAvaliacoes());	
	}
	
	@Test
	public void tresNotasValidas() {
		Video video = usuario.postaVideo(1, produto);
		video.adicionaAvaliacao(new Usuario("Maria"), 3);
		video.adicionaAvaliacao(new Usuario("João"), 1);
		video.adicionaAvaliacao(new Usuario("Carlos"), 3);

		assertEquals(2, usuario.totalAvaliacoes());	
	}
	
	@Test
	public void doisVideos() {
		Video videoUm = usuario.postaVideo(1, produto);
		Video videoDois = usuario.postaVideo(2, produto);
		videoUm.adicionaAvaliacao(new Usuario("Maria"), 3);
		videoUm.adicionaAvaliacao(new Usuario("João"), 1);
		videoDois.adicionaAvaliacao(new Usuario("Carlos"), 3);

		assertEquals(5, usuario.totalAvaliacoes());	
	}
	
	
}
