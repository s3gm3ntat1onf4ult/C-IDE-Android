package net.s3gfault.capp.ide.editor;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import net.s3gfault.capp.ide.editor.token.Token;
import net.s3gfault.capp.ide.editor.token.TokenFinder;
import net.s3gfault.capp.HelloJni;

public class EditorTextWatcher implements TextWatcher
{
	private EditText editor;
	public boolean allowCompletion = false;
	
	public EditorTextWatcher(EditText editor)
	{
		this.editor = editor;
	}
	
	@Override
	public void beforeTextChanged(CharSequence text, int start, int count, int after)
	{
		
	}

	@Override
	public void onTextChanged(CharSequence text, int start, int before, int count)
	{
		editor.requestFocus(); // prevent lose focus when tab pressed
	}

	@Override
	public void afterTextChanged(Editable ed)
	{
		if (allowCompletion)
		{
			Token t = TokenFinder.findTokenAtEnd(TokenFinder.WORD_DELIMETER, ed.toString(), editor.getSelectionStart());
			
			if (t != null)
				HelloJni.codeCompletion.getAdapter().getFilter().filter(t.getToken());
				
			if (!HelloJni.codeCompletion.isShowing())
				HelloJni.codeCompletion.show();
			else
			{
				HelloJni.codeCompletion.dismiss();
				HelloJni.codeCompletion.show();
			}
		}
	}
}
