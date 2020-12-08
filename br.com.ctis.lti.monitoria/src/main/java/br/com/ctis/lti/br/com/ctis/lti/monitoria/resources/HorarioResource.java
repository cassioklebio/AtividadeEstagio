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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.HorarioDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Horario;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.HorarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/horario")
public class HorarioResource {
	
	@Autowired
	private HorarioService horarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HorarioDTO>> findAll() {
		List<Horario> list = horarioService.findAll();
		List<HorarioDTO> listDto = list.stream().map(obj -> new HorarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Horario> find(@PathVariable Integer id){
		Horario obj = horarioService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Horario objDto) {
		Horario obj = horarioService.salvarHorario(objDto);
		obj = horarioService.salvarHorario(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody HorarioDTO objDto,
			@PathVariable Integer id) {
		Horario obj = horarioService.fromDTO(objDto);
		obj.setId(id);
		obj = horarioService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		horarioService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
