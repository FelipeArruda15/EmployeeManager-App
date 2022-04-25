package br.com.employeemanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.employeemanager.exceptions.UsuarioNaoEncontradoException;
import br.com.employeemanager.model.Funcionario;
import br.com.employeemanager.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public Funcionario adicionarFuncionario(Funcionario funcionario) {
		funcionario.setCodigoFuncionario(UUID.randomUUID().toString());
		return funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> listarTodosFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario encontrarFuncionárioPorId(Long id) {
		return funcionarioRepository.findFuncionarioById(id)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário de id " + id + " não foi encontrado"));
	}

	public void deletarFuncionario(Long id) {
		funcionarioRepository.deleteFuncionarioById(id);
	}
}
