package net.s3gfault.capp.ide.editor;
import android.widget.EditText;
import net.s3gfault.capp.HelloJni;
import android.widget.Toast;

public class AnalyzerThread extends Thread
{
	private EditText editor;
	public volatile boolean running = false;
	String text;
	
	public AnalyzerThread(EditText editor)
	{
		this.editor = editor;
	}
	
	@Override
	public void run()
	{
		while (running)
		{
			text = editor.getText().toString();
			
			try
			{
				sleep(100);
			}
			catch (InterruptedException e)
			{}
		}
	}
}
