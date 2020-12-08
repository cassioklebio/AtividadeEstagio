package br.com.ctis.lti.br.com.ctis.lti.monitoria.resources;

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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.SemestreDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Semestre;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.SemestreService;


@CrossOrigin
@RestController
@RequestMapping(value = "/semestre")
public class SemestreResource {
	
	@Autowired
	private SemestreService semestreService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SemestreDTO>> findAll() {
		List<Semestre> list = semestreService.findAll();
		List<SemestreDTO> listDto = list.stream().map(obj -> new SemestreDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Semestre> find(@PathVariable Integer id){
		Semestre obj = semestreService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Semestre Post(@Validated @RequestBody Semestre objDto) {
		return semestreService.salvar(objDto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody SemestreDTO objDto, @PathVariable Integer id){
		Semestre obj = semestreService.fromDTO(objDto);
		obj.setId(id);
		obj = semestreService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		semestreService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
