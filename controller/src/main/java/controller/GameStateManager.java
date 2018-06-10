package controller;

public class GameStateManager
{
	private GameState current_state;
	
	public GameStateManager()
	{
		this.current_state = GameState.PLAY;//base game state
	}
	
	public void setGameState(GameState state)
	{
		this.current_state = state;
	}
	
	public GameState getGameState()
	{
		return this.current_state;
	}
}
