package net.s3gfault.capp.ide.headparser;

public class Variable
{
	private String name, type;
	
	public Variable(String name, String type)
	{
		this.name = name;
		this.type = type;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return type + " " + name;
	}
}
