import java.io.*;
import java.nio.charset.StandardCharsets;

public class Compressor {

    public static void main(String[] args) throws IOException {

        String filename = "opg8-kompr.lyx";
        String outputFilename = filename + ".comp";

        // Load the input file from the classpath
        InputStream inputStream = Compressor.class.getResourceAsStream("/" + filename);
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        // Prepare the output file in the current working directory
        File outputFile = new File(outputFilename);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        // Read the input file content
        StringBuilder inputBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            inputBuilder.append(line).append(System.lineSeparator());
        }
        String input = inputBuilder.toString();

        // Compress the input
        compressLZ(input, dataOutputStream);

        // Close the streams
        reader.close();
        dataOutputStream.close();
        fileOutputStream.close();

        System.out.println("File compressed to: " + outputFilename);
    }

    public static void compressLZ(String input, DataOutputStream dataOutputStream) throws IOException {

        StringBuilder mismatchedSequence = new StringBuilder();
        StringBuilder matchedSequence = new StringBuilder();
        String current;
        char[] inputArray = input.toCharArray();
        int startMatchingIndex;
        int maxLookBack = 0;

        for (int i = 0; i < inputArray.length; i++) {
            current = String.valueOf(inputArray[i]);
            String inputSub = input.substring(0, i);
            maxLookBack = i;

            if (containsSubstring(inputSub, current)) {
                startMatchingIndex = i;
                StringBuilder testingSequence = new StringBuilder();
                testingSequence.append(current);
                matchedSequence.append(current);

                for (int j = i + 1; j < inputArray.length; j++) {
                    testingSequence.append(inputArray[j]);

                    if (i > 255) {
                        maxLookBack = 255;
                    }

                    if (containsSubstring(inputSub.substring(i - maxLookBack, i), testingSequence.toString())) {
                        matchedSequence.append(inputArray[j]);
                    } else {
                        break;
                    }
                }

                if (matchedSequence.length() <= 3) {
                    mismatchedSequence.append(matchedSequence);
                    i += matchedSequence.length() - 1;
                    matchedSequence.setLength(0); // Clear the buffer
                } else {
                    dataOutputStream.writeByte(mismatchedSequence.toString().getBytes(StandardCharsets.UTF_8).length);
                    dataOutputStream.write(mismatchedSequence.toString().getBytes(StandardCharsets.UTF_8));
                    mismatchedSequence.setLength(0); // Clear the buffer

                    byte lookBack = (byte) (Math.abs(input.substring(0, i).lastIndexOf(matchedSequence.toString()) - startMatchingIndex));
                    byte nrChars = (byte) matchedSequence.length();
                    byte[] bytePair = new byte[]{lookBack, nrChars};
                    dataOutputStream.write(bytePair);

                    i += matchedSequence.length() - 1;
                    matchedSequence.setLength(0); // Clear the buffer
                }

            } else {
                mismatchedSequence.append(current);
            }
        }

        if (!mismatchedSequence.isEmpty()) {
            dataOutputStream.writeByte(mismatchedSequence.toString().getBytes(StandardCharsets.UTF_8).length);
            dataOutputStream.write(mismatchedSequence.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    private static boolean containsSubstring(String input, String substring) {
        return input.contains(substring);
    }
}
