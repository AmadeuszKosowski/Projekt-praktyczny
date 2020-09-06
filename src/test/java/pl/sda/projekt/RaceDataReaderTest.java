package pl.sda.projekt;

import org.junit.jupiter.api.Test;
import pl.sda.projekt.Pigeon;
import pl.sda.projekt.RaceDataReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceDataReaderTest {

    @Test
    void shouldReadPigeon() throws IOException {
        //given
        RaceDataReader readerFile = new RaceDataReader("C:\\Users\\Agent\\IdeaProjects\\Projekt-praktyczny\\src\\main\\resources\\pigeon-racing.csv");
        //when
        List<Pigeon> pigeonList = readerFile.getPigeons();
        //then
        assertEquals( 1, pigeonList.size());
        Pigeon pigeon = pigeonList.get(0);
        assertEquals( "KOTTT", pigeon.getName());
        assertEquals( "Texas Outlaws", pigeon.getOwner());
        assertEquals( "Texas Outlaws", pigeon.getName());
        assertEquals( "19633-AU15-FOYS", pigeon.getBirdId());

    }

}
