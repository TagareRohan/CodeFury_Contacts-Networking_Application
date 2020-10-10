package com.training.utils;

import java.util.Comparator;

import com.training.models.Person;

public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.getFullName().compareToIgnoreCase(p2.getFullName());
	}
}
