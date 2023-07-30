package com.example.poems_app.xml;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Text {

	@OneToOne
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
