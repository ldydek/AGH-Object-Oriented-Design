package org.example.decorator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    @Override
    public void writeData(String data) throws IOException {
        super.writeData(compress(data));
    }

    private String decompress(String data) {
        byte[] input = Base64.getDecoder().decode(data);

        Inflater decompressor = new Inflater();
        decompressor.setInput(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try {
            while (!decompressor.finished()) {
                int bytesRead = decompressor.inflate(buffer);
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
        } finally {
            decompressor.end();
        }

        String decompressedString = outputStream.toString(StandardCharsets.UTF_8);
        System.out.println("Zdekompresowany napis:   " + decompressedString);

        return decompressedString;
    }

    private String compress(String data) {
        byte[] inputData = data.getBytes(StandardCharsets.UTF_8);

        Deflater deflater = new Deflater();
        deflater.setInput(inputData);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(inputData.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int bytesCompressed = deflater.deflate(buffer);
            outputStream.write(buffer, 0, bytesCompressed);
        }
        deflater.end();

        String compressedString = new String(Base64.getEncoder().encode(outputStream.toByteArray()));
        System.out.println("Skompresowany napis:   " + compressedString);

        return compressedString;
    }
}