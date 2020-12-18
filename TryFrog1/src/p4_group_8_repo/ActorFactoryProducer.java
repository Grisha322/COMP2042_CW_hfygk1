package p4_group_8_repo;

public class ActorFactoryProducer {
	private static ActorFactoryProducer factory = new ActorFactoryProducer();
	
	private ActorFactoryProducer() {}
	
	public static ActorFactoryProducer getActorFactoryProducer() {
		return factory;
	}
	
	public ActorFactory getActorFactory(String factoryType) {
		ActorFactory actorFactory = null;
		
		final boolean isPlayerFactory = factoryType.equalsIgnoreCase("PlayerFactory");
		
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