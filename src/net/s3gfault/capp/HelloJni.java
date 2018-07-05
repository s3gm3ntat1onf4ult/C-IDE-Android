/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.s3gfault.capp;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.Toast;
import net.s3gfault.capp.ide.editor.AnalyzerThread;
import net.s3gfault.capp.ide.editor.CodeCompletion;
import net.s3gfault.capp.ide.editor.EditorTextWatcher;
import net.s3gfault.capp.ide.editor.token.Token;
import net.s3gfault.capp.ide.editor.token.TokenFinder;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.content.Intent;
import net.s3gfault.capp.ide.TerminalActivity;
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760


public class HelloJni extends Activity
{
	public static int DISPLAY_WIDTH, DISPLAY_HEIGHT, KEYBOARD_HEIGHT;
	
	public static CodeCompletion codeCompletion = null;

	private EditText codeEditor;
	private EditorTextWatcher textWatcher;

	public static Activity CTX;

	private AnalyzerThread analyzer;

	public static boolean loadedView = false;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		CTX = this;

		Point size = new Point();
		getWindowManager().getDefaultDisplay().getSize(size);
		DISPLAY_WIDTH = size.x;
		DISPLAY_HEIGHT = size.y;
		
		setContentView(R.layout.main);
		
		View v = getWindow().getDecorView();
		Rect r = new Rect();
		v.getWindowVisibleDisplayFrame(r);
		Toast.makeText(this, "" + r.bottom, Toast.LENGTH_LONG).show();
						
		codeEditor = (EditText) findViewById(R.id.edCodeEditor);
		
		codeEditor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
				public void onGlobalLayout()
				{
					//int heightDiff = codeEditor.getRootView().getHeight() - codeEditor.getHeight();
					Rect r = new Rect();
					View view = getWindow().getDecorView();
					view.getWindowVisibleDisplayFrame(r);
					KEYBOARD_HEIGHT = r.top;
				}
			});

		textWatcher = new EditorTextWatcher(codeEditor);
		codeEditor.addTextChangedListener(textWatcher);

		loadedView = true;
		//init();
		TokenFinder.initLists();
		codeCompletion = new CodeCompletion(this, codeEditor);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		
		Intent s = new Intent(this, TerminalActivity.class);
		startActivity(s);
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760
=======
>>>>>>> 4aa1e3ec408627f1eb5645acf97df45aca208760
    }

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
			case KeyEvent.KEYCODE_TAB:
				codeEditor.getText().insert(codeEditor.getSelectionStart(), "\t");
				//codeEditor.requestFocus();
				break;
			case KeyEvent.KEYCODE_ESCAPE:
				if (!codeCompletion.isShowing())
				{
					Token t = TokenFinder.findTokenAtEnd(TokenFinder.WORD_DELIMETER, codeEditor.getText().toString(), codeEditor.getSelectionStart());
					if (t != null)
						codeCompletion.getAdapter().getFilter().filter(t.getToken());
					codeCompletion.show();
					textWatcher.allowCompletion = !textWatcher.allowCompletion;
				}
				else
				{
					codeCompletion.dismiss();
					textWatcher.allowCompletion = false;
				}

				break;
		}

		return super.onKeyUp(keyCode, event);
	}

	@Override
	protected void onDestroy()
	{
//		analyzer.running = false;
//		
//		boolean tryy = true;
//		while (tryy)
//		{
//			try
//			{
//				analyzer.join();
//				tryy = false;
//			}
//			catch (InterruptedException e)
//			{
//				tryy = true;
//			}
//		}

		super.onDestroy();
	}

    public native String  stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }

	private void init()
	{
		analyzer = new AnalyzerThread(codeEditor);
		analyzer.running = true;
		if (loadedView)
			analyzer.start();
	}
}
