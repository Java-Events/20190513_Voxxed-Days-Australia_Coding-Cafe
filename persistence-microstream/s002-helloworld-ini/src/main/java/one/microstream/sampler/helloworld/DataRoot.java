
package one.microstream.sampler.helloworld;


public class DataRoot
{
	private String name;


	public DataRoot()
	{
	}


	public String getName()
	{
		return this.name;
	}


	public void setName(final String name)
	{
		this.name = name;
	}


	@Override
	public String toString()
	{
		return "Root: " + this.name;
	}
}
