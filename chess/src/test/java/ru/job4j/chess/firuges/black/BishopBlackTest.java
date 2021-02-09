package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.position(), is(Cell.A1));
    }

    @Test
    public void copy() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        Figure bishopDest = bishop.copy(Cell.B2);
        assertThat(bishopDest.position(), is(Cell.B2));
    }

    @Test
    public void whenRightWay() {
        BishopBlack bishop1 = new BishopBlack(Cell.A1);
        Cell[] expected1 = {Cell.B2, Cell.C3, Cell.D4};
        assertThat(bishop1.way(Cell.D4), is(expected1));

        BishopBlack bishop2 = new BishopBlack(Cell.D4);
        Cell[] expected2 = {Cell.C5, Cell.B6};
        assertThat(bishop2.way(Cell.B6), is(expected2));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWrongWay() {
        BishopBlack bishop1 = new BishopBlack(Cell.A1);
        bishop1.way(Cell.A2);
    }
}