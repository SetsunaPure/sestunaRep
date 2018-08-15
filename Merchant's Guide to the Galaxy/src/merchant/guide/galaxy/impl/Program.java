package merchant.guide.galaxy.impl;

import java.util.List;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.inf.Parser;
import merchant.guide.galaxy.inf.Solver;
import merchant.guide.galaxy.model.Context;

public class Program
{
	private Context ctx;
	
	public Program(Context context) 
	{
		this.ctx = context;
	}

	/**
	 * 解析语句和处理问题
	 * @param lstInput
	 */
	public void run(List<String> lstInput)
	{
		parseContext(lstInput);
		solverProblem(lstInput);
	}

	private void parseContext(List<String> lstInput)
	{
		//将文本分为三种不同的语句
		Parser primitiveParser = new GalaxyNumberParser(ctx);
		Parser unitParser =	new MetalParser(ctx);
		Parser questionParser =	new QuestionParser(ctx);

		//解析语句
		for(String input : lstInput)
		{
			primitiveParser.parse(input);
			unitParser.parse(input);
			questionParser.parse(input);
		}
	}

	private void solverProblem(List<String> lstInput)
	{
		//将问题分为两类
		Solver primitiveSolver = new GalaxyNumberSolver(ctx);
		Solver unitSolver = new MetalSolver(ctx);

		//解析问题
		for (String question : ctx.getQuestions())
		{
			boolean isNormalQuestion = primitiveSolver.solve(question) || unitSolver.solve(question);
			if (!isNormalQuestion)
			{
				System.out.println(Constant.NO_IDEA);
			}
		}
	}
}
