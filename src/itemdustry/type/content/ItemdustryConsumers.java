package itemdustry.content;

import mindustry.content.*;
import itemdustry.*;
import itemdustry.type.*;
import itemdustry.type.consumers.*;

public class ItemdustryConsumers{
    public static ConsumerType
    
    duoCall;
    
    
    public static void load(){
        duoCall = new SingleItemConsumerType(Items.copper, 50, upred -> {
            return upred.blockOn() == Blocks.air;
        }, ucons -> Itemdustry.placeBlock(ucons, Blocks.duo).handleStack(Items.copper, 15, ucons));
    }
}
