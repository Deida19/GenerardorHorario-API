package com.ucentral.edu.service;

import java.util.List;


import com.ucentral.edu.entities.Horario;

public interface HorarioServicio {
	public List<Horario> findbyGrupo(Integer idGrupo);
}
