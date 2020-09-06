package pl.sda.projekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RaceDataReader {

    private final String filePath;

    public RaceDataReader(String filePath) {


        this.filePath = filePath;

    }

    public List<Pigeon> getPigeons() throws IOException {
        return Files.readAllLines(Paths.get(filePath)).stream()
                .map(line -> line.split(","))
                .map(this::asPigeon)
                .collect(Collector.of(() -> new LinkedList<Pigeon>(),
                        LinkedList::add,
                        (list1, list2) -> {
                            LinkedList<Pigeon> objects = new LinkedList<>();
                            objects.addAll(list1);
                            objects.addAll(list2);
                            return objects;
                        }
                        ));


    }

    private Pigeon asPigeon(String asTablePigeon[]) {

        return new Pigeon(asTablePigeon[2], asTablePigeon[3], asTablePigeon[1]);
    }
}


