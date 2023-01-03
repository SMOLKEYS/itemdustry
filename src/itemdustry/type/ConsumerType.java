package itemdustry.type;

import arc.func.*;
import arc.struct.*;
import mindustry.gen.*;
import itemdustry.type.*;


public class ConsumerType{
    
    public static Seq<ConsumerType> instances = new Seq<>();
    
    public Cons<Unit> onUse = unit -> {};
    public Boolf<Unit> predicate = unit -> {
        return true;
    };
    
    public ConsumerType(){
        instances.add(this);
    }
    
    public void use(Unit unit){
        onUse.get(unit);
    }
}
