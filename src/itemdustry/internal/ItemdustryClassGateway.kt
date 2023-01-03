package itemdustry.internal

import mindustry.*
import rhino.*

open class ItemdustryClassGateway{

    fun load(){
        var scope = Vars.mods.scripts.scope as ImporterTopLevel
        
        val packages = Vars.tree.get("classpaths/itemdustry-classpath.txt").readString().split('\n')

        packages.forEach{
            val p = NativeJavaPackage(it, Vars.mods.mainLoader())
            p.parentScope = scope
            scope.importPackage(p)
        }
    }
}
