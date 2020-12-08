package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.SemestreDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Semestre;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.SemestreRepository;

@Service
public class SemestreService {
	
	@Autowired
	private SemestreRepository semestreRepository;
	
	public List<Semestre> findAll(){
		return semestreRepository.findAll();
	}
	
	public Semestre find(final Integer id) {
		Optional<Semestre> obj = semestreRepository.findById(id);
		return obj.orElseThrow(null);
	}
	public Semestre salvar(Semestre obj) {
		obj.setId(null);
		obj = semestreRepository.save(obj);
		return obj;
	}
	
	public Semestre update(Semestre obj) {
		Semestre newObj = find(obj.getId());
		updateData(newObj, obj);
		return semestreRepository.save(newObj);
	}
	
	private void updateData(Semestre newObj, Semestre obj) {
		newObj.setSemestre(obj.getSemestre());
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			semestreRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Semestre");
		}
	}

	public Semestre fromDTO(SemestreDTO objDto) {
	 	return new Semestre(objDto.getId(), objDto.getSemestre());
	}

	
	

}
