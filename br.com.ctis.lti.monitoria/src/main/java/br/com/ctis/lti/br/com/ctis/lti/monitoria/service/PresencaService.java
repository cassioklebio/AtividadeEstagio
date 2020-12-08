package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.PresencaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Presenca;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.PresencaRepository;

@Service
public class PresencaService {
	
	@Autowired
	private PresencaRepository presencaRepository;
	
	public List<Presenca> findAll(){
		return presencaRepository.findAll();
	}
	
	public Presenca find(final Integer  id ) {
		Optional<Presenca> obj = presencaRepository.findById( id );
		return obj.orElseThrow(null);
	}
	public Presenca salvarPresenca(Presenca obj) {
		obj.setId(null);
		obj = presencaRepository.save(obj);
		return obj;
	}
	public Presenca update(Presenca obj) {
		Presenca newObj = find(obj.getId());
		updateData(newObj, obj);
		return presencaRepository.save(newObj);
	}
	

	
	private void updateData(Presenca newObj, Presenca obj) {
		newObj.setPresenca(obj.getPresenca());
		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			presencaRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir a Presenca");
		}
	}

	public Presenca fromDTO(PresencaDTO objDto) {
		return new Presenca(objDto.getId(),objDto.getPresenca(),objDto.getHorario());
	}
}

