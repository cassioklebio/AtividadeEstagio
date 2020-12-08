package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.TurnoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Turno;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.TurnoRepository;




@Service
public class TurnoService {
	
	@Autowired
	private TurnoRepository turnoRepository;
	
	
	public List<Turno> findAll(){
		return turnoRepository.findAll();
	}
	
	public Turno find(final Integer id) {
		Optional<Turno> obj = turnoRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Turno salvar(Turno obj) {
		obj.setId(null);
		obj = turnoRepository.save(obj);
		return obj;
	}
	
	public Turno update(Turno obj) {
		Turno newObj = find(obj.getId());
		updateData(newObj, obj);
		return turnoRepository.save(newObj);
	}
	

	
	private void updateData(Turno newObj, Turno obj) {
		newObj.setTurno(obj.getTurno());
		
	}

	public void delete(Integer id) {
		find(id);
		try {
			turnoRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Turno");
		}
	}

	public Turno fromDTO(TurnoDTO objDto) {
		return new Turno(objDto.getId(), objDto.getTurno());
	}

}
