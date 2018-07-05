package net.s3gfault.capp.ide;

import android.widget.EditText;
import android.text.Layout;
import android.app.Activity;
import android.app.AlertDialog;

public class EditorUtils
{
	public static Vector2 getCursorPos(EditText editor)
	{
		Vector2 vec = new Vector2();
		
		int pos = editor.getSelectionStart();
		Layout layout = editor.getLayout();
		int line = layout.getLineForOffset(pos);
		int baseline = layout.getLineBaseline(line);
		int ascent = layout.getLineAscent(line);
		float x = layout.getPrimaryHorizontal(pos);
		float y = baseline + ascent;
		
		vec.set(x, y);
		
		return vec;
	}
	
	public static void showAlert(Activity ctx, String title, String message)
	{
		AlertDialog.Builder ab = new AlertDialog.Builder(ctx);
		ab.setTitle(title);
		ab.setMessage(message);
		ab.setPositiveButton("Ok", null);
		ab.show();
	}
}
