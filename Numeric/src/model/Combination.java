package model;

public class Combination
{
	
	private String[] options;
	
	public Combination( String ... options )
	{
		this.options = options;
	}
	
	public String getOption( int number )
	{
		return this.options[ number ];
	}
	
}
