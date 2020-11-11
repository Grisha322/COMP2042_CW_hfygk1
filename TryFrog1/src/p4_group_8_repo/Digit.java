package p4_group_8_repo;

public class Digit extends Actor{
	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int size, int xPos, int yPos) {
		
		super("file:src/p4_group_8_repo/"+n+".png", size, xPos, yPos);
		
	}
	
	@Override
	public String getActorClassName() {
		
		return "Digit";
		
	}
	
}
