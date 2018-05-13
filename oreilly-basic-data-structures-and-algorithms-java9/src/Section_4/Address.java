package Section_4;

public class Address 
{
	private String street;
	private City city;
	
	public Address(City city,String street)
	{
		this.city=city;
		this.street=street;
	}

    public Option<City> getCity() 
    {
        return Option.optionOf(city);
    }
    
    public Option<String> getStreet() 
    {
        return Option.optionOf(street);
    }
	
	
}
