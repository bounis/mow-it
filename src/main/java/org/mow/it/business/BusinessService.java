package org.mow.it.business;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;
import org.mow.it.command.CommandResolver;
import org.mow.it.domain.Mower;
import org.mow.it.domain.Pelouse;
import org.mow.it.domain.Position;
import org.mow.it.domain.PositionCommandsLine;
import org.mow.it.domain.State;
import org.mow.it.domain.StateResolver;
import org.mow.it.io.IOHelper;
import org.mow.it.io.MowerBufferdReader;

public class BusinessService {

    private static final BusinessService businessService = new BusinessService();

    private BusinessService() {
    }

    public static BusinessService getInstance() {
        return businessService;
    }

    public void startMowers(Path path) {

        try (MowerBufferdReader br = IOHelper.createMowerBufferedReader(path)) {
            Pelouse.createPelouseIfNotExist(br.readLine());
            runMowers(br);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runMowers(MowerBufferdReader br) {
        br.readLines().forEach(this::runMower);
    }

    private void runMower(PositionCommandsLine positionCommandsLine) {

        Mower mower = setUpMowerInPelouse(positionCommandsLine);

        IntStream chars = positionCommandsLine.getCommandsLine().chars();
        chars.mapToObj(CommandResolver::resolve).forEach(cmd -> cmd.execute(mower));

        System.out.println(mower.getPosition());
    }

    private Mower setUpMowerInPelouse(PositionCommandsLine positionCommandsLine) {
        Position position = Position.createPosition(positionCommandsLine.getPositonLine());
        State state = StateResolver.resolve(position.getOrientation());
        Mower mower = new Mower(position, state);
        state.setMower(mower);
        Pelouse.getInstance().addMower(mower);
        return mower;
    }
}
