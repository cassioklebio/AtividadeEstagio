package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.VagaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Vaga;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.VagaRepository;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	
	public List<Vaga> findAll(){
		return vagaRepository.findAll();
	}
	
	public Vaga find(final Integer id) {
		Optional<Vaga> obj = vagaRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Vaga salvarVaga(Vaga obj) {
		obj.setId(null);
		obj = vagaRepository.save(obj);
		return obj;
	}
	
	public Vaga update(Vaga obj) {
		Vaga newObj = find(obj.getId());
		return vagaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			vagaRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Aluno");
		}
	}

	public Vaga fromDTO(VagaDTO objDTO) {
		return new Vaga(objDTO.getId(),objDTO.getNome(), objDTO.getProfessor(), objDTO.getCurso());
	}

}
