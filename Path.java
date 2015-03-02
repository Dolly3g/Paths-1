class Path {
	private String from;
	private String to;
	public Path(String from,String to){
		this.from=from;
		this.to=to;
	}
	public boolean equals(Path path){
		return this.from==path.from && this.to==path.to;
	}
}