package br.unipe.spotunipe.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity//informamos que esta classe representa uma entidade no banco...
@Table(name = "playlist")//...e que será mapeada em uma tabela de nome playlist
public class Playlist {

	@Id//indica que o identificador único desta entidade é a variável id...
	@GeneratedValue(strategy = GenerationType.IDENTITY)//...e será gerado automaticamente pelo banco
	private long id;
	
	@NotBlank//indica que o atributo nome não poderá ser vazio...
	@Size(min = 2, max = 60)//...que terá tamanho mínimo de 2 e máximo de 60 caracteres...
	@Column(nullable = false, length = 60)//...sua coluna não é nula e terá o tamanho de até 60 caracteres
	private String nome;
	
	@NotBlank//indica que o atributo descricao não poderá ser vazio...
	@Column(nullable = false)//...e sua coluna não pode ser nula
	private String descricao;
	
	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)//com esta notação, informamos que uma playlist pode ter uma ou muitas músicas
	private List<Musica> musicas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	
	
}
