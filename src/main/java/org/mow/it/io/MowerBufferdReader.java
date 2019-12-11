package org.mow.it.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.mow.it.domain.PositionCommandsLine;

public class MowerBufferdReader extends BufferedReader {


    public MowerBufferdReader(Reader in, int sz) {
        super(in, sz);
    }

    public MowerBufferdReader(Reader in) {
        super(in);
    }

    public Stream<PositionCommandsLine> readLines() {
        Iterator<PositionCommandsLine> iter = new Iterator<PositionCommandsLine>() {
            String nextCommandsLine;
            String nextPositionLine;

            @Override
            public boolean hasNext() {
                if (nextPositionLine != null && nextCommandsLine != null) {
                    return true;
                } else {
                    try {
                        nextPositionLine = readLine();
                        nextCommandsLine = readLine();
                        return (nextPositionLine != null && nextCommandsLine != null);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
            }

            @Override
            public PositionCommandsLine next() {
                if ((nextPositionLine != null && nextCommandsLine != null) || hasNext()) {
                    PositionCommandsLine line = new PositionCommandsLine(nextPositionLine, nextCommandsLine);
                    nextPositionLine = null;
                    nextCommandsLine = null;
                    return line;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);

    }
}



