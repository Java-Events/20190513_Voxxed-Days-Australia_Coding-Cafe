
package one.microstream.sampler.items;


import java.util.ArrayList;
import java.util.List;


public class DataRoot
{
	private final List<Item> items = new ArrayList<>();


	public DataRoot()
	{
	}


	public List<Item> getItems()
	{
		return this.items;
	}
}
