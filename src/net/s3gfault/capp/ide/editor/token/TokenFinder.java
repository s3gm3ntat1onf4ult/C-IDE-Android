package net.s3gfault.capp.ide.editor.token;

import java.util.ArrayList;
import java.util.List;

public abstract class TokenFinder
{
	public static List<Character> WORD_DELIMETER = new ArrayList<Character>();
	public static List<Character> ESCAPE_DELIMETER = new ArrayList<Character>();
	
	public static List<Token> findTokens(List<Character> delimeters, String source)
	{
		List<Token> tokens = new ArrayList<Token>();
		char c = '\0';
		String word = new String();
		int lenght = source.length();
		
		main:for (int i = 0; i < lenght; i++)
		{
			c = source.charAt(i);
			
			for (Character ch : ESCAPE_DELIMETER)
			{
				if (c == ch)
					continue main;
			}
			
			if (delimeters.contains(c)) // word delimeter found
			{
				if (word.length() <= 1)
				{
					word = "";
					continue;
				}
					
				Token t = new Token(word, i - word.length(), i - 1);
				tokens.add(t);
				word = "";
				continue;
			}
			
			word += c;
		}
		
		return tokens;
	}
	
	public static Token findTokenAtEnd(List<Character> delimeters, String source, int pos)
	{
		char c = '\0';
		String word = new String();
		Token ret = null;
		
		main:for (int i = pos - 1; i >= 0; i--)
		{
			if (source.length() <= 0)
				break;
			
			c = source.charAt(i);
			
			for (Character ch : ESCAPE_DELIMETER)
			{
				if (c == ch)
					continue main;
			}
			
			if (delimeters.contains(c) || i == 0)
			{
//				if (word.length() <= 1)
//				{
//					word = "";
//					continue;
//				}
				
				if (i == 0)
					word += source.charAt(i);
				
				ret = new Token(reverse(word), i - word.length(), i - 1);
				break;
			}
			
			word += c;
		}
		
		return ret;
	}
	
	public static void initLists()
	{
		WORD_DELIMETER.add(' '); WORD_DELIMETER.add('{'); WORD_DELIMETER.add('(');
		WORD_DELIMETER.add('\n'); WORD_DELIMETER.add(';'); WORD_DELIMETER.add('\t');
		
		ESCAPE_DELIMETER.add(')'); ESCAPE_DELIMETER.add('}');
	}
	
	private static String reverse(String str)
	{
		return new StringBuilder(str).reverse().toString();
	}
}
