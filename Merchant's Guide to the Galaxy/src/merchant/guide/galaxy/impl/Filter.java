package merchant.guide.galaxy.impl;

import merchant.guide.galaxy.constants.Constant;

public class Filter
{
    static boolean isEndWithMark(String input)
    {
        return input.endsWith(Constant.QUESTION_MARK);
    }
}
