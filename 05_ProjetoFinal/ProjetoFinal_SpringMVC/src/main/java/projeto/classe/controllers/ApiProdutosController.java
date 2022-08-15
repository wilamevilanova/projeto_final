package projeto.classe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projeto.classe.dao.Dao;
import projeto.classe.models.ProdutoApi;

@RestController
@RequestMapping("/api")
public class ApiProdutosController {

	@Autowired
	private Dao dao;

	// @CrossOrigin(methods = RequestMethod.GET, origins = "impacta.com.br")

	@CrossOrigin()
	@RequestMapping("/admin")
	public List<ProdutoApi> listar() {
		try {
			return dao.listarProdutosApi();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ProdutoApi>();
		}
	}

	// RETORNA UM OBJETO JSON AO PRODUTO, CURSO ID FORNECIDO

	@CrossOrigin
	@RequestMapping("/admin/{id}")	
	public ProdutoApi buscar(@PathVariable("id") int id){
	try {
		return dao.buscarProdutoApi(id);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/admin",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
			
	public ProdutoApi incluir (@RequestBody ProdutoApi produtoApi) {
		try {
			dao.incluirProduto(produtoApi);
			return produtoApi;
		} catch (Exception e) {
			e.printStackTrace();
			return new ProdutoApi();
		}
	}
	
	@RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
	public int exluir(@PathVariable("id") int id) {
		try {
			return dao.excluirProduto(id);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}