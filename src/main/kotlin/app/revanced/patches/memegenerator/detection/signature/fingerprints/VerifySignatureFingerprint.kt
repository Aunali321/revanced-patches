package app.revanced.patches.memegenerator.detection.signature.fingerprints

import app.revanced.patcher.fingerprint.methodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

internal val verifySignatureFingerprint = methodFingerprint(fuzzyPatternScanThreshold = 2) {
    returns("Z")
    accessFlags(AccessFlags.PUBLIC,AccessFlags.STATIC)
    parameters("Landroid/app/Activity;")
    opcodes(
        Opcode.SGET_OBJECT,
        Opcode.IF_NEZ,
        Opcode.INVOKE_STATIC,
        Opcode.CONST_4,
        Opcode.CONST_4,
        Opcode.SGET_OBJECT,
        Opcode.ARRAY_LENGTH,
        Opcode.IF_GE,
        Opcode.AGET_OBJECT,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.SGET_OBJECT,
        Opcode.IF_EQZ,
        Opcode.INVOKE_VIRTUAL,
        Opcode.MOVE_RESULT,
        Opcode.IF_EQZ,
        Opcode.CONST_4,
        Opcode.RETURN,
        Opcode.ADD_INT_LIT8
    )
}