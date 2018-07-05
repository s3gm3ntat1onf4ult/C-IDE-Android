package net.s3gfault.capp.ide.editor.token;

import java.util.List;
import java.util.ArrayList;

public class Token
{
	private String token;
	private int start, end;
	
	public Token(String token, int start, int end)
	{
		this.token = token;
		this.start = start;
		this.end = end;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getToken()
	{
		return token;
	}

	public void setStart(int start)
	{
		this.start = start;
	}

	public int getStart()
	{
		return start;
	}

	public void setEnd(int end)
	{
		this.end = end;
	}

	public int getEnd()
	{
		return end;
	}

	@Override
	public String toString()
	{
		return String.format("[%s, %d, %d]", token, start, end);
	}
}
