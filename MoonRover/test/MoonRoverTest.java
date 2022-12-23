import com.moonrover.rover.MoonRover;
import com.moonrover.rover.universe.Coordinates;
import com.moonrover.rover.universe.Direction;
import com.moonrover.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MoonRoverTest {
    @Test
    public void canProvideCurrentLocationAsString() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);

        //When
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //then
        Assert.assertEquals("3 3 N", moonRover.currentLocation());
    }

    @Test
    public void canRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.turnLeft();

        //then
        Assert.assertEquals("1 2 W", moonRover.currentLocation());
    }

    @Test
    public void canRotateRight() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.turnRight();

        //then
        Assert.assertEquals("1 2 E", moonRover.currentLocation());
    }

    @Test
    public void canMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.move();

        //then
        Assert.assertEquals("1 3 N", moonRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateRight() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.run("R");

        //then
        Assert.assertEquals("1 2 E", moonRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.run("L");

        //then
        Assert.assertEquals("1 2 W", moonRover.currentLocation());
    }

    @Test
    public void canRunCommandToMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.run("M");

        //then
        Assert.assertEquals("1 3 N", moonRover.currentLocation());
    }

    @Test
    public void canRunCommandWithMultipleInstructions() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MoonRover moonRover = new MoonRover(plateau, Direction.E, startingPosition);

        //When
        moonRover.run("MMRMMRMRRM");

        //then
        Assert.assertEquals("5 1 E", moonRover.currentLocation());
    }

    @Test
    public void wontDriveOffPlateau() {
        //Given
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(3,3);
        MoonRover moonRover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        moonRover.run("MMMMMMMMMMR");

        //then
        Assert.assertEquals("3 5 E", moonRover.currentLocation());
    }
}
