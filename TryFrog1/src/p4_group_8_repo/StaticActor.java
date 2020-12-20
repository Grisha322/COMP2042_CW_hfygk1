package p4_group_8_repo;

/**
 * This class describes static actors.
 * @author hfygk1
 *
 */
public abstract class StaticActor extends Actor {
	public StaticActor() {}
	
	public StaticActor(String ImageLink, double size) {
		super(ImageLink, size);
	}
	
	/**
	 * Overriding act method of actor superclass. Static actors do not act.
	 */
	@Override
	public void act() {
		// Do nothing
	}

	@Override
	public String getActorClassName() {
		// TODO Auto-generated method stub
		return "StaticActor";
	}

}
