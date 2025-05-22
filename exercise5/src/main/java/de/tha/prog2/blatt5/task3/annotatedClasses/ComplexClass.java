package de.tha.prog2.blatt5.task3.annotatedClasses;
import de.tha.prog2.blatt5.task3.annotations.Bug;

@Bug(description = "This class has a bug", type = Bug.Type.MINOR)
public class ComplexClass {
	@Bug(description = "The constructor throws a NullPointerException", type=Bug.Type.CRITICAL)
	public ComplexClass() {
		
	}
	
	@Bug(description = "The method should have private visibility", type=Bug.Type.ENHANCEMENT)
	public void shouldBePrivate(int i) {
		
	}
	
	@Bug(description = "The method should have public visibility", type=Bug.Type.ENHANCEMENT)
	private void shouldBePublic(int i) {
		
	}
	
	@Bug(description = "The static inner class has a bug", type=Bug.Type.SEVERE)
	private static class StaticInnerClass {
		@Bug(description = "The static inner class has a private message with a bug", type=Bug.Type.SEVERE)
		private void myPrivateMethod() {} 
		
		@Bug(description= "We need to go deeper", type=Bug.Type.CRITICAL)
		private class OneLevelDeeper {
			
		}
	}
}


