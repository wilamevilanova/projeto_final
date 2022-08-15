package projeto.classe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FornecedorController {

	@Autowired
//	private FornecedorDao fornecedorDao;

	@GetMapping("/admin/iniciar")
	public ModelAndView iniciar() {
		return new ModelAndView("admin/index");
	}

	
//	@GetMapping("/admin/listar")
//	public ModelAndView listar(Model model) {
//		try {
//			List<Fornecedor> fornecedor = fornecedorDao.listarFornecedores();
//			model.addAttribute("admin", fornecedor);
//			return new ModelAndView("admin/listarFornecedores");
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return new ModelAndView("erro");
//		}
//	}

	@GetMapping("/admin/fornecedor")
	public String incluir(Model model) {
		try {
			return "admin/novoFornecedor";
		} catch (Exception e) {
			model.addAttribute("mensagem", e.getMessage());
			return "erro";
		}
	}

	
//	@PostMapping("/cadfornecedor")
//	public String incluir(Fornecedor fornecedor, @RequestParam("dataFornecedor") String dataFornecedor, Model model) {
//		try {
//			// Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataFornecedor);
//			// fornecedor.setData(data);
//			fornecedorDao.incluirFornecedor(fornecedor);
//			return "redirect:/admin/listarF";
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return "erro";
//		}
//
//	}
//
//	// ALTERAÇÃO DE PRODUTOS
//	@GetMapping("/admin/alterar/{idFornecedor}")
//	public String alterar(@PathVariable("idfornecedor") int id, Model model) {
//		try {
//			Fornecedor fornecedor = fornecedordao.buscarFornedores(id);
//			if (fornecedor == null) {
//				throw new Exception("Nenhum fornecedor com ID informado.");
//			}
//			model.addAttribute("evt", fornecedor);
//			return "admin/alterarFornecedor";
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return "erro";
//		}
//	}
//
//	@PostMapping("/alterafornecedor")
//	public String alterar(Fornecedor fornecedor, @RequestParam("dataFornecedor") String dataFornecedor, Model model) {
//		try {
//			// Date data = new SimpleDateFormat("yyyy-MM-dd").parse(dataFornecedor);
//			// fornecedor.setData(data);
//			fornecedordao.alterarFornecedor(fornecedor);
//			return "redirect:/admin/listar";
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return "erro";
//		}
//	}
//
//	@GetMapping("/admin/remover/{id}")
//	public String remover(@PathVariable("id") int id, Model model) {
//		try {
//			fornecedordao.excluirFornecedor(id);
//			return "redirect:/admin/listar";
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return "erro";
//		}
//	}
//
//	@GetMapping("/admin/excluirFornecedor/{id}")
//	public String excluir(@PathVariable("id") int id, Model model) {
//		try {
//			fornecedordao.excluirFornecedor(id);
//			return "redirect:/admin/listar";
//		} catch (Exception e) {
//			model.addAttribute("mensagem", e.getMessage());
//			return "erro";
//		}
//}
}
