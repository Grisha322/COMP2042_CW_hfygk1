package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevelTest {
	Level level = Level.NOTSET;

	@Test
	public void testNextElement() {
		try {
			level = level.nextElement();
			assertEquals(level, Level.ONE);
			level = level.nextElement();
			assertEquals(level, Level.TWO);
			level = level.nextElement();
			assertEquals(level, Level.THREE);
			level = level.nextElement();
			assertEquals(level, Level.NOTSET);
			
		}
		catch(AssertionError e){
			fail("Error in nextElement method");	
		}
		
	}

	@Test
	public void testElementsLeft() {
		try {
			level = Level.NOTSET;
			assertTrue(level.elementsLeft());
			level = Level.THREE;
			assertFalse(level.elementsLeft());
		}
		catch(AssertionError e){
			fail("Error in elementsLeft method");	
		}
	}

	@Test
	public void testLevelToInt() {
		
		try {
			level = Level.NOTSET;
			assertEquals(level.levelToInt(), 0);
			level = Level.ONE;
			assertEquals(level.levelToInt(), 1);
			level = Level.TWO;
			assertEquals(level.levelToInt(), 2);
			level = Level.THREE;
			assertEquals(level.levelToInt(), 3);
		}
		catch(AssertionError e){
			fail("Error in levelToInt method");	
		}
	}

}
