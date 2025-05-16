import java.util.Scanner;

class Game {
    Warrior warr;
    AlienArmy army;
    Satellite sat;
    Telescope telesc;
    Scanner sc;
    int r;
    int totalAliens;
    
    Game() {
        sc = new Scanner(System.in);
        r = 1;
        initialize();
    }
    
    void initialize() {
        sat = new Satellite();
        telesc = new Telescope();
        
        int hp = 100;
        int vis = 50;
        // φτιάχνω warrior
        warr = new Warrior(hp, vis, new DefaultWarriorStrategy());
        
        mexri10();
        int extr = diavase();
        if(extr < 0) extr = 1;
        
        totalAliens = extr; 
        army = new AlienArmy(extr, sc);
        army.registerObserver(sat);
        army.registerObserver(telesc);
        
        mexri10();
        printing("=== MAXH ===");
        printing("HP: " + warr.getPower());
        printing("Oρατότητα: " + warr.getVisibility() + "%");
        printing("Εχθροί: " + extr);
    }
    
    int diavase(){
        int n;
        printing("Πόσοι εχθροί;");
        try{
            n = Integer.parseInt(sc.nextLine());
            if(n <= 0){
                printing("Βαλε >0!");
                return diavase();
            }
            return n;
        }catch(Exception ex){
            printing("Οχι έτσι!");
            return diavase();
        }
    }
    
    void mexri10(){
        for(int i=0; i<1; i++)
            System.out.println();
    }
    
    void printing(String s){
        System.out.println(s);
    }
    
    boolean runRound() {
        mexri10();
        
        String dash = "";
        for(int i=0; i<10; i++) dash += "-";
        
        printing(dash + " GYRΟΣ " + r + " " + dash);
        
        mexri10();
        showStats();
        
        if(r % 2 == 1){
            printing(">>Επίθεση πολεμιστή");
            warr.attack(army, sat, telesc);
            if(army.isDefeated()){
                printing(">>Νικησαμε!! :)");
                return false;
            }
        }else{
            printing(">>Επιτίθενται οι εχθροί...");
            army.attack(warr);
            if(warr.isDefeated()){
                printing(">>Χάσαμε :(");
                return false;
            }
        }
        
        r = r + 1;
        return true;
    }
    
    void showStats() {
        int pow = warr.getPower();
        int vis = warr.getVisibility();
        
        if(pow > 75)
            printing("Μαχητής: " + pow + "hp | " + vis + "% ορατ. | Άψογα!");
        else if(pow > 40)
            printing("Μαχητής: " + pow + "hp | " + vis + "% ορατ. | OK!");
        else
            printing("Μαχητής: " + pow + "hp | " + vis + "% ορατ. | Κίνδυνος!");
            
        int live = army.getAliveCount();
        
        if(live > totalAliens/2)
            printing("Εχθροί: " + live + " απο " + totalAliens + " | Έχουμε δουλειά..");
        else if(live > 0)
            printing("Εχθροί: " + live + " απο " + totalAliens + " | Τους τρέχουμε!");
    }
    
    void play() {
        boolean next = true;
        while(next) {
            next = runRound();
            if(next){
                printing("Πάτα Enter");
                sc.nextLine();
            }
        }
        
        mexri10();
        printing("###ΤΕΛΟΣ ΜΑΧΗΣ###");
        showStats();
        sc.close();
    }
}