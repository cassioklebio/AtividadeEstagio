package br.com.ctis.lti.br.com.ctis.lti.monitoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
