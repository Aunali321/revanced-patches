package app.revanced.patches.memegenerator.misc.pro.fingerprints

import app.revanced.patcher.fingerprint.methodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val isFreeVersionFingerprint = methodFingerprint {
    returns("Ljava/lang/Boolean;")
    accessFlags(AccessFlags.PUBLIC,AccessFlags.STATIC)
    strings("free")
    parameters("Landroid/content/Context;")
    opcodes(
        Opcode.SGET,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CONST_STRING,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ
    )
}
