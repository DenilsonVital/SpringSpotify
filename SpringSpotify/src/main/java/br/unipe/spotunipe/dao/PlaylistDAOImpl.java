package br.unipe.spotunipe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.unipe.spotunipe.domain.Playlist;

@Repository//indica que esta classe trata-se de um repositório, ou seja, um componente responsável por acesso a dados armazenados em algum mecanismo de persistência
public class PlaylistDAOImpl implements PlaylistDAO{

	@PersistenceContext//Notação responsável por gerenciar a instância de um EntityManager
	private EntityManager em;//instância responsável por comunicarmos com o banco de dados
	
	
	
	//Todos os métodos abaixo que contêm o em, são métodos predefinidos pelo EntityManager, sem que haja a interferência do programador
	
	@Override
	public void salvar(Playlist playlist) {
		em.persist(playlist);
		}

	@Override
	public List<Playlist> recuperar() {
		return em.createQuery("select p from Playlist p", Playlist.class).getResultList();
		}

	@Override
	public Playlist recuperarPorId(long id) {
		return em.find(Playlist.class, id);
	}

	@Override
	public void atualizar(Playlist playlist) {
		em.merge(playlist);
		
	}

	@Override
	public void excluir(long id) {
		em.remove(em.getReference(Playlist.class, id));
		
	}

}
