package merchant.guide.galaxy.impl;

import java.util.Arrays;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.inf.Solver;
import merchant.guide.galaxy.model.Context;

/*
 * 处理银河数字算法
 */
public class GalaxyNumberSolver implements Solver
{
	private Context context;
	
	public GalaxyNumberSolver(Context context)
	{
		this.context = context;
	}

	@Override
	public Boolean solve(String question) 
	{
		String qulifier = Constant.HOW_MUCH_IS;
		if (!question.startsWith(qulifier))
			return false;

		String body = question.substring(qulifier.length() + 1);
		
		String[] lexers = body.split(Constant.BLANK);
		
		Integer value = Roman.parse(Arrays.asList(lexers), context.getGalaxyRoman()).calculate();

		StringBuilder sb = new StringBuilder();
		sb.append(body).append(Constant.IS_BLANK).append(value.toString()).append(Constant.DOT);
		System.out.println(sb.toString());
		
		return true;
	}
	


}
