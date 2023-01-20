package com.YixuanSpringBootPractice.learnSpringFramework;

import com.YixuanSpringBootPractice.learnSpringFramework.game.GameRunner;
import com.YixuanSpringBootPractice.learnSpringFramework.game.MarioGame;
import com.YixuanSpringBootPractice.learnSpringFramework.game.SuperContraGame;

public class AppGamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();
		

	}

}
