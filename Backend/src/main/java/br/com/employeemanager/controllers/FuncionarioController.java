package br.com.employeemanager.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.employeemanager.model.Funcionario;
import br.com.employeemanager.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/todos")
	public ResponseEntity<List<Funcionario>> obterTodosFuncionarios() {
		List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
		return ResponseEntity.ok().body(funcionarios);
	}

	@GetMapping("/procurar/{id}")
	public ResponseEntity<Funcionario> obterFuncionarioPorId(@PathVariable("id") Long id) {
		Funcionario funcionario = funcionarioService.encontrarFuncionárioPorId(id);
		return ResponseEntity.ok().body(funcionario);
	}

	@PostMapping("/adicionar")
	public ResponseEntity<Funcionario> adicionarFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario novoFuncionario = funcionarioService.adicionarFuncionario(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(novoFuncionario);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Funcionario> atualizarFuncionario(@RequestBody Funcionario funcionario) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(funcionario);
		return ResponseEntity.ok().body(funcionarioAtualizado);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletatFuncionario(@PathVariable("id") Long id) {
		funcionarioService.deletarFuncionario(id);
		return ResponseEntity.noContent().build();
	}
}
