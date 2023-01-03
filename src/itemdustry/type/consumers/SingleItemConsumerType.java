package itemdustry.type.consumers;

import arc.func.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.blocks.storage.*;
import mindustry.content.*;
import itemdustry.type.*;

public class SingleItemConsumerType extends ConsumerType{
    public Item item = Items.copper;
    public int amount = 1;
    
    public SingleItemConsumerType(Item item, int amount){
        super();
        if(item == null) this.item = item;
        this.amount = amount;
    }
    
    public SingleItemConsumerType(Item item, int amount, Boolf<Unit> predicate, Cons<Unit> onUse){
        this(item, amount);
        this.predicate = predicate;
        this.onUse = onUse;
    }
    
    public boolean hasRequirements(Unit unit){
        if(unit == null) return false;
        Seq<CoreBlock.CoreBuild> core = unit.team.cores();
        
        return core.isEmpty() ? false : core.first().items.has(item, amount);
    }
    
    @Override
    public void use(Unit unit){
        if(hasRequirements(unit) && predicate.get(unit)){
            super.use(unit);
            unit.team.cores().first().items.remove(item, amount);
        }
    }
}
