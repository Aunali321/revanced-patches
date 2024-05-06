package app.revanced.patches.lightroom.misc.premium

import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patches.lightroom.misc.premium.fingerprints.hasPurchasedFingerprint

@Suppress("unused")
val unlockPremiumPatch = bytecodePatch(
    name = "Unlock premium",
){
    compatibleWith("com.adobe.lrmobile"("6.3.0"))

    val hasPurchasedResult by hasPurchasedFingerprint

    execute {
         // Set hasPremium = true.
        hasPurchasedResult.mutableMethod.replaceInstruction(2, "const/4 v2, 0x1")
    }
}