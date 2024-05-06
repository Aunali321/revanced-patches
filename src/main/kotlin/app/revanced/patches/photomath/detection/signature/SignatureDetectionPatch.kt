package app.revanced.patches.photomath.detection.signature

import app.revanced.patcher.extensions.InstructionExtensions.getInstruction
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.bytecodePatch
import app.revanced.patches.photomath.detection.signature.fingerprints.checkSignatureFingerprint
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

val signatureDetectionPatch = bytecodePatch(
    name = "Disable signature detection",
    description = "Disables detection of incorrect signature.",
) {
    val checkSignatureResult by checkSignatureFingerprint

    execute {
        checkSignatureResult.apply {
            val signatureCheckInstruction = mutableMethod.getInstruction(scanResult.patternScanResult!!.endIndex)
            val checkRegister = (signatureCheckInstruction as OneRegisterInstruction).registerA

            mutableMethod.replaceInstruction(signatureCheckInstruction.location.index, "const/4 v$checkRegister, 0x1")
        }
    }

}
