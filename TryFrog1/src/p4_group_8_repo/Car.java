package p4_group_8_repo;
/**
 * Subclass of moving obstacle that describes cars
 * @author hfygk1
 *
 */
public class Car extends MovingObstacle{
	
	public Car(String imageLink, double size, double speed) {
		
		super(imageLink, size, speed);
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Car";
		
	}

}
