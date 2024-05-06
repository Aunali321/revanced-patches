package app.revanced.patches.photomath.misc.unlock.bookpoint


import app.revanced.patcher.extensions.InstructionExtensions.replaceInstructions
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patches.photomath.misc.unlock.bookpoint.fingerprints.isBookpointEnabledFingerprint

internal val enableBookpointPatch = bytecodePatch(
    name = "Enable textbook access",
) {
    val isBookpointEnabledResult by isBookpointEnabledFingerprint

    execute {
        isBookpointEnabledResult.mutableMethod.replaceInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}