package app.revanced.patches.instagram.patches.ads.timeline.fingerprints

import app.revanced.patcher.fingerprint.methodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val isAdCheckOneFingerprint = methodFingerprint {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC,AccessFlags.FINAL)
    parameters()
    opcodes(
        Opcode.XOR_INT_LIT8,
        Opcode.IF_NE,
        Opcode.RETURN,
        Opcode.INVOKE_VIRTUAL,
    )
}
