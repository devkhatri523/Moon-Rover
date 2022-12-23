package commands;


import com.moonrover.rover.MoonRover;
import com.moonrover.rover.commands.RotateRightCommand;
import com.moonrover.rover.universe.Coordinates;
import com.moonrover.rover.universe.Direction;
import com.moonrover.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class RotateRightCommandTest {

    @Test
    public void testThatRotateRightCommandRotatesTheNavigableObjectRight() {
        //Given
        RotateRightCommand command = new RotateRightCommand();
        Plateau plateau = new Plateau(5,5);
        Coordinates startingPosition = new Coordinates(1,2);
        MoonRover rover = new MoonRover(plateau, Direction.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 2 E", rover.currentLocation());
    }

}
