package org.example;

import org.example.decorator.CompressionDecorator;
import org.example.decorator.DataSource;
import org.example.decorator.EncryptionDecorator;
import org.example.decorator.FileDataSource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String stringToCompressAndEncrypt = "nypel";
        String filePath = "./src/main/java/org/example/decorator/data.txt";
        DataSource dataSource = new CompressionDecorator(new EncryptionDecorator(new FileDataSource(filePath)));
        dataSource.writeData(stringToCompressAndEncrypt);
        dataSource.readData();
    }
}