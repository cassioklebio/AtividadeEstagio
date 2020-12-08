package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.ProfessorDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Professor;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll(){
		return professorRepository.findAll();
	}
	
	public Professor find(final Integer id) {
		Optional<Professor> obj = professorRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Professor salvarProfessor(Professor obj) {
		obj.setId(null);
		obj = professorRepository.save(obj);
		return obj;
	}
	
	public Professor update(Professor obj) {
		Professor newObj = find(obj.getId());
		return professorRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			professorRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Professor");
		}
	}

	public Professor fromDTO(ProfessorDTO objDto) {
		return new Professor(objDto.getId(),objDto.getNome(),objDto.getEmail(),objDto.getFone(),
							objDto.getCurso(),objDto.getSemestre(),objDto.getTurno());
	}

}
