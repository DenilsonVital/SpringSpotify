package br.unipe.spotunipe.dao;

import java.util.List;

import br.unipe.spotunipe.domain.Musica;

public interface MusicaDAO {

	List<Musica> recuperarPorPlaylist(long playlistId);
	Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId);
	void atualizar(Musica musica);
	void excluir(long musicaId);
	void salvar(Musica musica);
}
