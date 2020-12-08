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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.PresencaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Presenca;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.PresencaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/presenca")
public class PresencaResource {
	
	@Autowired
	private PresencaService presencaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Presenca> find(@PathVariable Integer id){
		Presenca obj = presencaService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PresencaDTO>> findAll() {
		List<Presenca> list = presencaService.findAll();
		List<PresencaDTO> listDto = list.stream().map(obj -> new PresencaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Presenca objDto) {
		Presenca obj = presencaService.salvarPresenca(objDto);
		obj = presencaService.salvarPresenca(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody PresencaDTO objDto,
			@PathVariable Integer id) {
		Presenca obj = presencaService.fromDTO(objDto);
		obj.setId(id);
		obj = presencaService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		presencaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
