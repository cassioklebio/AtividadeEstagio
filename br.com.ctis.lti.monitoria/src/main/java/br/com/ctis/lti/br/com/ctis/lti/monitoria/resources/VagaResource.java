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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.VagaDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Vaga;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.VagaService;



@CrossOrigin
@RestController
@RequestMapping(value = "/vaga")
public class VagaResource {
	
	@Autowired
	private VagaService vagaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vaga> find(@PathVariable Integer id){
		Vaga obj = vagaService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<VagaDTO>> findAll() {
		List<Vaga> list = vagaService.findAll();
		List<VagaDTO> listDto = list.stream().map(obj -> new VagaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Vaga objDto) {
		Vaga obj = vagaService.salvarVaga (objDto);
		obj = vagaService.salvarVaga(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody VagaDTO objDto,
			@PathVariable Integer id) {
		Vaga obj = vagaService.fromDTO(objDto);
		obj.setId(id);
		obj = vagaService.update(obj);
		return ResponseEntity.noContent().build();

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		vagaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
