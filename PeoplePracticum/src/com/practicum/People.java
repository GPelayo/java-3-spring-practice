package com.practicum;

public class People {
	public int id;
	public String firstName;
	public String lastName;
	
	public People(int id, String firstName, String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setFirstName(String firstname)
	{
		this.firstName = firstname;
	}
	
	public String getFirstName()
	{
		return firstName; 
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName()
	{
		return lastName; 
	}
}
