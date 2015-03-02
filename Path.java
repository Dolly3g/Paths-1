class Path {
	private String from;
	private String to;
	public Path(String from,String to){
		this.from=from;
		this.to=to;
	}
	@Override
	public boolean equals(Object p){
		Path path = (Path)p;
		return (this.to==path.to)&&(this.from==path.from);
	}
}