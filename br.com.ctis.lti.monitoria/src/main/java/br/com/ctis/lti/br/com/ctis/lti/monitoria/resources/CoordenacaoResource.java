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

import br.com.ctis.lti.br.com.ctis.lti.monitoria.dto.CoordenacaoDTO;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.model.Coordenacao;
import br.com.ctis.lti.br.com.ctis.lti.monitoria.service.CoordenacaoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/coordenacao")
public class CoordenacaoResource {
	
	@Autowired
	private CoordenacaoService coordenacaoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Coordenacao> find(@PathVariable Integer id){
		Coordenacao obj = coordenacaoService.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CoordenacaoDTO>> findAll() {
		List<Coordenacao> list = coordenacaoService.findAll();
		List<CoordenacaoDTO> listDto = list.stream().map(obj -> new CoordenacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody Coordenacao objDto) {
		Coordenacao obj = coordenacaoService.salvar(objDto);
		obj = coordenacaoService.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody CoordenacaoDTO objDto,
			@PathVariable Integer id) {
		Coordenacao obj = coordenacaoService.fromDTO(objDto);
		obj.setId(id);
		obj = coordenacaoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		coordenacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
