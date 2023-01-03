package itemdustry.content;

import mindustry.content.*;
import itemdustry.*;
import itemdustry.type.*;
import itemdustry.type.consumers.*;

public class ItemdustryConsumers{
    public static ConsumerType
    
    duoCall, duoBulletRain;
    
    
    public static void load(){
        duoCall = new SingleItemConsumerType(Items.copper, 50, upred -> {
            return upred.blockOn() == Blocks.air;
        }, ucons -> Itemdustry.placeBlock(ucons, Blocks.duo).handleStack(Items.copper, 15, ucons));
        
        duoBulletRain = new SingleItemConsumerType(Items.copper, 100, null, ucons -> {
            for(int i = 0; i > 100; i++){
                Time.run((float)i, () -> Blocks.duo.ammoTypes.get(Items.copper).create(ucons, ucons.x, ucons.y, Itemdustry.circleRandom()));
            };
        });
    }
}
