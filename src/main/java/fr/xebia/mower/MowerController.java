package fr.xebia.mower;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MowerController {
    private RectangularGround ground;
    private LinkedList<Mower> mowers;
    private ListIterator<Mower> mowerListIterator;

    public MowerController(RectangularGround ground) {
        this.ground = ground;
        this.mowers = new LinkedList<>();
    }

    public void addMower(Mower mower) {
        mower.setGround(this.ground);
        this.mowers.add(mower);
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public Position consumeInstructions(String instructions) {
        if (mowers.isEmpty()) {
            throw new InvalidParameterException("Cannot consume instructions without mowers");
        }

        if (mowerListIterator == null || !mowerListIterator.hasNext()) {
            mowerListIterator = mowers.listIterator();
        }

        Mower currentMower = mowerListIterator.next();

        for (char code : instructions.toCharArray()) {
            currentMower.consumeInstruction(Instruction.getByCode(code));
        }

        return currentMower.getPosition();
    }
}
