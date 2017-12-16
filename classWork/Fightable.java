public interface Fightable {
    boolean canFight();
}

abstract class Superhero implements Fightable {
    public abstract void fightCrime();
    public boolean canFight() {
    	System.out.println("returns true in superhero's canfight method");
    	return true;
    }

}

class TeenTitan extends Superhero {
    public void describeCostume() {
    	System.out.println("teentitan's describe costume method");
    }
    public void fightCrime() {
    	System.out.println("in teentitan's fightcrime method");
    }
}

class Raven extends TeenTitan {
    public void describeCostume() {
	    	System.out.println("ravens describe costume method");
    }
}

class Superman extends Superhero {
    public String getSecretIdentity() {
    	System.out.println("supermans getsecretidentity method");
    	return "Clark";
    }
    public String describeCostume() {
        	System.out.println("supermans describe costume method");
        	return "cape";
    }
    public void fightCrime() {
    	System.out.println("in superman's fightcrime method");
    }
}
class Tester {
	public static void main(String[] args) {
		TeenTitan t1 = new Raven();
		t1.describeCostume(); // should work will print ravens

		Superhero s1 = new Raven();
		// s1.describeCostume(); //will not compile
        ((Raven)s1).describeCostume(); //will compile will print ravens

		// Superhero s2 = new Superhero(); // will not compile
		// s2.fightCrime();

		Superhero s3 = new Raven();
		((Raven) s3).fightCrime(); //will work and print out TeenTitans fightCrime



		Raven r1 = new Raven();
		r1.fightCrime(); //will use TeenTitans


	    //Superman sm1 = new Superhero(); //this will not work because superman is a subclass of superhero. has to go big = new small
		//sm1.fightCrime();

		Superhero sm2 = new Superman();
		sm2.fightCrime(); //will use supermans

		//Raven r2 = new Superman();
		//r2.getSecretIdentity();

		//Raven r3 = new Raven();
		//r3.getSecretIdentity();

		Superhero s4 = new TeenTitan();
		s4.fightCrime(); //will use TeenTitans

		//Superhero s5 = new Fightable();
		//System.out.println(s5.canFight());

		Superhero s6 = new Superman();
		System.out.println(s6.canFight()); //will user superheros cause sman doesnt have one


}
}
