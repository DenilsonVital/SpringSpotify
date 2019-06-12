package br.unipe.spotunipe.service;

import java.util.List;

import br.unipe.spotunipe.domain.Playlist;

public interface PlaylistService {

	void salvar(Playlist playlist);
	List<Playlist>recuperar();
	Playlist recuperarPorId(long id);
	void atualizar (Playlist playlist);
	void excluir(long id);
}
