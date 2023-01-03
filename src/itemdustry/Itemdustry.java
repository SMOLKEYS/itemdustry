package itemdustry;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import itemdustry.content.*;
import itemdustry.internal.*;

public class Itemdustry extends Mod{

    public Itemdustry(){
        Events.run(ClientLoadEvent.class, () -> {
            new ItemdustryClassGateway().load();
        });
    }

    public static Building placeBlock(Unit unit, Block block){
        unit.tileOn().setBlock(block, unit.team);
        return unit.buildOn();
    }

    @Override
    public void loadContent(){
        ItemdustryConsumers.load();
    }

}
