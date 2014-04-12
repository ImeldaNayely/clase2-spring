package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.upiita.spring.jdbc.entidades.Video;

public interface VideoDAO {

	public void creaVideo(Video video);
	
	public Video obtenVideoPorId(Integer videoId);
	
	public List<Video> obtenPorTitulo(String titulo);

}
