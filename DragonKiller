import java.util.ArrayList;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev377.min.api.methods.Bank;
import org.rev377.min.api.methods.GroundItems;
import org.rev377.min.api.methods.Inventory;
import org.rev377.min.api.methods.Menu;
import org.rev377.min.api.methods.Npcs;
import org.rev377.min.api.methods.Players;
import org.rev377.min.api.methods.SceneObjects;
import org.rev377.min.api.wrappers.GroundItem;
import org.rev377.min.api.wrappers.Item;
import org.rev377.min.api.wrappers.Npc;
import org.rev377.min.api.wrappers.SceneObject;



@ScriptManifest(author = "(Daher) ",
category = Category.COMBAT,
description = "Fights dragons",
name = "XxDragonSlayerBeastXx",
servers = { "377 only" },
version = 1.0)
public class DragonKiller extends Script{
	

	
	private final ArrayList<Strategy> strategy = new ArrayList<Strategy>();
	
	
	@Override
	public boolean onExecute() {
		strategy.add(new Pick());
		strategy.add(new Fight());
		strategy.add(new Scroll());
		strategy.add(new GoUp());
		strategy.add(new Banking());
		strategy.add(new Talk());
	
	
		provide(strategy);

	  
	return (true);
	}
	private static SceneObject p;
	
	public class GoUp implements Strategy {

		@Override
		public boolean activate() {
			for (Npc d : Npcs.getNearest(941)){
			for (SceneObject n : SceneObjects.getNearest(6439)){
				p = n;
				npc = d;
				return n != null && d != null && Inventory.isFull();
			}
			}
			return false;
		}

		@Override
		public void execute() {	
			if(p != null){
				p.interact(0);
				Time.sleep(500);
				
			}else if(p.getLocation().isReachable() && p.getLocation().isOnMinimap()){
				p.getLocation().walkTo();
				Time.sleep(500);
			}
			
		}
		
	}
	private static Item c;
	public class Scroll implements Strategy {

		public boolean activate() {
			for (Item n : Inventory.getItems(2775)){
			c = n;
				return n != null;
			}
			
			return false;
		}



		public void execute() {
				
			
			Menu.sendAction(961, 2774, c.getSlot(), 4521985);
			Time.sleep(500);
			}
		
			
		}
	private static GroundItem we;
	public class Pick implements Strategy {

		@Override
		public boolean activate() {
			for (GroundItem n : GroundItems.getNearest(536,2774)){
				we = n;	
				
			
			
			return n != null && !Inventory.isFull();
				
			
		}
			return false;
		}

		@Override
		public void execute() {
			if(we != null){
			we.interact(0);
			Time.sleep(2500);
			
			}else if(we.getLocation().isReachable() && we.getLocation().isOnMinimap()){
				we.getLocation().walkTo();
			}
			
		}
	
			
		
		
	}
	
private static Npc npc;
	public class Fight implements Strategy {
		
		@Override
		public boolean activate() {
			
		
			for (Npc n : Npcs.getNearest(941)){
		
				npc = n;
				
				return n != null &&  !Inventory.isFull();
				
			
				
				
				
				}
			
			
			return false;
		}

		@Override
		public void execute() {
			if(!npc.isInCombat() && !Players.getMyPlayer().isInCombat()){
				npc.interact(1);
				Time.sleep(500);
			}else if(!Players.getMyPlayer().isInCombat() && !npc.isInCombat()){
				npc.getLocation().walkTo();
				Time.sleep(500);
				
		
				
			
		
			}
			
		}
		
		
	}
	public class Banking implements Strategy {

		@Override
		public boolean activate() {
			
			if(Inventory.isFull()){
				return Bank.getBank() != null && SceneObjects.getNearest(941).length == 0;
			}
			
			return false;
		}

		@Override
		public void execute() {
			
		if(!Bank.isOpen()){
				Bank.getBank().interact(1);
				Time.sleep(500);
				
			}else if(Bank.isOpen() && Inventory.isFull()){
				Bank.depositAll();
				Time.sleep(500);
			
			}else if(Bank.getBank().getLocation().isOnMinimap()){
				Bank.getBank().getLocation().walkTo();
				Time.sleep(500);
				}
			
			
			
		}
	
	}
	private static Npc b;
	public class Talk implements Strategy {

		@Override
		public boolean activate() {
		
			for (Npc n : Npcs.getNearest(941)){
				b = n; 
				
				return (n != null && !Inventory.isFull());
			}
			return false;
		}

		@Override
		public void execute() {
		

			
		
				if(!b.equals(Players.getMyPlayer().getInteractingCharacter())){
				b.interact(0);
				Time.sleep(500);
				}else if(b.equals(Players.getMyPlayer().getInteractingCharacter())){
					Menu.sendAction(352,1775,341,3801092);
					Time.sleep(500);
					Menu.sendAction(352,17,206,3670018);
					Time.sleep(500);
					Menu.sendAction(352,17,240,3735556);
					Time.sleep(500);
				}else if(b.getLocation().isOnMinimap() && b == null);
				b.getLocation().walkTo();
				Time.sleep(500);
			}
		
			
		
	}
}
