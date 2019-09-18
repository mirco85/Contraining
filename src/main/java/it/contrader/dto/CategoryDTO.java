package it.contrader.dto;

public class CategoryDTO {
	
	
	private int id;
	private String argument;
	
	
	
	public CategoryDTO() {
		super();
	}



	public CategoryDTO(String argument) {
		super();
		this.argument = argument;
	}



	public CategoryDTO(int id, String argument) {
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
		return "id" +  "\t" + "argument";
	}
	
	
	

}
