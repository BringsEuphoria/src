package scripts;


import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.types.RSNPC;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

@ScriptManifest(authors = {"Daher"}, version = 1.0, category = "Agility", name = "Daher THE KING", description = "idkf")
public class Lockpicker extends Script {

    public void run() {


        while(true){

            loop();

        }



    }



    private void loop() {
 npcInteracting();
        shopBuying();
        sleep(100, 200);

        }
    public void shopBuying(){

        if(Shop.isShopOpen() && !Inventory.isFull()) {
          Shop.buy(10, 1523);
            sleep(500, 700);
        }
        }



    public void npcInteracting(){
RSNPC[] g = NPCs.findNearest(3193);
if(g.length > 0 && !Shop.isShopOpen()){
    if(g[0].isOnScreen()){
g[0].click("Trade Martin Thwait");
        sleep(500, 700);

    }

}

}

    }
