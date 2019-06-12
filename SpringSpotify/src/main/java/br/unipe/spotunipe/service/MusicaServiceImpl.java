package br.unipe.spotunipe.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.spotunipe.dao.MusicaDAO;
import br.unipe.spotunipe.domain.Musica;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService{

	@Autowired
	private MusicaDAO musicaDAO;
	
	@Autowired
	private PlaylistService playlistService;
	
	@Override
	public void salvar(Musica musica, long playlistId) {
		musica.setPlaylist(playlistService.recuperarPorId(playlistId));
		musicaDAO.salvar(musica);
	}

	@Override
	@Transactional//(readOnly = true)//o readOnly serve para indicar que o Spring poderá APENAS ACESSAR o atributo no banco, e não sobescrevê-lo
	public List<Musica> recuperarPorPlaylist(long playlistId) {
		return musicaDAO.recuperarPorPlaylist(playlistId);
	}

	@Override
	@Transactional//(readOnly = true)//o readOnly serve para indicar que o Spring poderá APENAS ACESSAR o atributo no banco, e não sobescrevê-lo
	public Musica recuperarPorPlaylistIdEMusicaId(long playlistId, long musicaId) {
		return musicaDAO.recuperarPorPlaylistIdEMusicaId(playlistId, musicaId);
	}

	@Override
	public void atualizar(Musica musica, long playlistId) {
		musica.setPlaylist(playlistService.recuperarPorId(playlistId));
		musicaDAO.atualizar(musica);
		
	}

	@Override
	public void excluir(long playlistId, long musicaId) {
		musicaDAO.excluir(recuperarPorPlaylistIdEMusicaId(playlistId, musicaId).getId());
		
	}

	
}
