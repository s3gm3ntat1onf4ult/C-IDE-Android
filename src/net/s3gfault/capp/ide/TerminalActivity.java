package net.s3gfault.capp.ide;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import java.io.InputStream;
import java.io.FileInputStream;
import android.widget.Toast;

public class TerminalActivity extends Activity
{
	private static final String TAG = "TerminalActivity";

	public boolean isRunning = false;
	public TermView termView;
	public ShellTermSession shell = new ShellTermSession();
	public String workdir;

	public Handler mMsgHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		TermView term = new TermView(this, shell, dm);
		setContentView(term);
	}

//	private ShellTermSession createShellTermSession() {
//        this.cmdline = this.cmdline.replaceAll("\\s+", " ");
//        Log.i(TAG, "Shell sesion for " + this.cmdline + "\n");
//        String[] envp = new String[]{"TMPDIR=" + Environment.getExternalStorageDirectory().getPath(), "PATH=" + "/sbin:/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin", "ANDROID_ASSETS=/system/app", "ANDROID_BOOTLOGO=1", "ANDROID_DATA=/data", "ANDROID_ROOT=/system", "HOME=/sdcard", "SHELL=/system/bin/sh", "TERM=xterm", "PS1=$ "};
//        String[] argv = this.cmdline.split("\\s+");
//        Log.i(TAG, "argv " + argv[0]);
//        Log.i(TAG, "envp " + envp);
//        this.isRunning = true;
//
//        return new ShellTermSession(argv, envp, this.workdir, this.mMsgHandler);
//    }
}
