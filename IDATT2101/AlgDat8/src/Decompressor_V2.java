import java.io.*;

public class Decompressor_V2 {

    public static void main(String[] args) throws IOException {

        // Use getClass().getResource() to get the path of the file in the same directory as the class file
        String filename = "opg8-kompr.lyx.comp";
        InputStream inputStream = Decompressor_V2.class.getResourceAsStream(filename);

        if (inputStream == null) {
            System.err.println("File not found: " + filename);
            return;
        }

        String decompressedText = decompress(inputStream);

        // Save the decompressed text to a new file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".de"))) {
            writer.write(decompressedText);
        }
    }

    public static String decompress(InputStream inputStream) throws IOException {
        StringBuilder textToBeWritten = new StringBuilder();

        int initialByte = inputStream.read();

        ByteArrayOutputStream charBuffer = new ByteArrayOutputStream();
        int byteRead = 0;

        while (charBuffer.size() < initialByte) {
            byteRead = inputStream.read();
            if (byteRead == -1) {
                break;
            }
            charBuffer.write(byteRead);
        }

        textToBeWritten.append(charBuffer);

        charBuffer.reset();

        boolean endOfFile = false;

        while (!endOfFile) {
            int lookBackByte = inputStream.read();
            int nrCharsByte = inputStream.read();
            int upcomingByte = inputStream.read();

            if (lookBackByte == -1) {
                endOfFile = true;
                break;
            }

            textToBeWritten.append(textToBeWritten.substring(
                    textToBeWritten.length() - lookBackByte,
                    textToBeWritten.length() - lookBackByte + nrCharsByte
            ));

            while (charBuffer.size() < upcomingByte) {
                byteRead = inputStream.read();
                if (byteRead == -1) {
                    break;
                }
                charBuffer.write(byteRead);
            }

            textToBeWritten.append(charBuffer);
            charBuffer.reset();
        }

        return textToBeWritten.toString();
    }
}
