package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.CursoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Curso find(final Integer id) {
		Optional<Curso> obj = cursoRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Curso salvarCurso(Curso obj) {
		obj.setId(null);
		obj = cursoRepository.save(obj);
		return obj;
	}
	
	public Curso update(Curso obj) {
		Curso newObj = find(obj.getId());
		updateData(newObj, obj);
		return cursoRepository.save(newObj);
	}

	
	private void updateData(Curso newObj, Curso obj) {
		newObj.setCurso(obj.getCurso());
		
	}
	
	public void delete (Integer id) {
		find(id);
		try {
			cursoRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Curso");
		}
	}

	public Curso fromDTO(CursoDTO objDto) {
		return new Curso(objDto.getId(),objDto.getCurso());
	}

}
