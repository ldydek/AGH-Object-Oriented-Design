package org.example.decorator;

import java.io.IOException;
import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void writeData(String data) throws IOException {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    private String encode(String data) {
        String encodedString = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println("Zaszyfrowany napis:   " + encodedString);
        return encodedString;
    }

    private String decode(String data) {
        String decodedString = new String(Base64.getDecoder().decode(data));
        System.out.println("Odszyfrowany napis:   " + decodedString);
        return decodedString;
    }
}