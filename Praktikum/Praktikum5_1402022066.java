import java.util.Random;
public class Praktikum5_1402022066{


    public static void main(String[] args) {
        Fighter gatotKaca = new FighterTank("GatotKaca", "Tank", "Sprint", "Midlane");
        Fighter balmond = new FighterHyper("Balmond", "Fighter", "Retribution", "Jungle");
        Marksman claude = new MarksmanGoldLane("Claude", "Marksman", "Inspire", "Goldlane");
        Marksman miya = new MarksmanHyper("Miya", "Marksman", "Retribution", "Jungle");
        gatotKaca.showStatisticHero();
        miya.showStatisticHero();
        
        //data Fighter
        Fighter silvana = new FighterTank("Silvana", "Tank", "Vengeance", "Midlane");
        Fighter xborg = new FighterTank("Xborg", "Tank", "Flameshot", "Roamer");
        Fighter alpha = new FighterHyper("Alpha", "Assasin", "Retri", "Jungle");
        Fighter sun = new FighterHyper("Sun", "Fighter", "Arrival", "Jungle");
        //data Marksman
        Marksman layla = new MarksmanHyper("Layla", "Marksman", "Flicker", "GoldLane");
        Marksman bruno = new MarksmanHyper("Bruno", "Marksman", "Retribution", "Jungle");
        Marksman lesley = new MarksmanHyper("Lesley", "Assasin", "Flameshot", "GoldLane");
        Marksman granger = new MarksmanHyper("Granger", "Jungle", "Retribution", "Jungle");
        FighterHyper sunBaru = (FighterHyper) sun;
        Hero data[] = {silvana, xborg, alpha, sun, layla, bruno, lesley, granger};
        Random random = new Random();
        int heroSatu = random.nextInt(data.length);
        int heroDua;
        do {
            heroDua = random.nextInt(data.length);
        } while (heroDua == heroSatu);
        Hero dataDuelist[] = {data[heroSatu], sun};


        System.out.println("Hero yang akan bertarung adalah hero "  + dataDuelist[0].getName());
        }
    }
    
    class Hero
    {
        //Property
         String name;
         String emblem;
    
        //constructor
        public Hero(String name, String emblem)
        {
            this.name = name;
            this.emblem = emblem;
        }
        
        public void showStatisticHero(){
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
    
     //Setter Getter Methods
    public int getDurability()
    {
        return this.durability;
    }
    public void setDurability(int durability)
    {
        this.durability = durability;
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
            this.spell = spell;
            this.lane = lane;
            setDurability(spell, emblem);
            setSprint(spell);
            setDamage(spell);
        }
        public void setDurability(String spell, String emblem){
            if (spell.equalsIgnoreCase("vengeance")) {
                super.setDurability(super.getDurability() + (super.getDurability() * 1/4));
            }
            if (emblem.equalsIgnoreCase("tank")){
                super.setDurability(super.getDurability() + (super.getDurability() * 1/20));
            }
        }
        public void setSprint(String spell){
            if (spell.equalsIgnoreCase("sprint")) {
                super.setSpeed(super.getSpeed() + 10);
            }
        }
        public void setDamage(String spell){
            if (!spell.equalsIgnoreCase("flameshot")) {
                super.setDamage(super.getDamage() - (super.getDamage() * 1/10));
            }
        }
        public void showStatisticHero(){
            super.showStatisticHero();
            System.out.println("Spell : " + spell);
            System.out.println("Lane : " + lane);
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + super.getSpeed());
            System.out.println("Damage : " + super.getDamage());
        }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getEmblem()
        {
            return emblem;
        }
        public void setEmblem(String emblem)
        {
            this.emblem = emblem;
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
            setDurability(spell, emblem);
            setSprint(spell);
            setDamage(spell);
        }
        public void showStatisticHero(){
            super.showStatisticHero();
            System.out.println("Spell : " + spell);
            System.out.println("Lane : " + lane);
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + super.getSpeed());
            System.out.println("Damage : " + super.getDamage());
        }
        public void setDurability(String spell, String emblem){
            if (spell.equalsIgnoreCase("retribution")) {
                super.setDurability(super.getDurability() - (super.getDurability() * 1/10));
            }
        }
        public void setSprint(String spell){
            if (spell.equalsIgnoreCase("sprint")) {
                super.setSpeed(super.getSpeed() + 10);
            }
        }
        public void setDamage(String spell){
            if (spell.equalsIgnoreCase("retribution")) {
                super.setDamage(super.getDamage() + (super.getDamage() * 1/5));
            }
        }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getEmblem()
        {
            return emblem;
        }
        public void setEmblem(String emblem)
        {
            this.emblem = emblem;
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
    
     //Setter Getter Methods
    public int getDurability()
    {
        return this.durability;
    }
    public void setDurability(int durability)
    {
        this.durability = durability;
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
            super.setDurability(super.getDurability() + 200);
            super.setSpeed(super.getSpeed() + 50);
            super.setDamage(super.getDamage() + (super.getDamage() * 1/10));
        }
        
        public void showStatisticHero(){
            super.showStatisticHero();
            System.out.println("Spell : " + spell);
            System.out.println("Lane : " + lane);
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + super.getSpeed());
            System.out.println("Damage : " + super.getDamage());
        }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getEmblem()
        {
            return emblem;
        }
        public void setEmblem(String emblem)
        {
            this.emblem = emblem;
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
            super.setDurability(super.getDurability() - 400);
            super.setSpeed(super.getSpeed() + 150);
            super.setDamage(super.getDamage() + (super.getDamage() * 2/5));
        }
        public void showStatisticHero(){
            super.showStatisticHero();
            System.out.println("Spell : " + spell);
            System.out.println("Lane : " + lane);
            System.out.println("Durability : " + super.getDurability());
            System.out.println("Speed : " + super.getSpeed());
            System.out.println("Damage : " + super.getDamage());
        }
    
        public String getSpell()
        {
            return spell;
        }
        public void setSpell(String spell)
        {
            this.spell = spell;
        }
    
        public String getEmblem()
        {
            return emblem;
        }
        public void setEmblem(String emblem)
        {
            this.emblem = emblem;
        }
    }