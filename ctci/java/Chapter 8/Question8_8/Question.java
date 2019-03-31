package Question8_8;

import java.io.*;
import java.util.*;
import java.awt.Point;

/**
 * 设计一个黑白棋
 * TODO:这道题有点难度啊
 */
public class Question {
	
	public static void main(String[] args) {
		Game game = Game.getInstance();
		game.getBoard().initialize();
		game.getBoard().printBoard();
		Automator automator = Automator.getInstance();
		while (!automator.isOver() && automator.playRandom()) {
		}
		automator.printScores();
	}
}
