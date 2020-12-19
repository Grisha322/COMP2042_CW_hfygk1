package p4_group_8_repo;

import java.util.HashMap;

public class LevelSettingsBuilder {
	private static LevelSettingsBuilder instance = new LevelSettingsBuilder();
	
	private LevelSettingsBuilder() {}
	
	public static LevelSettingsBuilder getInstance() {
		return instance;
	}
	
	public LevelSettings getLevelSettings(Level level) {
		LevelSettings levelSettings = null;
		
		if(level == Level.ONE) {
			levelSettings = initLevelOneSettings();
		}
		else if(level == Level.TWO) {
			levelSettings = initLevelTwoSettings();
		}
		else if(level == Level.THREE) {
			levelSettings = initLevelThreeSettings();
		}
		return levelSettings;
	}
	
	public LevelSettings initLevelOneSettings() {
		return new LevelSettings() {
			@Override
			public HashMap<LevelKeys, Double> initHashMap() {
				HashMap<LevelKeys, Double> settings = new HashMap<LevelKeys, Double>();
				settings.put(LevelKeys.AMOUNT_OF_CARS, 4.0);
				settings.put(LevelKeys.AMOUNT_OF_TRACKS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_TRACKS, 2.0);
				settings.put(LevelKeys.AMOUNT_OF_FAST_CARS, 1.0);
				settings.put(LevelKeys.AMOUNT_OF_LOGS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_LOGS, 3.0);
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
				settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_LOGS, 50.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_TURTLES, 130.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_WET_TURTLES, 100.0);
				return settings;
			}
		} ;
	}
	
	public LevelSettings initLevelTwoSettings() {
		return new LevelSettings() {
			@Override
			public HashMap<LevelKeys, Double> initHashMap() {
				HashMap<LevelKeys, Double> settings = new HashMap<LevelKeys, Double>();
				settings.put(LevelKeys.AMOUNT_OF_CARS, 4.0);
				settings.put(LevelKeys.AMOUNT_OF_TRACKS, 4.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_TRACKS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_FAST_CARS, 2.0);
				settings.put(LevelKeys.AMOUNT_OF_LOGS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_LOGS, 2.0);
				settings.put(LevelKeys.AMOUNT_OF_TURTLES, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_WET_TURTLES, 3.0);
				settings.put(LevelKeys.SPEED_OF_CARS, -2.0);
				settings.put(LevelKeys.SPEED_OF_TRACKS, 1.0);
				settings.put(LevelKeys.SPEED_OF_LONG_TRACKS, -1.0);
				settings.put(LevelKeys.SPEED_OF_FAST_CARS, 5.0);
				settings.put(LevelKeys.SPEED_OF_TURTLES, -0.5);
				settings.put(LevelKeys.SPEED_OF_LOGS, 2.0);
				settings.put(LevelKeys.SPEED_OF_WET_TURTLES, -1.5);
				settings.put(LevelKeys.SPEED_OF_LONG_LOGS, 0.5);
				settings.put(LevelKeys.DISTANCE_BETWEEN_CARS, 120.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_TRACKS, 100.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_TRACKS, 120.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_FAST_CARS, 250.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LOGS, 70.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_LOGS, 100.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_TURTLES, 130.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_WET_TURTLES, 150.0);
				return settings;
			}
		} ;
	}
	
	public LevelSettings initLevelThreeSettings() {
		return new LevelSettings() {
			@Override
			public HashMap<LevelKeys, Double> initHashMap() {
				HashMap<LevelKeys, Double> settings = new HashMap<LevelKeys, Double>();
				settings.put(LevelKeys.AMOUNT_OF_CARS, 5.0);
				settings.put(LevelKeys.AMOUNT_OF_TRACKS, 4.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_TRACKS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_FAST_CARS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_LOGS, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_LONG_LOGS, 2.0);
				settings.put(LevelKeys.AMOUNT_OF_TURTLES, 3.0);
				settings.put(LevelKeys.AMOUNT_OF_WET_TURTLES, 3.0);
				settings.put(LevelKeys.SPEED_OF_CARS, -2.0);
				settings.put(LevelKeys.SPEED_OF_TRACKS, 1.0);
				settings.put(LevelKeys.SPEED_OF_LONG_TRACKS, -1.0);
				settings.put(LevelKeys.SPEED_OF_FAST_CARS, 5.0);
				settings.put(LevelKeys.SPEED_OF_TURTLES, -0.5);
				settings.put(LevelKeys.SPEED_OF_LOGS, 2.0);
				settings.put(LevelKeys.SPEED_OF_WET_TURTLES, -1.5);
				settings.put(LevelKeys.SPEED_OF_LONG_LOGS, 0.5);
				settings.put(LevelKeys.DISTANCE_BETWEEN_CARS, 80.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_TRACKS, 100.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_TRACKS, 120.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_FAST_CARS, 200.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LOGS, 70.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_LONG_LOGS, 100.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_TURTLES, 130.0);
				settings.put(LevelKeys.DISTANCE_BETWEEN_WET_TURTLES, 150.0);
				return settings;
			}
		} ;
	}
	
}
