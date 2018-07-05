package net.s3gfault.capp.ide.headparser;

import java.io.InputStream;

public abstract class HeaderParser
{
	/*
		return Header obj containing variables, functions and structs
		of the file in
	*/
	public native static Header parse(InputStream in);
}
