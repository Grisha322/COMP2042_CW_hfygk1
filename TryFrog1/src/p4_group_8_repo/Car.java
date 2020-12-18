package p4_group_8_repo;

public class Car extends MovingObstacle{
	
	public Car(String imageLink, double size, double speed) {
		
		super(imageLink, size, speed);
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Car";
		
	}

}
