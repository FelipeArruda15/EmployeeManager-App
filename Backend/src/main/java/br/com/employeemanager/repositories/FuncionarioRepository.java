package br.com.employeemanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.employeemanager.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	void deleteFuncionarioById(Long id);

	Optional<Funcionario> findFuncionarioById(Long id);

}
