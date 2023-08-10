package org.example.decorator;

import java.io.IOException;

public interface DataSource {

    void writeData(String data) throws IOException;
    String readData();
}