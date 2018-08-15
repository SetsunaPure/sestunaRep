package merchant.guide.galaxy.impl;

import merchant.guide.galaxy.constants.Constant;
import merchant.guide.galaxy.inf.Parser;
import merchant.guide.galaxy.model.Context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Ω‚ŒˆΩ Ù”Ôæ‰
 * @author Administrator
 *
 */
public class MetalParser extends Filter implements Parser
{
    private Context context;

    public MetalParser(Context context)
    {
        this.context = context;
    }

    @Override
    public Boolean parse(String input)
    {
        if (isEndWithMark(input))
            return false;

        String[] lexers = input.split(Constant.IS);
        if(lexers.length !=2)
            return false;

        String[] left = lexers[0].split(Constant.BLANK);
        String[] right = lexers[1].split(Constant.BLANK);

        if (left.length < 2)
            return false;

        int rValue = Integer.parseInt(right[0]);
        String primUnit = right[1];

        context.setCurrency(primUnit);

        Roman roman = Roman.parse(Arrays.asList(left).subList(0, left.length - 1), context.getGalaxyRoman());

        int calculated = roman.calculate();

        String uint = left[left.length - 1];

        double unitValue = (double)rValue/(double)calculated;

        Map<String, Double> units = context.getMetalCurrency() == null
                ? new HashMap<String, Double>() : context.getMetalCurrency();

        units.put(uint, unitValue);

        context.setMetalCurrency(units);

        return true;
    }




}
