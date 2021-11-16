
import java.util.Arrays;

public class DataSet {

	private int[] data;
	private final int START_FILE_SIZE = 50;
	private int numValues;

	public DataSet() {
		data = new int[START_FILE_SIZE];
		numValues = 0;

	}

	public void readData(String filename) {
		ArrayReader reader = new ArrayReader(filename);
		numValues = reader.fillArray(this);
	}

	public String toString() {
		int[] realDataArray = new int[numValues];
		for (int i = 0; i < numValues; i++) {
			realDataArray[i] = data[i];
		}

		return Arrays.toString(realDataArray);

	}

	public double findAverage() {
		double average = 0;
		double sum = 0;
		for (int i = 0; i < numValues; i++) {
			sum = sum + data[i];
		}
		average = sum / numValues;
		return average;

	}

	public int[] findModes() {
		int modecount = 0;
		int[] mode = new int[numValues];
		int prevMode = 0;

		for (int i = 0; i < numValues; i++) {

			int count = 0;
			for (int x = 0; x < numValues; x++) {
				if (data[i] == data[x]) {
					count++;

				}
			}

			if (prevMode < count) {
				prevMode = count;
				for (int k = 0; k < modecount; k++) {
					mode[k] = 0;
				}
				mode[0] = data[i];
				modecount = 1;

			}
			if (prevMode == count) {
				prevMode = count;

				boolean isInArray = false;

				for (int k = 0; k < modecount; k++) {
					if (mode[k] == data[i])
						isInArray = true;
				}
				if (isInArray == false) {

					mode[modecount] = data[i];
					modecount++;

				}
			}
		}

		return mode;
	}

	public double findStandardDeviation() {
		double standardDeviation = 0;
		double average = findAverage();

		for (int i = 0; i < numValues; i++) {
			standardDeviation +=  Math.pow(data[i] - average, 2);
		}

		return Math.sqrt(standardDeviation / (numValues-1));
	}

	public int[] reverseArray(int[] data) {
		int s = numValues - 1;
		int[] reverseArray = new int[numValues];
		for (int i = 0; i < numValues; i++) {

			reverseArray[i] = data[s - i];

		}

		return reverseArray;
	}

	// Precondition: data is non-null partially-filled int array
	// Postcondition: Moves all integers that are not equal to val to the front of
	// the array data, leaving the
	// order of integers otherwise unchanged. Returns the new number of legitimate
	// data
	// elements.
	public int removeVal(int val) {
		int i = 0;
		while (i < numValues) {
			if (data[i] == val) {

				for (int j = i; j + 1 < numValues; j++) {

					data[j] = data[j + 1];
				}
				numValues--;
			}
			if (data[i] != val) {
				i++;
			}

		}
		return numValues;
	}

	public void insert(int val, int i) {
		if(i>numValues) {
			 throw new ArrayIndexOutOfBoundsException();
		}
		if (numValues >= data.length) {
			resize();
		}

		int tempnumValues = numValues + 1;

		for (int k = tempnumValues - 1; k >= i; k--) {
			data[k + 1] = data[k];
		}
		data[i] = val;
		numValues++;

	}

	public void add(int x) {
		if (numValues >= data.length) {
			resize();
		}
		data[numValues] = x;
		numValues++;
	}

	public int getValue(int i) {
		return data[i];
	}

	public void setValue(int i, int val) {
		data[i] = val;
	}

	private void resize() {
		int realcount = data.length * 2;
		int realData[] = new int[realcount];
		for (int i = 0; i < data.length; i++) {
			realData[i] = data[i];
		}
		data = realData;
	}
}