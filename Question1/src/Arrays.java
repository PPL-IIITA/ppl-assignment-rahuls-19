package ppl_assign;

import java.io.IOException;

public final class Arrays
{
	public static Boy[] initializeWithDefaultBoyInstances(int length)
	{
		Boy[] array = new Boy[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new Boy();
		}
		return array;
	}

	public static Gift[] initializeWithDefaultGiftInstances(int length)
	{
		Gift[] array = new Gift[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new Gift();
		}
		return array;
	}

	public static Girl[] initializeWithDefaultGirlInstances(int length)
	{
		Girl[] array = new Girl[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new Girl();
		}
		return array;
	}

	public static Couple[] initializeWithDefaultCoupleInstances(int length)
	{
		Couple[] array = new Couple[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new Couple();
		}
		return array;
	}

	public static <T extends java.io.Closeable> void deleteArray(T[] array) throws IOException
	{
		for (T element : array)
		{
			if (element != null)
				element.close();
		}
	}
}
