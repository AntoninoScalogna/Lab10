package it.polito.tdp.rivers.model;

import java.time.LocalTime;

public class Event {

	Flow flow;
	enum EventType{
		TRACIMAZIONE,
		AUMENTO_C,
		IRRIGAZIONE_FALLITA
	}
	private LocalTime time;
	EventType type;
}
