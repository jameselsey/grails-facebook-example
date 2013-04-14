package com.jameselsey.demos.grailsfacebookexample

import com.jameselsey.demos.grailsfacebookexample.User

class FacebookUser {

	long uid
  String accessToken
  Date accessTokenExpires

	static belongsTo = [user: User]

	static constraints = {
		uid unique: true
	}
}
