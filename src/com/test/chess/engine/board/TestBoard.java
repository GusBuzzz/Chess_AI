/*
Author: Gustavo Rubio (Vice President of Association for Computing Machinery)
Created: 1/2/23
 */
package com.test.chess.engine.board;

import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.player.MoveTransition;
//import com.chess.engine.player.ai.MiniMax;
import com.chess.engine.player.ai.MoveStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoard {
    @Test
    public void initialBoard(){
        final Board board = Board.createStandardBoard();
        assertEquals(board.currentPlayer().getLegalMoves().size(), 20);
        assertEquals(board.currentPlayer().getOpponent().getLegalMoves().size(), 20);
        assertFalse(board.currentPlayer().isInCheck());
        assertFalse(board.currentPlayer().isInCheckMate());
        assertFalse(board.currentPlayer().isCastled());
        //assertTrue(board.currentPlayer().isKingSideCastelCapable());
        //assertTrue(board.currentPlayer().isQueenSideCastelCapable());
        assertEquals(board.currentPlayer(), board.whitePlayer());

        assertEquals(board.currentPlayer().getOpponent(), board.blackPlayer());
        assertFalse(board.currentPlayer().getOpponent().isInCheck());
        assertFalse(board.currentPlayer().getOpponent().isInCheckMate());
        assertFalse(board.currentPlayer().getOpponent().isCastled());
        //assertTrue(board.currentPlayer().getOpponent().isKingSideCastelCapable());
        //assertTrue(board.currentPlayer().getOpponent().isQueenSideCastelCapable());
        //assertEquals(new StandardBoardEvaluator().evaluate(board, 0), 0);
    }
    @Test
    public void testAI(){
        final Board board = Board.createStandardBoard();
        //final MoveStrategy moveStrategy = new MiniMax(4);
        //final Move move = moveStrategy.execute(board);
        //System.out.println(move);
    }
    @Test
    public void testFoolsMate(){ //shortest checkmate in chess

        final Board board = Board.createStandardBoard();
        final MoveTransition t1 = board.currentPlayer()
                .makeMove(Move.MoveFactory.createMove(board, BoardUtils.INSTANCE.getCoordinateAtPosition("f2"),
                        BoardUtils.INSTANCE.getCoordinateAtPosition("f3")));

        assertTrue(t1.getMoveStatus().isDone());

        final MoveTransition t2 = t1.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t1.getTransitionBoard(), BoardUtils.INSTANCE.getCoordinateAtPosition("e7"),
                        BoardUtils.INSTANCE.getCoordinateAtPosition("e5")));

        assertTrue(t2.getMoveStatus().isDone());

        final MoveTransition t3 = t2.getTransitionBoard()
                .currentPlayer()
                .makeMove(Move.MoveFactory.createMove(t2.getTransitionBoard(), BoardUtils.INSTANCE.getCoordinateAtPosition("g2"),
                        BoardUtils.INSTANCE.getCoordinateAtPosition("g4")));

        assertTrue(t3.getMoveStatus().isDone());

        //final MoveStrategy strategy = new MiniMax(4);

        //final Move aiMove = strategy.execute(t3.getTransitionBoard());

        final Move bestMove = Move.MoveFactory.createMove(t3.getTransitionBoard(), BoardUtils.INSTANCE.getCoordinateAtPosition("d8"),
                BoardUtils.INSTANCE.getCoordinateAtPosition("h4"));

        //assertEquals(aiMove, bestMove);

    }

}