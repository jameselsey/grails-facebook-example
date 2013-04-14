package com.jameselsey.demos.grailsfacebookexample

class AppRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
