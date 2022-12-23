package com.moonrover.rover.commands;


import com.moonrover.rover.MoonRover;

public class MoveCommand implements ICommand {

    @Override
    public void execute(final MoonRover rover) {
        rover.move();
    }

}
