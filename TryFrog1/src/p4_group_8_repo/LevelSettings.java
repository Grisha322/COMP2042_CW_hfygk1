package p4_group_8_repo;
import java.util.HashMap;

/*
 * This is an interface of level settings
 */
public abstract class LevelSettings {
	/**
	 * each level holds a hash map of the values that are used to describe actors, such as their speed, amount etc.
	 */
	protected HashMap<LevelKeys, Double> settings = new HashMap<LevelKeys, Double>();
	
	/**
	 * accessing the value addressed by the key
	 * @param key from LevelKeys enum
	 * @return returns value associated with the key
	 */
	public Double get(LevelKeys key) {
		return settings.get(key);
	}
	
	/**
	 * Constructs an instance with a preset HashMap of level settings
	 */
	public LevelSettings() {
		settings = initHashMap();
	}
	
	public abstract HashMap<LevelKeys, Double> initHashMap();
}
