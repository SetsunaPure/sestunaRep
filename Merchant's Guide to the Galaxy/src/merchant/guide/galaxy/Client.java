package merchant.guide.galaxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.impl.Program;
import merchant.guide.galaxy.model.Context;

public class Client 
{
	/**
	 * 解析文档，实例化文档类，解析问题，并输出
	 * @param arg
	 * @throws IOException
	 */
	public static void main(String arg[]) throws IOException
	{
		File file = new File(Constant.FILE_PATH);
		InputStreamReader reader = null;
		FileInputStream fis = null;
		
		if(!file.exists())
		{
			System.out.print(Constant.FILE_NOT_EXSIT);
			return;
		}
		
		try
		{
			String lineTxt;
			List<String> lines = new ArrayList<String>();
			fis = new FileInputStream(file);
			reader = new InputStreamReader(fis, Constant.ENCODING);
			BufferedReader bufferdReader = new BufferedReader(reader);
			
			while((lineTxt = bufferdReader.readLine()) != null)
			{
				lines.add(lineTxt);
			}
			
			Context ctx = new Context();
			Program pg = new Program(ctx);
			pg.run(lines);
		}
		finally
		{
			fis.close();
			reader.close();
		}
	}	
}
