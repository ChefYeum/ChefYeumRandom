
public class Boss extends Monster {
	private int stage;
	private final int initialHealth;
	public Boss(int health, int power) {
		super(health, power);
		this.initialHealth = health;
		this.stage = 1;
	}
	public String toString(){
		return super.toString()+String.format("\nStage: %d", this.stage);
	}
	
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (!super.isDefeated()) {
			if (((double)super.health/this.initialHealth) < 0.5) {
				if (this.stage == 1) {
					this.stage++;
					super.power = super.power*2;
				}
			}
			if (((double)super.health/this.initialHealth) < 0.2) {
				if (this.stage == 2) {
					this.stage++;
					super.power = super.power*2;
				}
			}
		}
	}
}
