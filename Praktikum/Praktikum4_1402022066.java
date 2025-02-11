class Hero{
	private String name;
	private String emblem;
	public Hero(String name, String emblem){
		this.name = name;
		this.emblem= emblem;
	}
	public void showStatisticHero(){
		System.out.println("Nama       : " + name);
		System.out.println("Emblem     : " + emblem);
	}
	public String getName(){
		return name;
	}
	public String getEmblem(){
		return emblem;
	}
}

class Fighter extends Hero{
	private int durability = 3000;
	private int speed = 150;
	private int damage = 100;

	public Fighter(String name, String emblem){
		super(name, emblem);
	}

	public int getDurability(){
		return durability;
	}
	public int getSpeed(){
		return speed;
	}
	public int getDamage(){
		return damage;
	}
	public void setDurability(String spell){
		if (spell == "Vengeance" ) {
			this.durability = this.durability + (this.durability * 25/100);
		}
		if (getEmblem() == "Tank") {
			getDurability();
		}
	}
}

class Marksman extends Hero{
	private int durability = 2000;
	private int speed = 200;
	private int damage = 200;

	public Marksman(String name, String emblem){
		super(name, emblem);
	}

	public int getDurability(){
		return durability;
	}
	public int getSpeed(){
		return speed;
	}
	public int getDamage(){
		return damage;
	}
}

class FighterTank extends Fighter{
	private String spell;
	private String lane;
	public FighterTank(String name, String emblem, String spell, String lane){
		super(name, emblem);
		this.spell = spell;
		this.lane = lane;
	}
	public void showStatisticHero(){
		System.out.println("Nama       : " + getName());
		System.out.println("Emblem     : " + getEmblem());
		System.out.println("Spell      : " + spell);
		System.out.println("Lane       : " + lane);
		System.out.println("Durability : " + getDurability());
		System.out.println("Speed      : " + getSpeed());
		System.out.println("Damage     : " + getDamage());
	}
	
	public void setSpeed(){
		if (spell == "Sprint") {
			getSpeed();
		}
	}
	public void setDamage(){
		if (spell == "Flameshot") {
			getDamage();
		}
	}
}

class FighterHyper extends Fighter{
	private String spell;
	private String lane;
	public FighterHyper(String name, String emblem, String spell, String lane){
		super(name, emblem);
		this.spell = spell;
		this.lane = lane;
	}
	public void showStatisticHero(){
		System.out.println("Nama       : " + getName());
		System.out.println("Emblem     : " + getEmblem());
		System.out.println("Spell      : " + spell);
		System.out.println("Lane       : " + lane);
		System.out.println("Durability : " + getDurability());
		System.out.println("Speed      : " + getSpeed());
		System.out.println("Damage     : " + getDamage());
	}
	public void setDurability(){
		if (spell == "Retribution") {
			//-1/10
		}
	}
	public void setSpeed(){
		if (spell = "Sprint") {
			//+1/10
		}
	}
	public void setDamage(){
		if (spell == "Retribution") {
			//+1/5
		}
	}
}

class MarksmanGoldLane extends Marksman{
	private String spell;
	private String lane;
	public MarksmanGoldLane(String name, String emblem, String spell, String lane){
		super(name, emblem);
		this.spell = spell;
		this.lane = lane;
	}
	public void showStatisticHero(){
		System.out.println("Nama       : " + getName());
		System.out.println("Emblem     : " + getEmblem());
		System.out.println("Spell      : " + spell);
		System.out.println("Lane       : " + lane);
		System.out.println("Durability : " + getDurability());
		System.out.println("Speed      : " + getSpeed());
		System.out.println("Damage     : " + getDamage());
	}
	public void setDurability(){
		
	}
	public void setSpeed(){

	}
	public void setDamage(){
		
	}
}

class MarksmanHyper extends Marksman{
	private String spell;
	private String lane;
	public MarksmanHyper(String name, String emblem, String spell, String lane){
		super(name, emblem);
		this.spell = spell;
		this.lane = lane;
	}
	public void showStatisticHero(){
		System.out.println("Nama       : " + getName());
		System.out.println("Emblem     : " + getEmblem());
		System.out.println("Spell      : " + spell);
		System.out.println("Lane       : " + lane);
		System.out.println("Durability : " + getDurability());
		System.out.println("Speed      : " + getSpeed());
		System.out.println("Damage     : " + getDamage());
	}
	public void setDurability(){

	}
	public void setSpeed(){

	}
	public void setDamage(){
		
	}
}
class Praktikum4_1402022066{
	public static void main(String[] args) {
		Fighter GatotKaca = new FighterTank("GatotKaca", "Tank", "Sprint", "MidLane");
		Fighter Balmond = new FighterHyper("Balmond", "Fighter", "Fighter", "Jungle");
		Marksman Claude = new MarksmanGoldLane("Claude", "Marksman", "Inspire", "GoldLane");
		Marksman Miya = new MarksmanHyper("Miya", "Marksman", "Retribution", "Jungle");
		GatotKaca.showStatisticHero();
		System.out.println();
		Balmond.showStatisticHero();
		System.out.println();
		Claude.showStatisticHero();
		System.out.println();
		Miya.showStatisticHero();
	}
}