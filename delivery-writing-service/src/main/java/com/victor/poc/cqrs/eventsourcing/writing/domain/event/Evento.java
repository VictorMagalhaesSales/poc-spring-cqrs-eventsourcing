package com.victor.poc.cqrs.eventsourcing.writing.domain.event;

public interface Evento {
	public String getStreamId();
	public String getEventName();
}
