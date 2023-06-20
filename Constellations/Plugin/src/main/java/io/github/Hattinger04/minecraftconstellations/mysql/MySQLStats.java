/**
 * @author Simon Greiderer
 * 
 * TODO: Ranking Abfrage noch kopieren
 */
package io.github.Hattinger04.minecraftconstellations.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import io.github.Hattinger04.minecraftconstellations.MinecraftConstellations;
import io.github.Hattinger04.minecraftconstellations.constellations.EConstellations;

public class MySQLStats {
	static HashMap<Integer, String> rang;
	public static Inventory playerTop;

	static {
		MySQLStats.rang = new HashMap<Integer, String>();
	}

	public static boolean playerExists(final Player player) {
		String uuid = convertPlayerToUUID(player); 
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			try {
				final ResultSet rs = MinecraftConstellations.mysql
						.query("SELECT * FROM ConstellationStats WHERE UUID= '" + uuid + "'");
				return rs.next() && rs.getString("UUID") != null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * You don't have to call the playerExists before!
	 * 
	 * @param player
	 */
	public static void createPlayer(final Player player) {
		if (MySQLFIle.sql.getBoolean("MySQL") && !playerExists(player)) {
			MinecraftConstellations.mysql.update(
					"INSERT INTO ConstellationStats(UUID, CONSTELLATION, KILLS, DEATHS) VALUES ('" + convertPlayerToUUID(player) + "', 'Nothing', '0', '0');");
		}
	}

	public static Integer getKills(final Player player) {
		Integer i = 0;
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				try {
					final ResultSet rs = MinecraftConstellations.mysql
							.query("SELECT * FROM ConstellationStats WHERE UUID= '" + convertPlayerToUUID(player) + "'");
					if (!rs.next() || Integer.valueOf(rs.getInt("KILLS")) == null) {
					}
					i = rs.getInt("KILLS");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				createPlayer(player);
				getKills(player);
			}
		}
		return i;
	}

	public static void setKills(final Player player, final Integer kills) {
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				MinecraftConstellations.mysql
						.update("UPDATE ConstellationStats SET KILLS= '" + kills + "' WHERE UUID= '" + convertPlayerToUUID(player) + "';");
			} else {
				createPlayer(player);
				setKills(player, kills);
			}
		}
	}

	public static void addKills(final Player player, final Integer kills) {
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				setKills(player, getKills(player) + kills);
			} else {
				createPlayer(player);
				addKills(player, kills);
			}
		}
	}

	public static Integer getDeaths(final Player player) {
		Integer i = 0;
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				try {
					final ResultSet rs = MinecraftConstellations.mysql
							.query("SELECT * FROM ConstellationStats WHERE UUID= '" + player + "'");
					if (!rs.next() || Integer.valueOf(rs.getInt("DEATHS")) == null) {
					}
					i = rs.getInt("DEATHS");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				createPlayer(player);
				getDeaths(player);
			}
		}
		return i;
	}

	public static void setDeaths(final Player player, final Integer deaths) {
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				MinecraftConstellations.mysql
						.update("UPDATE ConstellationStats SET DEATHS= '" + deaths + "' WHERE UUID= '" + convertPlayerToUUID(player) + "';");
			} else {
				createPlayer(player);
				setDeaths(player, deaths);
			}
		}
	}

	public static void addDeaths(final Player player, final Integer deaths) {
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				setDeaths(player, getDeaths(player) + deaths);
			} else {
				createPlayer(player);
				addDeaths(player, deaths);
			}
		}
	}
	
	private static String convertPlayerToUUID(Player player) {
		return player.getUniqueId().toString();
	}
	
	public static EConstellations getConstellationFromPlayer(Player player) {
		EConstellations constellation = EConstellations.Blue; 
		if (MySQLFIle.sql.getBoolean("MySQL")) {
			if (playerExists(player)) {
				try {
					final ResultSet rs = MinecraftConstellations.mysql
							.query("SELECT * FROM ConstellationStats WHERE UUID= '" + convertPlayerToUUID(player) + "'");
					if (!rs.next() || Integer.valueOf(rs.getInt("CONSTELLATION")) == null) {}
					constellation = EConstellations.valueOf(rs.getString("CONSTELLATION"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				createPlayer(player);
				getKills(player);
			}
		}
		return constellation;
	}
}