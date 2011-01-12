package ie.tcd.AESOP.test;

import java.util.Date;

//Super class for all motions
public class Event {
	String type;
	String content;
	Date timestamp;

	public Event(String type, String content) {
		this.type = type;
		this.content = content;
		this.timestamp = new Date();
	}

	public Event(String name) {
		this.type = name;
		this.content = "";
		this.timestamp = new Date();
	}

	public String to_string() {
		return type + " : " + content + " : " + timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
