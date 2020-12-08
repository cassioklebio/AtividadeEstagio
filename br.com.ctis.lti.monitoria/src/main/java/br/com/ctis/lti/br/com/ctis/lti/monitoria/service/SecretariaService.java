package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.SecretariaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Secretaria;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.SecretariaRepository;

@Service
public class SecretariaService {
	
	@Autowired
	private SecretariaRepository secretariaRepository;
	
	public List<Secretaria> findAll(){
		return secretariaRepository.findAll();
	}	
	public Secretaria find(final Integer id) {
		Optional<Secretaria> obj = secretariaRepository.findById(id);
		return obj.orElseThrow(null);
	}
	public Secretaria salvar(Secretaria obj) {
		obj.setId(null);
		obj = secretariaRepository.save(obj);
		return obj;
	}
	public Secretaria update(Secretaria obj) {
		Secretaria newObj = find(obj.getId());
		return secretariaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			secretariaRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma Secretaria");
		}
	}
	public Secretaria fromDTO(SecretariaDTO objDto) {
		return new Secretaria(objDto.getId(),objDto.getNome(),objDto.getEmail(),objDto.getFone());
	}

}
