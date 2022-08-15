package projeto.classe.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import projeto.classe.dao.Dao;
import projeto.classe.models.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private Dao dao;

	@GetMapping("/admin/inicio")
	public ModelAndView iniciar() {
		return new ModelAndView("admin/index"); 
	}

	@GetMapping("/admin/listar") 
	public ModelAndView listar(Model model) {
		try {
			List<Produto> produtos = dao.listarProdudos();
			model.addAttribute("admin", produtos);
			return new ModelAndView("admin/listaProdutos");
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return new ModelAndView("erro");
		}
	}

	@GetMapping("/admin/incluir")
	public String incluir(Model model) {
		try {
			return "admin/novoProduto";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}


	@PostMapping("/cadproduto")
	public String incluir
	(Produto produto, @RequestParam("dataProduto") String dataProduto, Model model) {
		try {
			//System.out.println(dataProduto);
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataProduto);
			produto.setData(data);
			dao.incluirProduto(produto);
			return "redirect:/admin/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}

	}

	// ALTERAÇÃO DE PRODUTOS
	@GetMapping("/admin/alterar/{idProduto}")
	public String alterar (@PathVariable("idProduto") int id, Model model) {
		try {
			Produto produto = dao.buscarProduto(id);
			if (produto == null) {
				throw new Exception("Nenhum produto com ID informado.");
			}
			model.addAttribute("evt", produto);
			return "admin/alterarProduto";//O retorno de um action é um página.
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@PostMapping("/alteraproduto")
	public String alterar (Produto produto, @RequestParam("dataProduto") String dataProduto, Model model) {
		try {
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataProduto);
			produto.setData(data);
			dao.alterarProduto(produto);
			return "redirect:/admin/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	
	@GetMapping("/admin/remover/{id}")	
	public String remover(@PathVariable("id")int id, Model model) {
		try {
		dao.excluirProduto(id);
			return "redirect:/admin/listar";
	} catch (Exception e) {
		model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	@GetMapping("/admin/excluirProduto/{id}")
	public String excluir(@PathVariable("id") int id, Model model) {
		try {
			dao.excluirProduto(id);
			return "redirect:/admin/listar";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}
	
	//ACTIONS PRA INCLUIR NOVOS PRODUTOS VIA API
		@GetMapping("/admin/incluirapi")
		public String incluirProdutoApi (Model model) {
			try {
				return "admin/novoProdutoApi";
			} catch (Exception e) {
				model.addAttribute("mensagem", e.getMessage());
				return "erro";
			}
		}
}