package absi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Reader implements Iterator<String[]> {
	private char delimiter = ',';
	private BufferedReader bufferReader;

	public Reader(String name) {
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(name);
		} catch (FileNotFoundException fne) {
			throw new RuntimeException(fne.getMessage(), fne);
		}
		if (inStream != null)
			bufferReader = new BufferedReader(new InputStreamReader(inStream));
	}

	@Override
	public boolean hasNext() {
		try {
			if (bufferReader.ready())
				return true;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}

	@Override
	public String[] next() {
		if (hasNext()) {
			try {
				String line = bufferReader.readLine();
				String[] ar = line.split(delimiter+"", line.length()+1);
				return ar;
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		throw new NoSuchElementException();
	}

}
