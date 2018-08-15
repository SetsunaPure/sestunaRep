package merchant.guide.galaxy.impl;

import java.util.ArrayList;
import java.util.List;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.inf.Parser;
import merchant.guide.galaxy.model.Context;

/*
 * Ω‚ŒˆŒ ∫≈”Ôæ‰
 */
public class QuestionParser extends Filter implements Parser
{
	private Context context;
	public QuestionParser(Context context) 
	{
		this.context = context;
	}
	
	@Override
	public Boolean parse(String input) 
	{
		if (!isEndWithMark(input))
			return false;

		List<String> question = context.getQuestions() == null
				? new ArrayList<String>() : context.getQuestions();
				
		question.add(input.replace(Constant.QUESTION_MARK, Constant.NULL));
		
		context.setQuestions(question);
		
		return true;
	}
	
	

}
