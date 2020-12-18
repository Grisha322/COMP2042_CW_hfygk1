package p4_group_8_repo;

public abstract class StaticActor extends Actor {

	public StaticActor(String ImageLink, double size) {
		super(ImageLink, size);
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
