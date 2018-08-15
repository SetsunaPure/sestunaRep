package merchant.guide.galaxy.impl;

import java.text.DecimalFormat;
import java.util.Arrays;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.inf.Solver;
import merchant.guide.galaxy.model.Context;

/*
 * 处理银河数字下的金属货币值
 */
public class MetalSolver implements Solver
{
	private Context context;

	public MetalSolver(Context context)
	{
		this.context = context;
	}

	@Override
	public Boolean solve(String question) 
	{
		String currency = context.getCurrency();
		String qulifier = String.format(Constant.HOW_MANY, currency);
		
		if (!question.startsWith(qulifier))
			return false;

		String body = question.substring(qulifier.length() + 1);
		String[] lexers = body.split(Constant.BLANK);
		String unit = lexers[lexers.length -1].trim();
		
		Integer value = Roman.parse(Arrays.asList(lexers).subList(0, lexers.length - 1), context.getGalaxyRoman()).calculate();
		DecimalFormat obj = new DecimalFormat(Constant.ZERO); 
		String total = obj.format(context.getMetalCurrency().get(unit) * value);

		StringBuilder sb = new StringBuilder();
		sb.append(body).append(total).append(Constant.BLANK).append(Constant.DOT);
		System.out.println(sb.toString());
		
		return true;
	}


}
