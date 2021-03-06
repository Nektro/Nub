package io.nub.core.util;

import java.util.Arrays;

/**
 * @author Nektro
 */
public class Arrays2
{
	public static String toString(Object[][] a)
	{
		if (a == null)
			return "null";

		int iMax = a.length - 1;
		if (iMax == -1)
			return "[]";

		StringBuilder b = new StringBuilder();
		b.append('[');
		for (int i = 0;; i++) {
			b.append(Arrays.toString(a[i]));
			if (i == iMax)
				return b.append(']').toString();
			b.append(", ");
		}
	}

	public static int[] valueOf(String[] objects)
	{
		int[] a = new int[objects.length];
		for (int i = 0; i < objects.length; i++)
			a[i] = Integer.valueOf(objects[i]);
		return a;
	}

	public static Character[] valueOf(char[] arr) {
		Character[] ca = new Character[arr.length];
		for (int i = 0; i < ca.length; i++)
			ca[i] = arr[i];
		return ca;
	}
	
	public static Integer[] valueOf(int[] arr) {
		Integer[] ca = new Integer[arr.length];
		for (int i = 0; i < ca.length; i++)
			ca[i] = arr[i];
		return ca;
	}
}
