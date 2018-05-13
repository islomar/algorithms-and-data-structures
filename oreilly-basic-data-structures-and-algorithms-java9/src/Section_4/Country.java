package Section_4;

public class Country 
{
	private String name;
	private String countryCode;
	
	public Country(String countryCode,String name)
	{
		this.name=name;
		this.countryCode=countryCode;
	}

    public Option<String> getCountryCode() 
    {
        return Option.optionOf(countryCode);
    }
    
    public Option<String> getName() 
    {
        return Option.optionOf(name);
    }
	
	
}
