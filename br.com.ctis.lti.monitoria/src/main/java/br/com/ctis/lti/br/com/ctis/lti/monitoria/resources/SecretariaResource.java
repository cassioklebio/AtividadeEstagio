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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.SecretariaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Secretaria;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.SecretariaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/secretaria")
public class SecretariaResource {
	
	@Autowired
	private SecretariaService secretariaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Secretaria> find(@PathVariable Integer id){
		Secretaria obj = secretariaService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SecretariaDTO>> findAll() {
		List<Secretaria> list = secretariaService.findAll();
		List<SecretariaDTO> listDto = list.stream().map(obj -> new SecretariaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Secretaria objDto) {
		Secretaria obj = secretariaService.salvar(objDto);
		obj = secretariaService.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody SecretariaDTO objDto,
			@PathVariable Integer id) {
		Secretaria obj = secretariaService.fromDTO(objDto);
		obj.setId(id);
		obj = secretariaService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		secretariaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
