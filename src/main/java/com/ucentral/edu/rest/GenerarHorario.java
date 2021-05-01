package com.ucentral.edu.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ucentral.edu.dao.EstudianteDAO;
import com.ucentral.edu.entities.Asignatura;
import com.ucentral.edu.entities.Estudiante;
import com.ucentral.edu.entities.Grupo;
import com.ucentral.edu.entities.Horario;
import com.ucentral.edu.entities.HorarioEstudiante;
import com.ucentral.edu.entities.HorarioXEstudiante;
import com.ucentral.edu.entities.opcHorarioXEstudiante;
import com.ucentral.edu.service.AsignaturaServicio;
import com.ucentral.edu.service.EstudianteServicio;
import com.ucentral.edu.service.GrupoServicio;
import com.ucentral.edu.service.HorarioEstudianteServicio;
import com.ucentral.edu.service.HorarioServicio;
import com.ucentral.edu.service.HorarioXEstudianteServicio;

@RestController
@RequestMapping("/GeneradorHorario")
public class GenerarHorario {
	
	@Autowired
	private EstudianteDAO estudDAO;
	
	@Autowired
	private EstudianteServicio EstuService;
	@Autowired
	private AsignaturaServicio asignaturaServicio;
	@Autowired
	private GrupoServicio grupoServicio;
	@Autowired
	private HorarioServicio horarioServicio;
	@Autowired
	private HorarioEstudianteServicio horarioEstudianteServicio;
	@Autowired
	private HorarioXEstudianteServicio horarioXEstudianteServicio;
	
	
	@RequestMapping(value = "EstudiantebyDoc", method = RequestMethod.GET)
	public List<Estudiante> buscarDocumento(@RequestParam ("documento") String document){
		List<Estudiante> lstEstudiante = EstuService.findbydocumento(document);
		if (lstEstudiante.size() == 0) {
			throw new RuntimeException("No se encontro el estudiante " + document);
			
		}
		return lstEstudiante;
	}
	
	
	@RequestMapping(value = "AllEstudiantes", method = RequestMethod.GET)
	public ResponseEntity<List<Estudiante>> autenticacion(){
		
		List<Estudiante> listaEstudiantes = estudDAO.findAll();
		return ResponseEntity.ok(listaEstudiantes);
		
		
	}
	
	
	@RequestMapping(value = "Estudiante", method = RequestMethod.GET)
	public ResponseEntity<Estudiante> getEstudianteId(@RequestParam("EstudianteId") Integer EstudianteId){
		Optional<Estudiante> optionalEstudiante = estudDAO.findById(EstudianteId);
		if(optionalEstudiante.isPresent()) {
			return ResponseEntity.ok(optionalEstudiante.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@RequestMapping(value = "AsignaturasEstudiante", method = RequestMethod.GET)
	public ResponseEntity<List<Asignatura>> getAsignaturaEstudiante(@RequestParam("idEstudiante") Integer idEstudiante){
		List<Asignatura> lstAsignaturasEstudiante = asignaturaServicio.asignaturaPendEstudiante(idEstudiante);
		return ResponseEntity.ok(lstAsignaturasEstudiante);
	}
	
	@RequestMapping(value = "AsignaturaEstudio/{planEstudio}", method = RequestMethod.GET)
	public ResponseEntity<List<Asignatura>> getAsignaturaPlanEstudio(@PathVariable("planEstudio") Integer planEstudio){
		List<Asignatura> lstAsignaturaPlanEstudio = asignaturaServicio.asignaturaXPlanEstudio(planEstudio);
		return ResponseEntity.ok(lstAsignaturaPlanEstudio);
	}
	
	@RequestMapping(value = "Grupos/{idAsignatura}", method = RequestMethod.GET)
	public ResponseEntity<List<Grupo>> getgruposByAsignatura(@PathVariable("idAsignatura") Integer idAsignatura){
		List<Grupo> lstGrupos = grupoServicio.findbyAsignatura(idAsignatura);
		return ResponseEntity.ok(lstGrupos);
	}

	
	@RequestMapping(value = "Horario/{idGrupo}", method = RequestMethod.GET)
	public ResponseEntity<List<Horario>> getHorarioByGrupo(@PathVariable("idGrupo") Integer idGrupo){
		List<Horario> lstHorario = horarioServicio.findbyGrupo(idGrupo);
		return ResponseEntity.ok(lstHorario);
	}
	
	
	@RequestMapping(value = "AsignaturasEstud/{idEstudiante}", method = RequestMethod.GET)
	public ResponseEntity<List<HorarioEstudiante>> getAsignaturaEstudiante2(@PathVariable("idEstudiante") Integer idEstudiante){
		List<HorarioEstudiante> lstAsignaturasEstudiante2 = horarioEstudianteServicio.getMateriasEstudiante(idEstudiante);
		return ResponseEntity.ok(lstAsignaturasEstudiante2);
	}
	
	@RequestMapping(value = "AsignaturasEstud/", method = RequestMethod.GET)
	public ResponseEntity<List<opcHorarioXEstudiante>> horarioEstudiante(@RequestParam("idEstudiante") Integer idEstudiante, @RequestParam("jornada") Integer jornada, @RequestParam("canMateria") Integer canMateria){
		List<opcHorarioXEstudiante> lstAsignaturasEstudiante2 = horarioEstudianteServicio.horarioEstudiante(idEstudiante, jornada);
		return ResponseEntity.ok(lstAsignaturasEstudiante2);
	}
	
	
}
