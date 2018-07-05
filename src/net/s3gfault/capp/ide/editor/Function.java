package net.s3gfault.capp.ide.editor;

public class Function
{
	private String name, parameters, ret; // RETurn value
	
	public Function(String ret, String name, String parameters)
	{
		this.name = name;
		this.parameters = parameters;
		this.ret = ret;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setParameters(String parameters)
	{
		this.parameters = parameters;
	}

	public String getParameters()
	{
		return parameters;
	}

	public void setRet(String ret)
	{
		this.ret = ret;
	}

	public String getRet()
	{
		return ret;
	}

	@Override
	public String toString()
	{
		return String.format("%s %s %s", ret, name, parameters);
	}
}
