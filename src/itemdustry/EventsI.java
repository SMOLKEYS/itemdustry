package itemdustry;

import arc.*;
import arc.func.*;

public class EventsI{
    
    public static <T> void once(Class<T> type, Cons<T> listener){
        Events.on(type, consumer -> {
            listener.get(consumer);
            
            Events.remove(type, consumer);
        });
    }
}