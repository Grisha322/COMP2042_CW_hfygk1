package p4_group_8_repo;

public class LevelOneSettings extends LevelSettings{
	
	private static LevelSettings instance = new LevelOneSettings();
	
	public static LevelSettings getInstance() {
		return instance;
	}
	
	@Override
	public void initHashMap() {
		settings.put(LevelKeys.AMOUNT_OF_CARS, 4.0);
		settings.put(LevelKeys.AMOUNT_OF_TRACKS, 3.0);
		settings.put(LevelKeys.AMOUNT_OF_LONG_TRACKS, 2.0);
		settings.put(LevelKeys.AMOUNT_OF_FAST_CARS, 1.0);
		settings.put(LevelKeys.AMOUNT_OF_LOGS, 3.0);
		settings.put(LevelKeys.AMOUNT_OF_LONG_LOGS, 2.0);
		settings.put(LevelKeys.AMOUNT_OF_TURTLES, 3.0);
		settings.put(LevelKeys.AMOUNT_OF_WET_TURTLES, 4.0);
		settings.put(LevelKeys.SPEED_OF_CARS, -2.0);
		settings.put(LevelKeys.SPEED_OF_TRACKS, 1.0);
		settings.put(LevelKeys.SPEED_OF_LONG_TRACKS, -1.0);
		settings.put(LevelKeys.SPEED_OF_FAST_CARS, 5.0);
		settings.put(LevelKeys.SPEED_OF_TURTLES, -0.5);
		settings.put(LevelKeys.SPEED_OF_LOGS, 1.5);
		settings.put(LevelKeys.SPEED_OF_WET_TURTLES, -1.5);
		settings.put(LevelKeys.SPEED_OF_LONG_LOGS, 0.5);
		settings.put(LevelKeys.DISTANCE_BETWEEN_CARS, 120.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_TRACKS, 100.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_TRACKS, 150.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_FAST_CARS, 250.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_LOGS, 70.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_LOGS, 150.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_TURTLES, 130.0);
		settings.put(LevelKeys.DISTANCE_BETWEEN_WET_TURTLES, 100.0);
	}
}
