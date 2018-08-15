package merchant.guide.galaxy.model;

import java.util.List;
import java.util.Map;

import merchant.guide.galaxy.enums.RomanPrimitive;


public class Context 
{
	//���ӻ���
	private String currency;
	
	//�������������ֵĹ�ϵ
	private Map<String, RomanPrimitive> galaxyRoman;
	
	//��������ҵĹ�ϵ
	private Map<String ,Double> metalCurrency;
	
	//����
	private List<String> questions;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String, RomanPrimitive> getGalaxyRoman() {
		return galaxyRoman;
	}

	public void setGalaxyRoman(Map<String, RomanPrimitive> galaxyRoman) {
		this.galaxyRoman = galaxyRoman;
	}

	public Map<String, Double> getMetalCurrency() {
		return metalCurrency;
	}

	public void setMetalCurrency(Map<String, Double> metalCurrency) {
		this.metalCurrency = metalCurrency;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
}
