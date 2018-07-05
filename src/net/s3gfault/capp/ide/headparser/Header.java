package net.s3gfault.capp.ide.headparser;

import net.s3gfault.capp.ide.editor.Function;

public class Header
{
	public Variable[] variables;
	public Function[] functions;
	public Struct[] structs;
	
	public Header(Variable[] variables, Function[] functions, Struct[] structs)
	{
		this.variables = variables;
		this.functions = functions;
		this.structs = structs;
	}
	
	public Header(Variable[] variables)
	{
		this.variables = variables;
	}
	
	public Header(Function[] functions)
	{
		this.functions = functions;
	}
	
	public Header(Struct[] structs)
	{
		this.structs = structs;
	}
	
	public void addVariable(Variable var) {}
	public void addFunction(Function func) {}
	public void addStruct(Struct stru) {}
}
