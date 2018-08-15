package merchant.guide.galaxy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.enums.RomanPrimitive;

/**
 * 银河数字和罗马数字转换的算法
 * @author Administrator
 *
 */
public class Roman 
{
	private List<RomanPrimitive> primitives;
	
	public Roman()
	{
		primitives = new ArrayList<RomanPrimitive>();
	}
	
	public int calculate()
	{
			int result = 0;
			int length = primitives.size();
			
			for(int i = 0 ; i< length; i++)
			{
				RomanPrimitive current = primitives.get(i);
				int currentVal = current.getValue();
				
				if (i == length - 1)
				{
					result += currentVal;
					return result;
				}
				int nextVal = primitives.get(i + 1).getValue();
				
				if(currentVal < nextVal)
				{
					result += -currentVal;
				}
				else if(currentVal == nextVal)
				{
					if (!current.getAllowRepeat())
						System.err.printf(Constant.CANNOT_REPEAT, current.getSymbol());
					
					int count = 2;
					for (int j = i + 1; j < length; j++)
					{
						if (primitives.get(j).getSymbol() != current.getSymbol())
						{
							break;
						}
						count ++;
						result += currentVal;
						
						if (count > 3)
						{
							System.err.printf(Constant.REPEAT_MOST, current.getSymbol());
						}
					}
				}
				else
				{
					result += currentVal;
				}
			}
		return result;
	}
	
	public static Roman parse(List<String> lst, Map<String, RomanPrimitive> map)
	{
		List<RomanPrimitive> lstRp = new ArrayList<RomanPrimitive>();
		for(String str: lst)
		{
			lstRp.add(map.get(str));
		}
		
		Roman roman = parse(lstRp);
		
		return roman;
	}
	
	private static Roman parse(List<RomanPrimitive> lst)
	{
		Roman roman = new Roman();
		for (int i = 0 ; i < lst.size(); i++)
		{
			roman.primitives.add(RomanPrimitive.parse(lst.get(i).getSymbol()));
		}
		
		return roman;
	}

}
