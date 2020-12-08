package br.com.ctis.lti.br.com.ctis.lti.monitoria.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.ProfessorDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Professor;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.ProfessorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> find(@PathVariable Integer id){
		Professor obj = professorService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> findAll() {
		List<Professor> list = professorService.findAll();
		List<ProfessorDTO> listDto = list.stream().map(obj -> new ProfessorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Professor objDto) {
		Professor obj = professorService.salvarProfessor(objDto);
		obj = professorService.salvarProfessor(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody ProfessorDTO objDto,
			@PathVariable Integer id) {
		Professor obj = professorService.fromDTO(objDto);
		obj.setId(id);
		obj = professorService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		professorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
