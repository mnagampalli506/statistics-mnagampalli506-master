import java.util.Arrays;

public class Statistics {

	public static void main(String[] args) {
		// Create a DataSet object
		DataSet data = new DataSet();
		DataSet data2 = new DataSet();
		DataSet data3 = new DataSet();
		DataSet data4 = new DataSet();
		DataSet compactData = new DataSet();
		// Call the readData method to get data from the file
		data.readData("data/numbers.txt");
		data2.readData("data/numbers2.txt");
		data3.readData("data/numbers3.txt");
		data4.readData("data/numbers4.txt");
		compactData.readData("data/compactData.txt");

		// Optionally, print the DataSet object to validate that data was read correctly
		System.out.println(data);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(compactData);

		// Compute statistics and print the results
		System.out.println("data_1: " + data.removeVal(0));
		System.out.println("data_1: " + data.findAverage());
		System.out.println("data_1: " + data.findStandardDeviation());
		System.out.println("data_1: " + Arrays.toString(data.findModes()));

		System.out.println("data_2: " + data2.removeVal(0));
		System.out.println("data_2: " + data2.findAverage());
		System.out.println("data_2: " + data2.findStandardDeviation());
		System.out.println("data_2: " + Arrays.toString(data2.findModes()));
		
		System.out.println("data_3: " + data3.removeVal(0));
		System.out.println("data_3: " + data3.findAverage());
		System.out.println("data_3: " + data3.findStandardDeviation());
		System.out.println("data_3: " + Arrays.toString(data3.findModes()));

		System.out.println("data_4: " + data4.removeVal(0));
		System.out.println("data_4: " + data4.findAverage());
		System.out.println("data_4: " + data4.findStandardDeviation());
		System.out.println("data_4: " + Arrays.toString(data4.findModes()));

		System.out.println(compactData.removeVal(0));
		System.out.println(compactData.toString());
		System.out.println("compactData: " + compactData.findAverage());
		System.out.println("compactData: " + compactData.findStandardDeviation());
		System.out.println("compactData: " + Arrays.toString(compactData.findModes()));
		try {
			compactData.insert(0,0);
			System.out.println("compactData: " + compactData.toString());
			
			compactData.insert(0,8);
			System.out.println("compactData: " + compactData.toString());
		}catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Index to Insert is out of bounds");
		} 
		
		

	}

}
