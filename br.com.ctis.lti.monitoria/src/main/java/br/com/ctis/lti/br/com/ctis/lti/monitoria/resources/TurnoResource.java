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


import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.TurnoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Turno;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.TurnoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/turno")
public class TurnoResource {
	
	@Autowired
	private TurnoService turnoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Turno> find(@PathVariable Integer id){
		Turno obj = turnoService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TurnoDTO>> findAll() {
		List<Turno> list = turnoService.findAll();
		List<TurnoDTO> listDto = list.stream().map(obj -> new TurnoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public Turno Post(@Validated @RequestBody Turno objDto) {
		return turnoService.salvar(objDto);
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody TurnoDTO objDto, @PathVariable Integer id){
		Turno obj = turnoService.fromDTO(objDto);
		obj.setId(id);
		obj = turnoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		turnoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
