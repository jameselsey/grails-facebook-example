package com.jameselsey.demos.grailsfacebookexample

import org.apache.commons.lang.builder.HashCodeBuilder

class UserAppRole implements Serializable {

	User user
	AppRole appRole

	boolean equals(other) {
		if (!(other instanceof UserAppRole)) {
			return false
		}

		other.user?.id == user?.id &&
			other.appRole?.id == appRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (appRole) builder.append(appRole.id)
		builder.toHashCode()
	}

	static UserAppRole get(long userId, long appRoleId) {
		find 'from UserAppRole where user.id=:userId and appRole.id=:appRoleId',
			[userId: userId, appRoleId: appRoleId]
	}

	static UserAppRole create(User user, AppRole appRole, boolean flush = false) {
		new UserAppRole(user: user, appRole: appRole).save(flush: flush, insert: true)
	}

	static boolean remove(User user, AppRole appRole, boolean flush = false) {
		UserAppRole instance = UserAppRole.findByUserAndAppRole(user, appRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(User user) {
		executeUpdate 'DELETE FROM UserAppRole WHERE user=:user', [user: user]
	}

	static void removeAll(AppRole appRole) {
		executeUpdate 'DELETE FROM UserAppRole WHERE appRole=:appRole', [appRole: appRole]
	}

	static mapping = {
		id composite: ['appRole', 'user']
		version false
	}
}
