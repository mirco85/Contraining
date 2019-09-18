package it.contrader.model;

public class Category {
	
	private int id;
	private String argument;
	
	
	
	public Category() {
		super();
	}



	public Category(String argument) {
		super();
		this.argument = argument;
	}



	public Category(int id, String argument) {
		super();
		this.id = id;
		this.argument = argument;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getArgument() {
		return argument;
	}



	public void setArgument(String argument) {
		this.argument = argument;
	}



	@Override
	public String toString() {
		return "id" +"\t"  + " argument";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (argument == null) {
			if (other.argument != null)
				return false;
		} else if (!argument.equals(other.argument))
			return false;
		return true;
	}
	
	
	

}
