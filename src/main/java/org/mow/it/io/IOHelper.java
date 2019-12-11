package org.mow.it.io;

import static java.nio.file.Files.newInputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;

public class IOHelper {
    public static MowerBufferdReader createMowerBufferedReader(Path path) throws IOException {
        Reader reader = new InputStreamReader(newInputStream(path));
        return new MowerBufferdReader(reader);
    }
}
