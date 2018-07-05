package net.s3gfault.capp.ide.editor;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import net.s3gfault.capp.HelloJni;
import net.s3gfault.capp.R;
import net.s3gfault.capp.ide.EditorUtils;
import net.s3gfault.capp.ide.Vector2;

public class CodeCompletion extends PopupWindow
{
	private ArrayAdapter<String> listComp;
	
	private ListView completionList;
	private Context ctx;
	private EditText editor;

	public int width = 600, height = 100;

	public CodeCompletion(Context ctx, EditText editor)
	{
		this.ctx = ctx;
		listComp = new ArrayAdapter<String>(ctx, R.layout.completion_list_item);
		loadAdapter();
		completionList = new ListView(ctx);
		completionList.setBackgroundColor(Color.GRAY);
		completionList.setAdapter(listComp);
		this.editor = editor;
		setContentView(completionList);
		setWidth(width);
		setHeight(height);
	}
	
	public ArrayAdapter<String> getAdapter()
	{
		return listComp;
	}

	@Override
	public void showAtLocation(View parent, int gravity, int x, int y)
	{
		super.showAtLocation(parent, gravity, x, y);
	}

	public void show()
	{
		Vector2 pos = EditorUtils.getCursorPos(editor);
		View window = HelloJni.CTX.getWindow().getDecorView();
		int yPos = 0;
		
		if (pos.y + height + 37 < 308)
			yPos = (int) (pos.y) + height + 37; // 308
		else
			yPos = 308 - height - 37;

		showAtLocation(window, Gravity.NO_GRAVITY, (int)pos.x, yPos);
	}

	public List<Function> loadHeaderFunctions(String headerName)
	{
		List<Function> functions = new ArrayList<Function>();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader((ctx.getAssets().open(headerName))));
			String line = null;

			while ((line = br.readLine()) != null)
			{
				String[] values = line.split("#");
				Function f = new Function(values[0], values[1], values[2]);
				functions.add(f);
			}
			br.close();
			return functions;
		}
		catch (IOException e)
		{
			// file not found
			return null;
		}
	}

	public List<String> filter(String filterName)
	{
		List<String> lst = new ArrayList<String>();

		for (int i = 0; i < listComp.getCount(); i++)
		{
			String name = listComp.getItem(i);

			if (name.startsWith(filterName))
				lst.add(name);
		}

		return lst;
	}

	private void loadAdapter()
	{
		List<Function> funcs = loadHeaderFunctions("stdio.txt");

		for (int i = 0; i < funcs.size(); i++)
		{
			Function f = funcs.get(i);
			listComp.add((f.getName() + f.getParameters()).trim());
		}
	}
}
