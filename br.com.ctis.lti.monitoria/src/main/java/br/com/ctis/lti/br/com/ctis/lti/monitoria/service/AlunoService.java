package br.com.ctis.lti.br.com.ctis.lti.monitoria.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.repository.AlunoRepository;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.AlunoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Aluno;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	/**
	 * List de alunos
	 * @return
	 */
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	/**
	 * List aluno pelo id
	 * @param id
	 * @return
	 */
	public Aluno find(final Integer id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElseThrow(null);
	}
	
	public Aluno salvarAluno(Aluno obj) {
		obj.setId(null);
		obj = alunoRepository.save(obj);
		return obj;
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		return alunoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			alunoRepository.deleteById(id);
		}catch (Exception e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Aluno");
		}
	}

	public Aluno fromDTO(AlunoDTO objDTO) {
		return new Aluno(objDTO.getId(),objDTO.getNome(), objDTO.getNome(),objDTO.getFone());
	}
	
	
}
