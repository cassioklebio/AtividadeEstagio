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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.CursoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Curso;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.CursoService;



@CrossOrigin
@RestController
@RequestMapping(value = "/curso")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTO>> findAll() {
		List<Curso> list = cursoService.findAll();
		List<CursoDTO> listDto = list.stream().map(obj -> new CursoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> find(@PathVariable Integer id){
		Curso obj = cursoService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Curso objDto) {
		Curso obj = cursoService.salvarCurso(objDto);
		obj = cursoService.salvarCurso(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody CursoDTO objDto,
			@PathVariable Integer id) {
		Curso obj = cursoService.fromDTO(objDto);
		obj.setId(id);
		obj = cursoService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cursoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
