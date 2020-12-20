package p4_group_8_repo;
/**
 * Factory that produces Actor Factories
 * @author hfygk1
 *
 */
public class ActorFactoryProducer {
	private static ActorFactoryProducer instance = new ActorFactoryProducer();
	
	private ActorFactoryProducer() {}
	/**
	 * Accessing singleton object
	 * @return singleton instance of ActorFactoryProducer
	 */
	public static ActorFactoryProducer getInstance() {
		return instance;
	}
	
	/**
	 * Creates and returns an appropriate actor factory according to factoryType passed
	 * @param factoryType is an identifier of the factory that has to be created
	 * @return returns actor factory
	 * @throws IllegalArgumentException if the factoryType passed is null
	 */
	public ActorFactory getActorFactory(String factoryType) throws IllegalArgumentException{
		if(factoryType == null)
			throw new IllegalArgumentException("Excpecting a not null object");
		
		ActorFactory actorFactory = null;
		
		final boolean isStaticFactory = factoryType.equalsIgnoreCase("StaticFactory");
		
		final boolean isObstacleFactory = factoryType.equalsIgnoreCase("MovingObstacleFactory");
		
		if(isStaticFactory) {
			actorFactory = new StaticFactory();
		}
		else if(isObstacleFactory) {
			actorFactory = new MovingObstalceFactory();
		}
		
		return actorFactory;
	}
}