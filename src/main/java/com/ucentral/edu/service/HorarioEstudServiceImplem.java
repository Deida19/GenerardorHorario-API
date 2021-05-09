package com.ucentral.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.AsigPendDaoImplen;
import com.ucentral.edu.dao.GrupoDaoImplem;
import com.ucentral.edu.dao.HorarioDaoImplem;
import com.ucentral.edu.entities.Asignatura;
import com.ucentral.edu.entities.Grupo;
import com.ucentral.edu.entities.GrupoHorario;
import com.ucentral.edu.entities.Horario;
import com.ucentral.edu.entities.HorarioEstudiante;
import com.ucentral.edu.entities.HorarioXEstudiante;
import com.ucentral.edu.entities.opcHorarioXEstudiante;
import com.ucentral.edu.entities.opcionHorario;
import com.ucentral.edu.entities.opcionXMateria;
import com.ucentral.edu.entities.opcionesHorario2;
@Service
public class HorarioEstudServiceImplem implements HorarioEstudianteServicio{

	List<HorarioEstudiante> lstMateriasEstudiante = new ArrayList<>();
	@Autowired
	AsigPendDaoImplen asigPendiente = new AsigPendDaoImplen();
	@Autowired
	GrupoDaoImplem grupoByAsignatura = new GrupoDaoImplem();
	@Autowired
	HorarioDaoImplem grupoHorario = new HorarioDaoImplem();
	
	
	@Override
	public List<HorarioEstudiante> getMateriasEstudiante(Integer idEstudiante) {

		List<Asignatura> lstAsignaturas = asigPendiente.asignaturaPendEstudiante(idEstudiante);
		 //
		for(int i = 0; i < lstAsignaturas.size(); i++) {
			List<GrupoHorario> lstGruposHorario = new ArrayList<>();
			HorarioEstudiante asignaturasEstudiante = new HorarioEstudiante();
			Integer idAsignatura = lstAsignaturas.get(i).getId();
			
			List<Grupo> lstGrupos = new ArrayList<Grupo>();
			lstGrupos = grupoByAsignatura.gruposXAsignatura(idAsignatura);
			asignaturasEstudiante.setId(idAsignatura);
			asignaturasEstudiante.setCodigo(lstAsignaturas.get(i).getCodigo());
			asignaturasEstudiante.setNombre(lstAsignaturas.get(i).getNombre());
			asignaturasEstudiante.setCreditos(lstAsignaturas.get(i).getCreditos());
			asignaturasEstudiante.setHoras(lstAsignaturas.get(i).getCant_Hora_Semana());
			asignaturasEstudiante.setTopologia(lstAsignaturas.get(i).getTipologia());
			asignaturasEstudiante.setPlanEstudio(lstAsignaturas.get(i).getId_Plan_Estudio());
			for (int j = 0; j < lstGrupos.size(); j++) {
				GrupoHorario grpHorario = new GrupoHorario();
				Integer idGrupo = lstGrupos.get(j).getId();
				List<Horario> lstHorario = grupoHorario.horarioByGrupo(idGrupo);
				grpHorario.setId(idGrupo);
				grpHorario.setCodigo(lstGrupos.get(j).getCodigo());
				grpHorario.setCapacidad(lstGrupos.get(j).getCapacidad());
				grpHorario.setDescripcion(lstGrupos.get(j).getDescripcion());
				grpHorario.setHorarios(lstHorario);
				lstGruposHorario.add(grpHorario);
			}
			asignaturasEstudiante.setLstGrupo(lstGruposHorario);
			lstMateriasEstudiante.add(asignaturasEstudiante);
		}
		return lstMateriasEstudiante;
	}

	@Override
	public List<HorarioEstudiante> getMateriasJornada(Integer idEstudiante, Integer jornada) {

	List<HorarioEstudiante> lstMateriasEst= new ArrayList<HorarioEstudiante>();
	List<HorarioEstudiante> lstMateriasEstJornada= new ArrayList<HorarioEstudiante>();
	
	GrupoHorario grpJornada = new GrupoHorario();
	
			lstMateriasEst = this.getMateriasEstudiante(idEstudiante);
			for (int i = 0; i < lstMateriasEst.size(); i++) {
				HorarioEstudiante asignaturasJorEstudiante = new HorarioEstudiante();
				List<GrupoHorario> lstGrpJornada = new ArrayList<GrupoHorario>();
				
				for(int j = 0; j < lstMateriasEst.get(i).lstGrupo.size(); j++) {
					String strHora = lstMateriasEst.get(i).lstGrupo.get(j).getHorarios().get(0).getHora_Inicio();
					Integer intHora = Integer.parseInt(strHora.substring(0, 2));
					if(jornada == 1) {
						if (lstMateriasEst.get(i).lstGrupo.get(j).getHorarios().get(0).getDia() != 6 && intHora < 18) {
							grpJornada = lstMateriasEst.get(i).lstGrupo.get(j);
							lstGrpJornada.add(grpJornada);
						}
					}else if(jornada == 2) {
						if (lstMateriasEst.get(i).lstGrupo.get(j).getHorarios().get(0).getDia() != 6 && intHora >= 18) {
							grpJornada = lstMateriasEst.get(i).lstGrupo.get(j);
							lstGrpJornada.add(grpJornada);		
						}
					}else {
						grpJornada = lstMateriasEst.get(i).lstGrupo.get(j);
						lstGrpJornada.add(grpJornada);	
					}
					
				}
				
				if (lstGrpJornada.size() == 0) {
					lstMateriasEstJornada.remove(asignaturasJorEstudiante);
				}else {
				asignaturasJorEstudiante.setCodigo(lstMateriasEst.get(i).getCodigo());
				asignaturasJorEstudiante.setCreditos(lstMateriasEst.get(i).getCreditos());
				asignaturasJorEstudiante.setHoras(lstMateriasEst.get(i).getHoras());
				asignaturasJorEstudiante.setId(lstMateriasEst.get(i).getId());
				asignaturasJorEstudiante.setNombre(lstMateriasEst.get(i).getNombre());
				asignaturasJorEstudiante.setPlanEstudio(lstMateriasEst.get(i).getPlanEstudio());
				asignaturasJorEstudiante.setTopologia(lstMateriasEst.get(i).getTopologia());
				asignaturasJorEstudiante.setLstGrupo(lstGrpJornada);
				lstMateriasEstJornada.add(asignaturasJorEstudiante);
			}
			}
			
		return lstMateriasEstJornada;
	}

	@Override
	public List<opcHorarioXEstudiante> horarioEstudiante(Integer idEstudiante, Integer jornada) {

		opcionesHorario2 opcHorario = new opcionesHorario2();
		HorarioEstudiante newHorarioEstudiante = new HorarioEstudiante();
		List<HorarioEstudiante> newListHorario =  null;
		List<List<HorarioEstudiante>> horarioEstudianteFinal = new ArrayList<>();

		List<HorarioEstudiante> horarioEstudiante = this.getMateriasJornada(idEstudiante, jornada);
		boolean valida = false;
		for(int i = 0; i < horarioEstudiante.size(); i++) {
			List<HorarioEstudiante> horarioEstudiante2 = new ArrayList<HorarioEstudiante>();
		
				newHorarioEstudiante = horarioEstudiante.get(i);
				horarioEstudiante2.add(newHorarioEstudiante);
				
				for(int j = 0; j < horarioEstudiante.size(); j++) {
					valida = true;
					if (j != i) {
						int p = 0;
						int cantHorarios = horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().size();
						while(p < cantHorarios && valida) {
							Horario horario2 = new Horario();
							horario2.setDia(horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().get(p).getDia());
							horario2.setHora_Inicio(horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().get(p).getHora_Inicio());
							boolean exist = false;
							for(int k = 0; k < horarioEstudiante2.size(); k++) {
								for(int h = 0; h < horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().size(); h++) {
									if(horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().get(h).getDia().equals(horario2.getDia()) && horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().get(h).getHora_Inicio().equals(horario2.getHora_Inicio())) {
										exist = true;
									}
								}
								
							}
							if (exist) {
								valida = false;
							}else {
								valida = true;
							}
							p++;
						}
						if (valida) {
							newHorarioEstudiante = horarioEstudiante.get(j);
							horarioEstudiante2.add(newHorarioEstudiante);
						}
					}
				}
				newListHorario = horarioEstudiante2;
				horarioEstudianteFinal.add(newListHorario);
			
		}
		
		List<opcHorarioXEstudiante> listOpcionHorario2 = new ArrayList<opcHorarioXEstudiante>();
		int idHorar = 1;
		for(int hor = 0; hor < horarioEstudianteFinal.size(); hor++) {
			
			opcHorarioXEstudiante opcHorario2;
			int lisMateria = horarioEstudianteFinal.get(hor).size();
			List<opcionXMateria> lstOpcXMateria = new ArrayList<opcionXMateria>();
			for (int mat = 0; mat < lisMateria; mat++) {
				opcionXMateria opcMateria;
				
				int idMateria = horarioEstudianteFinal.get(hor).get(mat).getId();
				String nomMateria = horarioEstudianteFinal.get(hor).get(mat).getNombre();
				int idGrupo = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getId();
				String nombreGrupo = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getDescripcion();
				int lsHorario = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getHorarios().size();
				
				String dia1 = "", dia2 = "", dia3 = "", dia4 = "", dia5 = "", dia6 = " ";
				String horaI1 = "", horaF1 = "", horaI2 = "", horaF2 = "", horaI3 = "", horaF3 = "", horaI4 = "", horaF4 = "", horaI5 = "", horaF5 = "", horaI6 = "", horaF6 = " ";
				for(int dias = 0; dias < lsHorario; dias++) {
					
					int dia = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getHorarios().get(dias).getDia();
					String horaIni = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getHorarios().get(dias).getHora_Inicio();
					String horaFin = horarioEstudianteFinal.get(hor).get(mat).getLstGrupo().get(0).getHorarios().get(dias).getHora_Fin();
					switch (dia) {
					case 1: 
						dia1 = "Lunes";
						horaI1 = horaIni;
						horaF1 = horaFin;
						break;
					case 2:
						dia2 = "Martes";
						horaI2 = horaIni;
						horaF2 = horaFin;
						break;
					case 3:
						dia3 = "Miercoles";
						horaI3 = horaIni;
						horaF3 = horaFin;
						break;
					case 4:
						dia4 = "Jueves";
						horaI4 = horaIni;
						horaF4 = horaFin;
						break;
					case 5:
						dia5 = "Viernes";
						horaI5 = horaIni;
						horaF5 = horaFin;
						break;
					case 6:
						dia6 = "Sabado";
						horaI6 = horaIni;
						horaF6 = horaFin;
						break;
					}
				}
				opcMateria = new opcionXMateria(idMateria, nomMateria, idGrupo, nombreGrupo, dia1, horaI1, horaF1, dia2, horaI2, horaF2, dia3, horaI3, horaF3, dia4, horaI4, horaF4, dia5, horaI5, horaF5, dia6, horaI6, horaF6);
				lstOpcXMateria.add(opcMateria);
			}
			
			opcHorario2 = new opcHorarioXEstudiante(idHorar, lstOpcXMateria);
			listOpcionHorario2.add(opcHorario2);
			idHorar = idHorar + 1;
		}
		//return horarioEstudianteFinal;
		return listOpcionHorario2;
	}

	@Override
	public List<List<HorarioEstudiante>> horarioEstudiantes(Integer idEstudiante, Integer jornada) {

		opcionesHorario2 opcHorario = new opcionesHorario2();
		HorarioEstudiante newHorarioEstudiante = new HorarioEstudiante();
		List<HorarioEstudiante> newListHorario =  null;
		List<List<HorarioEstudiante>> horarioEstudianteFinal = new ArrayList<>();

		List<HorarioEstudiante> horarioEstudiante = this.getMateriasJornada(idEstudiante, jornada);
		boolean valida = false;
		for(int i = 0; i < horarioEstudiante.size(); i++) {
			List<HorarioEstudiante> horarioEstudiante2 = new ArrayList<HorarioEstudiante>();
		
				newHorarioEstudiante = horarioEstudiante.get(i);
				horarioEstudiante2.add(newHorarioEstudiante);
				
				for(int j = 0; j < horarioEstudiante.size(); j++) {
					valida = true;
					if (j != i) {
						int p = 0;
						int cantHorarios = horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().size();
						while(p < cantHorarios && valida) {
							Horario horario2 = new Horario();
							horario2.setDia(horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().get(p).getDia());
							horario2.setHora_Inicio(horarioEstudiante.get(j).getLstGrupo().get(0).getHorarios().get(p).getHora_Inicio());
							boolean exist = false;
							for(int k = 0; k < horarioEstudiante2.size(); k++) {
								for(int h = 0; h < horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().size(); h++) {
									if(horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().get(h).getDia().equals(horario2.getDia()) && horarioEstudiante2.get(k).getLstGrupo().get(0).getHorarios().get(h).getHora_Inicio().equals(horario2.getHora_Inicio())) {
										exist = true;
									}
								}
								
							}
							if (exist) {
								valida = false;
							}else {
								valida = true;
							}
							p++;
						}
						if (valida) {
							newHorarioEstudiante = horarioEstudiante.get(j);
							horarioEstudiante2.add(newHorarioEstudiante);
						}
					}
				}
				newListHorario = horarioEstudiante2;
				horarioEstudianteFinal.add(newListHorario);
			
		}
		
		return horarioEstudianteFinal;
	}

	
	
	

}
