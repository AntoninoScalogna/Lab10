package it.polito.tdp.rivers.model;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
 
	Map<Integer,River> mappaFiumi;
	Simulator simulatore;
	public Model() {
		mappaFiumi=new HashMap<Integer,River>();
		simulatore=new Simulator();
	}
	RiversDAO dao=new RiversDAO();

	public LinkedList<Flow> getFlows(Integer river){
		LinkedList<Flow> result=dao.getAllFlows(river);
		return result;
	}
	
	public Map<Integer,River> getRivers(){
		dao.getAllRivers(mappaFiumi);
		return mappaFiumi;
	}
	public Date getUltimaData(LinkedList<Flow> flow) {
		Date result=new Date();
		String s="0000-00-00";
		for(Flow f:flow) {
			if(f.getDay().toString().compareTo(s)>0) {
				result=f.getDay();
				s=f.getDay().toString();
			}
		}
		return result;
	}
	public Date getPrimaData(LinkedList<Flow> flow) {
		Date result=new Date();
		String s="9999-00-00";
		for(Flow f:flow) {
			if(f.getDay().toString().compareTo(s)<0) {
				result=f.getDay();
			s=f.getDay().toString();
		
		}}
		return result;
	}
	public double calcolaMedia(LinkedList<Flow> flow) {
		double somma=0.0;
		Integer nFlow=0;
		for(Flow f:flow) {
			somma=somma+f.getFlow();
			nFlow++;
		}
		return somma/nFlow;
	}
	public void simula(LinkedList<Flow> flow,Integer k) {
		simulatore.init(flow, k,calcolaMedia(flow));
		simulatore.run();
	}
	public Integer giorniSecca() {
		return simulatore.getGiorniSecca();
	}
	public double cMedia() {
		return simulatore.capacitaMedia();
	}
	

}
