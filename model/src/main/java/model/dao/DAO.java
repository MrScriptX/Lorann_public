package model.dao;

import model.Door;
import model.Level;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author team 10
 * @version 1.0
 */
public abstract class DAO extends AbstractDAO
{


	private static String sqlGetLevel  = "{call GetLevel(?)}";

	/**
	 * Get level name and level data in a string
	 * 
	 * @param id level number
	 * @return Level
	 * @throws SQLException error while executing query
	 */
	public static Level sqlGetLevel(final int id) throws SQLException
	{
		Door door = new Door();
		Level level = new Level(door);

		final CallableStatement callStatement = prepareCall(sqlGetLevel);
		callStatement.setInt(1, id);

		if (callStatement.execute())
		{
			final ResultSet result = callStatement.getResultSet();

			if (result.first())
			{
				level.setName(result.getString(1));
				level.setData(result.getString(2));
			}

			result.close();
		}

		return level;
	}
	
}

