/*
Author: Gustavo Rubio (Vice President of Association for Computing Machinery)
Created: 1/2/23
 */
package com.chess.engine.player.ai;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

public interface MoveStrategy {


    Move execute(Board board);

}
