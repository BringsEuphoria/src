import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.GroundItems;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.methods.Menu;
import org.rev377.min.api.methods.Npcs;
import org.rev377.min.api.methods.Players;
import org.rev377.min.api.wrappers.GroundItem;
import org.rev377.min.api.wrappers.Item;
import org.rev377.min.api.wrappers.Npc;
import org.soulsplit.api.wrappers.SceneObject;


@ScriptManifest(author = "Daher", category = Category.COMBAT, description = "Kills", name = "CombatKiller 10", servers = { "377" }, version = 0.1)
public class BSCombatKiller extends Script{
	
	private final ArrayList<Strategy> strategy = new ArrayList<Strategy>();
	
	
	@Override
	public boolean onExecute() {
    strategy.add(new Scroll());
    strategy.add(new PickUp());
    strategy.add(new Attack());
	
	
		provide(strategy);

	  
	return (true);
	}
	
	private static Item e;
	public class Scroll implements Strategy {

		@Override
		public boolean activate() {
			
			for(Item d : Inventory.getItems(2774, 2775)){ 
				e = d;
				
				return d != null;
			}
			
			return false;
		}

		@Override
		public void execute() {
			
		
			Menu.sendAction(961, 2774, e.getSlot(), 4521985); // Send actions (Change the actions,except for getSlot)
			Time.sleep(500);
			Menu.sendAction(961, 2773, e.getSlot(), 4521985); // Send actions (Change the actions,except for getSlot)
			Time.sleep(500);
			
		}
		
		
	}
	private static GroundItem f;
	public class PickUp implements Strategy {

		@Override
		public boolean activate() {
			try{
		for(GroundItem n : GroundItems.getNearest(2774, 2775)){ // Got to change id here if you want more pickup.
			f = n;
			
			return n != null;
	
		}
			}catch(NullPointerException e){}		
			
			return false;
		}

		@Override
		public void execute() {
			f.interact(0);
			Time.sleep(500);
		}
		
	}
	private static Npc q;
	public class Attack implements Strategy {

		@Override
		public boolean activate() {
			for(Npc n : Npcs.getNearest(124)){ // Change monster id here.
				q = n;
				return n != null && !Players.getMyPlayer().isInCombat() && !n.isInCombat();
			}
			
			return false;
		}

		@Override
		public void execute() {
			
			q.interact(1);
			Time.sleep(500);
			
		}
		
		
	}
	
}
