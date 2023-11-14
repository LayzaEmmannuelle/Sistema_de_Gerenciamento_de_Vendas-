package br.com.projetofinal.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class Disco {
	
	private String raiz = "C:/Users/layza/Documents/workspace-spring-tool-suite-4-4.20.0.RELEASE/Projeto_final-main/";
	private String diretorio = "fotos";
	
	public void salvarFoto(MultipartFile foto) {
		this.salvar(this.diretorio, foto);
	}
	
	private void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		}catch(IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
	}

	
	
}
