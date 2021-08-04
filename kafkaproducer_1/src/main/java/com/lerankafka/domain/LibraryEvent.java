package com.lerankafka.domain;






public class LibraryEvent {
	
	private Integer libraryEvent;
	private Book book;
	public Integer getLibraryEvent() {
		return libraryEvent;
	}
	public void setLibraryEvent(Integer libraryEvent) {
		this.libraryEvent = libraryEvent;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
