package resources;

public enum Themes {
	carSpace("CarSpace"),
	light("Light"),
	grey("Grey"),
	dark("Dark"),
	transparentLight("Transparent Light"),
	transparentGrey("Transparent Grey"),
	transparentDark("Transparent Dark");
	
	private String theme;

	Themes(String theme) {
		this.theme = theme;
	}
	
	public String theme() {
		return theme;
	}
}
