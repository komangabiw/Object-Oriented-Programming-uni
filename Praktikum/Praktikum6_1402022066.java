public class Praktikum6_1402022066{


    public static void main(String[] args) { 
    Fighter[] heroFighterTank = new FighterTank[2];    Fighter[] heroFighterHyper = new FighterHyper[2];
    heroFighterTank[0] = new FighterTank("Tigreal","Tank", "Sprint", "Midlane");
    heroFighterTank[1] = new FighterTank("X-Borg","Tank", "Vengeance", "Roamer");
    heroFighterHyper[0] = new FighterHyper("Alucard","Assasin", "Retribution", "Jungle");
    heroFighterHyper[1] = new FighterHyper("Dyroth","Jungle", "Arrival", "Jungle");
    Marksman[] heroMarksmanGold = new MarksmanGoldLane[2];  Marksman[] heroMarksmanHyper = new MarksmanHyper[2];
    heroMarksmanGold[0] = new MarksmanGoldLane("Claude","Support", "Vengeance", "GoldLane");
    heroMarksmanGold[1] = new MarksmanGoldLane("Layla","Marksman", "Sprint", "GoldLane");
    heroMarksmanHyper[0] = new MarksmanHyper("Miya", "Marksman", "Retribution", "Jungle");
    heroMarksmanHyper[1] = new MarksmanHyper("Grenger","Assasin", "Retribution", "Jungle");
       
    if(heroFighterTank[0] instanceof Fighter || heroFighterTank[1] instanceof Fighter){
        Fighter FghterTank1 = (Fighter) heroFighterTank[0];
        Fighter FghterTank2 = (Fighter) heroFighterTank[1];
        FghterTank1.display();  FghterTank2.display();
        if(heroFighterHyper[0] instanceof Fighter || heroFighterHyper[1] instanceof Fighter){
            Fighter FghterCore1 = (Fighter) heroFighterHyper[0];
        Fighter FghterCore2 = (Fighter) heroFighterHyper[1];
        FghterCore1.display();  FghterCore2.display();
    
        if(heroMarksmanGold[0] instanceof Marksman || heroMarksmanGold[1] instanceof Marksman){
            Marksman mmGold1 = (Marksman) heroMarksmanGold[0];
            Marksman mmGold2 = (Marksman) heroMarksmanGold[1];
            mmGold1.display();  mmGold2.display();
        
        if(heroMarksmanHyper[0] instanceof Marksman || heroMarksmanHyper[1] instanceof Marksman){
            Marksman mmCore1 = (Marksman) heroMarksmanHyper[0];
            Marksman mmCore2 = (Marksman) heroMarksmanHyper[1];
            mmCore1.display();  mmCore2.display();
            pertarunganHero(mmCore1,mmGold1);
        }
        }
        }
        
    }
}
    private static void pertarunganHero(Hero a,Hero b){ boolean gameOver = false;
        System.out.println("\nHero yang akan bertarung adalah hero " + a.getName() + " melawan " + b.name);
        System.out.println("Durability hero " + a.getName() + " saat ini sebesar: " + a.getDurability());
        System.out.println("Durability hero " + b.getName() + " saat ini sebesar: " + b.getDurability());
        System.out.println("==================================================");
      
        while (!gameOver) {
        if(!gameOver){
            if ((b.getDurability() != 0) ) {
                a.Attack(b);
                if (b.getDurability() == 0) {
                    gameOver = false;
                }else if ((a.getDurability() !=0)) {
                    
                    b.AttackBalik(a);
                }
              
            }  else if ((a.getDurability() == 0) || (b.getDurability() == 0)) {
               
                    
                    gameOver = false;
                
            }

        }
         gameOver = (a.getDurability() <= 0) || (b.getDurability() <= 0);
    }
    if (a.getDurability() > b.getDurability())
		{
			System.out.println("Pemenangnya adalah hero: " + a.getName());
		}
		else
		{
			System.out.println("Pemenangnya adalah hero: " + b.getName());
		}
        
    }
}
    
    class Hero
    {   
        //Property
         String name;
         String emblem;
        public void Attack(Hero enemy){
            enemy.setDurability(enemy.getDurability() - this.getDamage());
            System.out.println("\n==================================================");
            System.out.println("Saatnya " + this.name + " menyerang " + enemy.name);
            System.out.println("Durability hero " + enemy.name + " saat ini sebesar: " + enemy.getDurability());
            System.out.println("==================================================\n");
        }
        public void AttackBalik(Hero a){
            a.setDurability(a.getDurability() - this.getDamage());
            System.out.println("==================================================\n");
            System.out.println("Saatnya " + this.name + " menyerang " + a.name);
            System.out.println("Durability hero " + a.name + " saat ini sebesar: " + a.getDurability());
            System.out.println("\n==================================================");
          
        }
        public int getDamage(){
            return this.getDamage();
        }
        public int getDurability(){
            return this.getDurability();
        }
        public void setDurability(int durability){
            setDurability(this.getDurability());
        }
        //constructor
        public Hero(String name, String emblem)
        {
            this.name = name;
            this.emblem = emblem;
        }
        void display(){

            System.out.println("Nama : " + getName());
            System.out.println("Emblem : " + getEmblem());
         }
    
        //Setter Getter Methods
        public String getName()
        {
            return this.name;
        }
        public void setName(String name)
        {
            this.name = name;
        }

        public String getEmblem()
        {
            return this.emblem;
        }
        public void setEmblem(String emblem)
        {
            this.emblem = emblem;
        }
    
    
    }
    class Fighter extends Hero
    {
     private int durability = 3000;
     private int speed = 150;
     private int damage = 100;
    
     public Fighter(String name, String emblem)
     {
         super(name, emblem);
     }
     void display(){
        super.display();
     }
    
     //Setter Getter Methods
    public int getDurability()
    {
        return this.durability;
    }
    public void setDurability(int durability)
    {
        this.durability = durability;
        if (this.durability <= 0) {
            this.durability=0;
        }
    }
    
    public int getSpeed()
    {
        return this.speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    } 
    
    public int getDamage()
    {   
        return this.damage;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    
    }
    class FighterTank extends Fighter
    {
        private String spell;
        private String lane;
    
        public FighterTank(String name, String emblem, String spell, String lane)
        {
            super(name, emblem);
            this.spell = spell; this.lane = lane;   
            if (spell.equalsIgnoreCase("Vengeance")) {
        super.setDurability(super.getDurability() + super.getDurability() * 25/100);
            }if(emblem.equalsIgnoreCase("Tank")){
                super.setDurability(super.getDurability() + super.getDurability() * 5/100);
            }if (spell.equalsIgnoreCase("Sprint")) {
                super.setSpeed(super.getSpeed() + 10);
            }if(!spell.equalsIgnoreCase("Flameshot")){
                super.setDamage(super.getDamage() - super.getDamage() * 10/100);
            }   
    }   
        void display(){
           System.out.println("\n=====Fighter Tank=======");
           super.display();
           System.out.println("Spell : " + getSpell());
           System.out.println("Lane : " + getLane());
           System.out.println("Durability : " + super.getDurability());
           System.out.println("Speed : " + getSpeed());
           System.out.println("Damage : " + getDamage());
         }
        
        
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getLane()
        {
            return this.lane;
        }
        public void setLane(String lane)
        {
            this.lane = lane;
        }
    }
    class FighterHyper extends Fighter
    {
        private String spell;
        private String lane;
    
        public FighterHyper(String name, String emblem, String spell, String lane)
        {
            super(name, emblem);
            this.spell = spell;
            this.lane = lane;
            if (spell.equalsIgnoreCase("Retribution")) {
            super.setDurability(super.getDurability() - super.getDurability() * 10/100);
        }if(spell.equalsIgnoreCase("Retribution")){
            super.setDamage(super.getDamage() + super.getDamage() * 20/100);
        }if (spell.equalsIgnoreCase("Sprint")) {
            super.setSpeed(super.getSpeed() + 10);
        }
    }   
        void display(){
            System.out.println("\n=====Fighter Hyper=======");
            super.display();
            System.out.println("Spell : " + getSpell());
            System.out.println("Lane : " + getLane());
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + getSpeed());
            System.out.println("Damage : " + getDamage());
          }
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getLane()
        {
            return this.lane;
        }
        public void setLane(String lane)
        {
            this.lane = lane;
        }
    }
    class Marksman extends Hero{
    private int durability = 2000;
    private int speed = 200;
    private int damage = 200;
    
     public Marksman(String name, String emblem)
     {
         super(name, emblem);
     }
     void display(){
        super.display();
     }
    
     //Setter Getter Methods
    public int getDurability()
    {
        return this.durability;
    }
    public void setDurability(int durability)
    {
        this.durability = durability;
        if (this.durability <= 0) {
            this.durability=0;
        }
    }
    
    public int getSpeed()
    {
        return this.speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    } 
    
    public int getDamage()
    {
        return this.damage;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
    class MarksmanGoldLane extends Marksman
    {
        private String spell;
        private String lane;
    
        public MarksmanGoldLane(String name, String emblem, String spell, String lane)
        {
            super(name, emblem);
            this.spell = spell;
            this.lane = lane;
            this.setDurability(super.getDurability()+ 200); this.setSpeed(super.getSpeed() + 50); setDamage(getDamage()+ getDamage() * 10/100);
        }
        void display(){
            System.out.println("\n=====Marksman Gold Line=======");
            super.display();
            System.out.println("Spell : " + getSpell());
            System.out.println("Lane : " + getLane());
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + getSpeed());
            System.out.println("Damage : " + getDamage());
          }

          public void setDurability(int durability)
          {
             
                  super.setDurability(durability);
              
          }   public void setSpeed(int speed)
    {
        
            super.setSpeed(speed);
        
    } public void setDamage(int damage)
    {
            super.setDamage(damage);
    }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getLane()
        {
            return this.lane;
        }
        public void setLane(String lane)
        {
            this.lane = lane;
        }
    }
    class MarksmanHyper extends Marksman
    {
        private String spell;
        private String lane;
    
        public MarksmanHyper(String name, String emblem, String spell, String lane)
        {
            super(name, emblem);
            this.spell = spell;
            this.lane = lane;
            this.setDurability(super.getDurability() - 400); this.setSpeed(super.getSpeed() + 150); this.setDamage(getDamage() + getDamage() *40/100);
        }

        void display(){
            System.out.println("\n=====Marksman Hyper=======");
            super.display();
            System.out.println("Spell : " + getSpell());
            System.out.println("Lane : " + getLane());
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + getSpeed());
            System.out.println("Damage : " + getDamage());
          }

        public void setDurability(int durability)
    {
       
            super.setDurability(durability);
        
    }   public void setSpeed(int speed)
    {
        
            super.setSpeed(speed);
        
    } public void setDamage(int damage)
    {
            super.setDamage(damage);
    }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getLane()
        {
            return this.lane;
        }
        public void setLane(String lane)
        {
            this.lane = lane;
        }
    }
    