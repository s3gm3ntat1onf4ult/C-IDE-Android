package net.s3gfault.capp.ide;

import jackpal.androidterm.emulatorview.TermSession;
import android.content.Context;
import android.util.DisplayMetrics;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;

public class ShellTermSession extends TermSession
{
	private ParcelFileDescriptor mFd;
	
	public ShellTermSession()
	{
		try
		{
			mFd = ParcelFileDescriptor.open(new File("/dev/ptmx"), ParcelFileDescriptor.MODE_READ_WRITE);
		}
		catch (FileNotFoundException e)
		{}
		setTermIn(new ParcelFileDescriptor.AutoCloseInputStream(mFd));
		setTermOut(new ParcelFileDescriptor.AutoCloseOutputStream(mFd));
	}
}
