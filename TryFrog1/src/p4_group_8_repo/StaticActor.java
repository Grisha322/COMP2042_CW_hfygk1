package p4_group_8_repo;

public abstract class StaticActor extends Actor {

	public StaticActor(String ImageLink, double size, double xPos, double yPos) {
		super(ImageLink, size, xPos, yPos);
	}

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