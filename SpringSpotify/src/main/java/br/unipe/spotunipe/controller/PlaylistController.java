package br.unipe.spotunipe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.unipe.spotunipe.domain.Playlist;
import br.unipe.spotunipe.service.PlaylistService;

@Controller
@RequestMapping("playlists")//indica a página que conterá todas os links abaixo, exemplo: localhost:8080/playlists/listar
public class PlaylistController {

	@Autowired//Indica que o Spring fará a injeção desta depedência no momento que o Controller for criado
	private PlaylistService playlistService;
	
	
	@GetMapping("/listar")//o link "/listar" está dentro do playlists, ou seja, para acessá-lo a requisição deve ser: localhost:8080/playlists/listar
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("playlists", playlistService.recuperar());
		return new ModelAndView("/playlist/list", model);//esse caminho exibirá o list.html que está dentro de resources/templates/playlist
	}
	
	@GetMapping("/cadastro")
	public String preSalvar(@ModelAttribute("playlist")Playlist playlist, BindingResult result, RedirectAttributes attr) {
			return "/playlist/add";
	}

	
	@GetMapping("/{id}/atualizar")//o id está entre {} pq ele é uma VARIÁVEL
	public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
		Playlist playlist = playlistService.recuperarPorId(id);
		model.addAttribute("playlist", playlist);
		return new ModelAndView ("/playlist/add", model);
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("playlist")Playlist playlist, BindingResult result, RedirectAttributes attr) {
		//na linha de código acima, temos como parâmetros: Playlist playlist, para indicar que virá um objeto playlist devidamente preenchido,
		//a notação @Valid indica que se as regras de validação devem ser validadas neste momento
		//e no caso de encontrar algum erro a validação, será retornado por meio do BindingResult
		//e por fim, o parâmetro RedirectAttribute para redirecionar a página que não usa um ModelMap
		if(result.hasErrors()) {
			return "/playlist/add";
			}
		playlistService.salvar(playlist);
		attr.addFlashAttribute("mensagem", "Playlist criada com sucesso!");
		return "redirect:/playlists/listar";
	}
	
	@PutMapping("/salvar")
	public ModelAndView atualizar(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/playlist/add");
		}
		
		playlistService.atualizar(playlist);
		attr.addFlashAttribute("mensagem", "Playlist atualizada com sucesso!");
		return new ModelAndView("redirect:/playlists/listar");
	}
	
	
	@GetMapping("/{id}/remover")
	public String remover (@PathVariable("id") long id, RedirectAttributes attr) {
		playlistService.excluir(id);
		attr.addFlashAttribute("mensagem", "Playlist excluída com sucesso!");
		return "redirect:/playlists/listar";
	}
	
}
