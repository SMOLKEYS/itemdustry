package itemdustry;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import itemdustry.content.*;

public class Itemdustry extends Mod{

    public Itemdustry(){
        
    }

    public static Building placeBlock(Unit target, Block block){
        unit.tileOn().setBlock(block, unit.team);
        return unit.buildOn();
    }

    @Override
    public void loadContent(){
        ItemdustryConsumers.load();
    }

}
