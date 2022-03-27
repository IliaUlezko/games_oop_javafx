package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void whenCellA1() {
        BishopBlack black = new BishopBlack(Cell.A1);
        Cell a1 = black.position();
        assertThat(a1, is(black.position()));
    }

    @Test
    public void whenCopy() {
        BishopBlack black = new BishopBlack(Cell.A2);
        Figure b = black.copy(Cell.A2);
        assertThat(b.position(), is(black.position()));
    }

    @Test
    public void whenStartC1FinishG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenStartH8FinishD4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H8);
        Cell[] result = bishopBlack.way(Cell.D4);
        Cell[] expected = {Cell.G7, Cell.F6, Cell.E5, Cell.D4};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenStartA8FinishD5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Cell[] result = bishopBlack.way(Cell.D5);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenStartG1FinishD4() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        Cell[] result = bishopBlack.way(Cell.D4);
        Cell[] expected = {Cell.F2, Cell.E3, Cell.D4};
        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossible() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.D3);
    }
}