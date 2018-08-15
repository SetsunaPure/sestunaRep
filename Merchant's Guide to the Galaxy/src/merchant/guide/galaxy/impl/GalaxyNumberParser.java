package merchant.guide.galaxy.impl;

import java.util.HashMap;
import java.util.Map;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.enums.RomanPrimitive;
import merchant.guide.galaxy.inf.Parser;
import merchant.guide.galaxy.model.Context;

/**
 * 解析银河数字语句
 * @author Administrator
 *
 */
public class GalaxyNumberParser extends Filter implements Parser
{
	private Context context;
	
	public GalaxyNumberParser(Context context)
	{
		this.context = context;
	}


	@Override
	public Boolean parse(String input)
	{
		if (isEndWithMark(input))
			return false;
		
		String[] lexers = input.split(Constant.IS);
		if(lexers.length != Constant.PRIMITIVE_CONTEXT_LENGTH )
			return false;
		
		if(lexers[1].length() > Constant.METALS_LENGTH)
			return false;
		
		RomanPrimitive roman = RomanPrimitive.parse(lexers[1]);
		
		if (roman == null)
		{
			System.err.print(Constant.SYNTXT_ERROR);
		}
		
		String name = lexers[0].trim();
		
		Map<String, RomanPrimitive> primitives = context.getGalaxyRoman() == null
				? new HashMap<String, RomanPrimitive>() : context.getGalaxyRoman();
				
		primitives.put(name, roman);
		
		context.setGalaxyRoman(primitives);
		
		return true;
	}
	
	
	
}
