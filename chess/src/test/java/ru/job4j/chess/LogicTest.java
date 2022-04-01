package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void whenCellOccupied()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.E4));
        logic.move(Cell.F4, Cell.D6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H7));
        logic.move(Cell.H7, Cell.G7);
    }
}