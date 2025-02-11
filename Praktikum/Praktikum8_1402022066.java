class Character {
    private String characterName;
    private String origin;
    private String epiphet;
    private int bounty;
    private int health = 100;

    public void viewstat() {
        System.out.println("Nama Karakter    : " + characterName);
        System.out.println("Darah Karakter   : " + health);
        System.out.println("Asal             : " + origin);
        if (epiphet != null)
            System.out.println("Julukan          : " + epiphet);
        System.out.println("Harga Buronan    : " + bounty);
    }

    public Character(String characterName, String origin, String epiphet, int bounty) {
        this.characterName = characterName;
        this.origin = origin;
        this.epiphet = epiphet;
        this.bounty = bounty;
    }

    public Character(String characterName, String origin, int bounty) {
        this.characterName = characterName;
        this.origin = origin;
        this.bounty = bounty;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEpiphet() {
        return epiphet;
    }

    public void setEpiphet(String epiphet) {
        this.epiphet = epiphet;
    }

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0)
            health = 0;
        this.health = health;
    }
}

class Strawhat extends Character implements Weaponed, HaveUltimateAbility {
    private String profession;

    @Override
    public void viewstat() {
        super.viewstat();
        System.out.println("Profesi          : " + getProfession());
        System.out.println("-------------------");
        System.out.println("Nama Senjata     : " + getWeaponName());
        System.out.println("Kekuatan Senjata : " + getWeaponPower() + "\n");
    }

    public Strawhat(String characterName, String origin, String epiphet, int bounty, String profession) {
        super(characterName, origin, epiphet, bounty);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String getWeaponName() {
        if (getCharacterName().equalsIgnoreCase("Roronoa Zoro")) {
            return "Samurai";
        } else if (getCharacterName().equalsIgnoreCase("Usopp"))
            return "Ketapel";
        return "default senjata straw"; // default selain 2 diatas
    }

    @Override
    public int getWeaponPower() {
        if (getCharacterName().equalsIgnoreCase("Roronoa Zoro")) {
            return 9;
        } else if (getCharacterName().equalsIgnoreCase("Usopp"))
            return 4;
        return 100; // default selain 2 diatas
    }

    @Override
    public String getPowerName() {
        if (getCharacterName().equalsIgnoreCase("Roronoa Zoro")) {
            return "Sanzen Sekai";
        } else if (getCharacterName().equalsIgnoreCase("Usopp"))
            return "Kaen Boshi";
        return "default power straw"; // default selain 2 diatas
    }

    @Override
    public int getPower() {
        if (getCharacterName().equalsIgnoreCase("Roronoa Zoro")) {
            return 20;
        } else if (getCharacterName().equalsIgnoreCase("Usopp"))
            return 15;
        return 100; // default selain 2 diatas
    }

    @Override
    public int attack() {
        return getWeaponPower() + getPower();
    }
}

class Beast extends Character implements Weaponed, HaveUltimateAbility {
    private String division;

    @Override
    public void viewstat() {
        super.viewstat();
        System.out.println("Profesi          : " + getDivision());
        System.out.println("-------------------");
        System.out.println("Nama Senjata     : " + getWeaponName());
        System.out.println("Kekuatan Senjata : " + getWeaponPower() + "\n");
    }

    public Beast(String characterName, String origin, String epiphet, int bounty, String division) {
        super(characterName, origin, epiphet, bounty);
        this.division = division;
    }

    public Beast(String characterName, String epiphet, int bounty, String division) {
        super(characterName, epiphet, bounty);
        this.division = division;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String getWeaponName() {
        if (getCharacterName().equalsIgnoreCase("King")) {
            return "Kapak";
        } else if (getCharacterName().equalsIgnoreCase("Queen"))
            return "Pistol";
        return "default senjata beast"; // default selain 2 diatas
    }

    @Override
    public int getWeaponPower() {
        if (getCharacterName().equalsIgnoreCase("King")) {
            return 12;
        } else if (getCharacterName().equalsIgnoreCase("Queen"))
            return 7;
        return 100; // default selain 2 diatas
    }

    @Override
    public String getPowerName() {
        if (getCharacterName().equalsIgnoreCase("King")) {
            return "Ocean Blast";
        } else if (getCharacterName().equalsIgnoreCase("Queen"))
            return "Light Beam";
        return "default power beast"; // default selain 2 diatas
    }

    @Override
    public int getPower() {
        if (getCharacterName().equalsIgnoreCase("King")) {
            return 18;
        } else if (getCharacterName().equalsIgnoreCase("Queen"))
            return 13;
        return 100; // default selain 2 diatas
    }

    @Override
    public int attack() {
        return getWeaponPower() + getPower();
    }
}

interface Weaponed {
    public String getWeaponName();

    public int getWeaponPower();
}

interface HaveUltimateAbility {
    public String getPowerName();

    public int getPower();

    public int attack();
}

public class Praktikum8_1402022066 {
    public static void main(String[] args) {

        Character zoro = new Strawhat("Roronoa Zoro", "West Blue", "Pirate Hunter", 320_000_000, "Combotant");
        Character usop = new Strawhat("Usopp", "East Blue", "Sogeking", 200_000_000, "Sniper");
        Character[] listSrawhat = { zoro, usop };

        zoro.viewstat();
        usop.viewstat();

        Character king = new Beast("King", "North Blue", "King the Wildfire", 1_390_000_000, "All-Stars");
        Character queen = new Beast("Queen", "Queen the Plague", 1_320_000_000, "Tobiroppo");
        Character[] listBeast = { king, queen };

        king.viewstat();
        queen.viewstat();

        battle(listSrawhat[0], listBeast[0]);
    }

    public static void battle(Object a, Object b) {
        Character player1;
        Character player2;
        if (a instanceof Strawhat) {
            player1 = (Strawhat) a;
        } else
            player1 = (Beast) a;

        if (b instanceof Strawhat) {
            player2 = (Strawhat) b;
        } else
            player2 = (Beast) b;

        do {
            System.out.println(player1.getCharacterName() + " Menyerang karakter " + player2.getCharacterName());
            System.out.println("Memakai jurus -> " + ((HaveUltimateAbility) player1).getPowerName()
                    + " Dengan Damage Jurus -> " + ((HaveUltimateAbility) player1).getPower());
            System.out.println("Memakai senjata -> " + ((Weaponed) player1).getWeaponName()
                    + " Dengan Damage Senjata -> " + ((Weaponed) player1).getWeaponPower());
            System.out.println("Total serangan " + player1.getCharacterName() + " Ke karakter "
                    + player2.getCharacterName() + " Adalah " + ((HaveUltimateAbility) player1).attack());
            System.out.println("==============================================");
            player2.setHealth(player2.getHealth() - ((HaveUltimateAbility) player1).attack());
            System.out.println("Darah " + player2.getCharacterName() + " Saat ini tersisa -> " + player2.getHealth());
            System.out.println("==============================================");
        } while (player2.getHealth() > 0);

        player1.setBounty(player1.getBounty() + player2.getBounty());
        player2.setBounty(0);
        System.out.println("==============================================");
        System.out.println("Harga Buronan " + player1.getCharacterName() + " Menjadi -> " + player1.getBounty());
        System.out.println("==============================================");
        player1.viewstat();
        player2.viewstat();
    }
}