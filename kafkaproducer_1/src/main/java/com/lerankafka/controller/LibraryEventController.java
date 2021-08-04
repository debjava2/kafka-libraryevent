package com.lerankafka.controller;






import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lerankafka.domain.Book;
import com.lerankafka.domain.LibraryEvent;
import com.lerankafka.producer.LibrararyEventProducer;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryEventController {
	
	@Autowired
	LibrararyEventProducer libEventProducer;
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LibraryEventController.class);
	@SuppressWarnings("restriction")
	@PostMapping("/v1/libraryevent")
	public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libEvent) throws Exception{
		
		log.info("Before Sending Message");
		libEventProducer.sendLibraryEvent(libEvent);//Non Syncronus Call
		//libEventProducer.sendLibrarayEventSyncronus(libEvent);//For Syncronus call
		
		log.info("After  Sending Message");
		return ResponseEntity.status(HttpStatus.CREATED).body(libEvent);
	}
	
	
}
