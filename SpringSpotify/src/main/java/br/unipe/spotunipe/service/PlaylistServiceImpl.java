package br.unipe.spotunipe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipe.spotunipe.dao.PlaylistDAO;
import br.unipe.spotunipe.domain.Playlist;

@Service//indica que esta classe é uma classe de serviço no Spring
@Transactional//indica que o próprio Spring tem como responsabilidades o INICIAR, COMITAR e ROLLBACK das transações
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	private PlaylistDAO playlistDAO;
	
	
	@Override
	public void salvar(Playlist playlist) {
		playlistDAO.salvar(playlist);
		
	}

	@Override
	@Transactional//(readOnly = true)
	public List<Playlist> recuperar() {
		return playlistDAO.recuperar();
	}

	@Override
	@Transactional//(readOnly = true)
	public Playlist recuperarPorId(long id) {
		return playlistDAO.recuperarPorId(id);
	}

	@Override
	public void atualizar(Playlist playlist) {
		playlistDAO.atualizar(playlist);
		
	}

	@Override
	public void excluir(long id) {
		playlistDAO.excluir(id);
		
	}

}
