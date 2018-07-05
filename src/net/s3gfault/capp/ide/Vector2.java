package net.s3gfault.capp.ide;

public class Vector2
{
	public float x, y;
	
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2()
	{
		this (0, 0);
	}
	
	public void set(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		return String.format("[%f, %f]", x, y);
	}
}
