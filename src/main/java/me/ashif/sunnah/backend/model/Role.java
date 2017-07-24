package me.ashif.sunnah.backend.model;

public class Role {
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] { ADMIN };
	}

}
