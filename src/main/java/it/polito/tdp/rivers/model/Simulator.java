package it.polito.tdp.rivers.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class Simulator {
	LinkedList<Flow> queue ;
    double Q;
    double C;
    Integer K;
    Model model;
    double fmin;
    int giorniSecca;
    int cont;
    double sommaC;
   // Map<Flow,Double> mappa;
	public void init(LinkedList<Flow> flow,Integer k, double mediaF) {
		queue=new LinkedList<Flow>();
		this.K=k;
		giorniSecca=0;
		cont=0;
		sommaC=0;
		Q=K*30*mediaF;
		C=Q/2;
		for(Flow f: flow)
			queue.add(f);
		//mappa=new HashMap<Flow,Double>();
		fmin=0.8*mediaF;
	}

	public void run() {
		for(Flow f:queue) {
			double fout=fmin;
		//	mappa.put(queue.poll(), )
			if(Math.random()*100<=5)
				fout=10*fmin;
			C=C+f.getFlow()-fout;
			if(C<0)
				C=0;
			if(C>Q) {
				fout=fout+C-Q;
				C=Q;}
			if(fout<fmin)
				giorniSecca++;
			sommaC=sommaC+C;
			cont++;			
			}
		}
	
	public double capacitaMedia() {
		return sommaC/cont;
	}

	public int getGiorniSecca() {
		return giorniSecca;
	}

	public void setGiorniSecca(int giorniSecca) {
		this.giorniSecca = giorniSecca;
	}
	
}
