package br.unipe.spotunipe.dao;

import java.util.List;

import br.unipe.spotunipe.domain.Playlist;

public interface PlaylistDAO {

	void salvar (Playlist playlist);
	List<Playlist> recuperar();
	Playlist recuperarPorId(long id);
	void atualizar(Playlist playlist);
	void excluir(long id);
}
