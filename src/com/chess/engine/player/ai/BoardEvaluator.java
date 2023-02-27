/*
Author: Gustavo Rubio (Vice President of Association for Computing Machinery)
Created: 1/2/23
 */package com.chess.engine.player.ai;

import com.chess.engine.board.Board;

public interface BoardEvaluator {

    int evaluate(Board board, int depth);

}
