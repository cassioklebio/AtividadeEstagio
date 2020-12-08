package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.HorarioDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Horario;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.HorarioRepository;

@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	public List<Horario> findAll(){
		return horarioRepository.findAll();
	}
	
	public Horario find(final Integer id) {
		Optional<Horario> obj = horarioRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Horario salvarHorario(Horario obj) {
		obj.setId(null);
		obj = horarioRepository.save(obj);
		return obj;
	}
	
	public Horario update(Horario obj) {
		Horario newObj = find(obj.getId());
		updateData(newObj, obj);
		return horarioRepository.save(newObj);
	}
	

	
	private void updateData(Horario newObj, Horario obj) {
		newObj.setHorario(obj.getHorario());
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			horarioRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir o Horario");
		}
	}

	public Horario fromDTO(HorarioDTO objDto) {
		return new Horario(objDto.getId(),objDto.getHorario());
	}
}
