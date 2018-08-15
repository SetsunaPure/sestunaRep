package merchant.guide.galaxy.enums;

/**
 * 罗马数字构成
 * @author Administrator
 *
 */
public enum RomanPrimitive
{
	I("I", 1, true, true),
	V("V", 5, false, false),
	X("X", 10, true, true),
	L("L", 50, false, false),
	C("C", 100, true, true),
	D("D", 500, false, false),
	M("M", 1000, true, true);
	
	private final String symbol;
	
	private final Integer value;
	
	private final Boolean allowRepeat;
	
	private final Boolean allowSubstract;

	private RomanPrimitive(String symbol, Integer value, Boolean allowRepeat, Boolean allowSubstract) {
		this.symbol = symbol;
		this.value = value;
		this.allowRepeat = allowRepeat;
		this.allowSubstract = allowSubstract;
	}

	public String getSymbol() {
		return symbol;
	}

	public Integer getValue() {
		return value;
	}

	public Boolean getAllowRepeat() {
		return allowRepeat;
	}

	public Boolean getAllowSubstract() {
		return allowSubstract;
	}
	
	public static RomanPrimitive parse(String symbol)
	{
		for (RomanPrimitive roman : RomanPrimitive.values())
		{
			if (roman.getSymbol().equals(symbol))
				return roman;
		}
		
		return null;
	}
	
	
}
