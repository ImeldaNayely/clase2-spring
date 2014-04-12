package org.upiita.spring.jdbc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="video")
public class Video {

	@Id
	@Column(name="video_id")
	private Integer videoId;

	@Column(name="titulo")
	private String titulo;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="url_video")
	private String urlVideo;

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder;

		builder = new StringBuilder();

		builder.append("[");
		builder.append("videoId:").append(videoId).append(", ");
		builder.append("titulo:").append(this.titulo).append(", ");
		builder.append("descripcion:").append(this.descripcion);
		builder.append("]");
		return builder.toString();
	}

}
