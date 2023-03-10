package itemdustry.type.consumers;

import arc.func.*;
import arc.struct.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.blocks.storage.*;
import itemdustry.type.*;

public class MultiItemConsumerType extends ConsumerType{
    public ItemStack[] requirements;
    
    public MultiItemConsumerType(ItemStack[] requirements){
        super();
        
        this.requirements = requirements;
    }
    
    public MultiItemConsumerType(ItemStack[] requirements, Boolf<Unit> predicate, Cons<Unit> onUse){
        this(requirements);
        this.predicate = predicate != null ? predicate : pred -> {return true;};
        this.onUse = onUse;
    }
    
    public boolean hasRequirements(Unit unit){
        if(unit == null) return false;
        Seq<CoreBlock.CoreBuild> core = unit.team.cores();
        
        return core.isEmpty() ? false : core.first().items.has(requirements);
    }
    
    @Override
    public void use(Unit unit){
        if(hasRequirements(unit) && predicate.get(unit)){
            super.use(unit);
            unit.team.cores().first().items.remove(requirements);
        }
    }
}
