package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.CoordenacaoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Coordenacao;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.CoordenacaoRepository;

@Service
public class CoordenacaoService {
	
	@Autowired
	private CoordenacaoRepository coordenacaoRepository;
	
	
	public List<Coordenacao> findAll(){
		return coordenacaoRepository.findAll();
	}
	
	
	public Coordenacao find(final Integer id) {
		Optional<Coordenacao> obj = coordenacaoRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Coordenacao salvar(Coordenacao obj) {
		obj.setId(null);
		obj = coordenacaoRepository.save(obj);
		return obj;
	}
	
	public Coordenacao update(Coordenacao obj) {
		Coordenacao newObj = find(obj.getId());
		return coordenacaoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			coordenacaoRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Coordenacao");
		}
	}


	public Coordenacao fromDTO(CoordenacaoDTO objDto) {
		return new Coordenacao(objDto.getId(),objDto.getNome(),objDto.getEmail(),objDto.getFone(),objDto.getTipo());
	}

}
