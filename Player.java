//Author full name: Yash Jain
//==================================================



/**
 * Your documentation for this interface ....
 *
 *
 */

//COMMENTS
//Interface Class for Player it has 2 abstract methods
//Abstract method play (HanoiTowerGame) takes the game as a parameter so the game can be played @return type is void
//Abstract method  getScore() which just is a method to get the user's score @return type int
public interface Player { public abstract void play (HanoiTowerGame game); public abstract int getScore(); }