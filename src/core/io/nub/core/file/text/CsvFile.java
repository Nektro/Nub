package io.nub.core.file.text;

import java.util.Iterator;

import io.nub.core.Nub;
import io.nub.core.file.File2;
import io.nub.core.i.ITable;
import io.nub.core.util.arrays.ArrayString;

/**
 * @author Nektro
 */
public class CsvFile extends TextFile implements ITable, Iterable<String>
{
	private static final long serialVersionUID = 1067439784131596081L;
	
	private final String[][] value;
		
	public CsvFile(String path) {
		super("");
		if (!this.extension.equals("csv")) {
			// throw exception
		}
		this.value = new ArrayString(Nub.getLineContent(new File2(path).getInputStream()).toArray()).split(",");
	}
	
	@Override
	public String getValue(int x, int y) {
		return value[y][x];
	}
	
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int x=0,y=0;
			@Override
			public boolean hasNext() {
				return y != value.length && x != value[y].length;
			}
			@Override
			public String next() {
				String r = value[y][x];
				x += 1;
				if (x == value[y].length - 1) {
					y += 1;
					x = 0;
				}
				return r;
			}
		};
	}
}
