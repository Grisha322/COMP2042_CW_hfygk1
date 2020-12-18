package p4_group_8_repo;
import java.util.HashMap;

public abstract class LevelSettings {
	protected HashMap<LevelKeys, Double> settings = new HashMap<LevelKeys, Double>();
	
	public Double get(LevelKeys key) {
		return settings.get(key);
	}
	
	public LevelSettings() {
		initHashMap();
	}
	
	public abstract void initHashMap();
}
