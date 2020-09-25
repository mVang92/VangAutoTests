package resources;

public enum Roles {
	USER("User"),
	TEST_USER("Test User"),
	ADMINIATRATOR("Administrator");

	private String role;

	Roles(String role) {
		this.role = role;
	}

	public String role() {
		return role;
	}

	@Override
	public String toString() {
		return role;
	}
}
