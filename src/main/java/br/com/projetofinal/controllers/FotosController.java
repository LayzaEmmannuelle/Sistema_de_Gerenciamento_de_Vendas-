package br.com.projetofinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.projetofinal.storage.Disco;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@Autowired
	private Disco disco;
	
	@Operation(
			summary ="Salvar Foto",
			description = "Esse método salva fotos")
	@PostMapping
	public void upload(@RequestParam MultipartFile foto) {
		disco.salvarFoto(foto);
	}
}
