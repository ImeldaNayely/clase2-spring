package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Video;

@Component("videoDAO")
public class VideoDAOHibernate implements VideoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void creaVideo(Video video) {
		
		Session sesion = sessionFactory.openSession();

		sesion.beginTransaction();
		sesion.save(video);
		sesion.getTransaction().commit();
		sesion.close();
		
	}

	public Video obtenVideoPorId(Integer videoId) {
		Session sesion = sessionFactory.openSession();

		sesion.beginTransaction();
		Video video = (Video) sesion.get(Video.class, videoId);
		sesion.getTransaction().commit();
		sesion.close();

		return video;
	}
	
	
	public List<Video> obtenPorTitulo(String titulo){
		//Primero creamos una sesion de hibernate
		Session sesion = sessionFactory.openSession();
		//Una vez que tiene la sesion de hibernate deben de abrir una transaccion(conjunto de instrucciones de sql que se ejecuten parte de ese bloque
		sesion.beginTransaction();
		//Inicia la transaccion
				
		Criteria criterio = sesion.createCriteria(Video.class);
		criterio.add(Restrictions.not(Restrictions.like("titulo", "%"+titulo+"%")));
				
		//Si saben que va a regresar una sola entidad
		List<Video> videos = criterio.list();
				
		//termina la transaccion
		sesion.getTransaction().commit();
		//cerramos la sesion de hibernate
		sesion.close();	
		
		return videos;
	}



}
