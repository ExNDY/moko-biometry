/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.biometry

import dev.icerock.moko.resources.desc.StringDesc

expect class BiometryAuthenticator() {

    /**
     * Performs user authentication using biometrics-fingerprint/face scan-returns the result of the scan
     *
     * @param requestReason - Text describing the reason for confirmation via biometrics
     * @param failureButtonText - Text of the button to go to the backup verification method in
     * case of unsuccessful biometrics recognition
     *
     * @throws Exception if authentication failed
     *
     * @return true for successful confirmation of biometrics, false for unsuccessful confirmation
     */

    suspend fun checkBiometryAuthentication(
        requestReason: StringDesc,
        failureButtonText: StringDesc
    ): Boolean

    /**
     * Performs a fingerprint scan availability check
     *
     * @return true if it is possible to use a fingerprint scanner, false - if it is not available
     */

    fun isTouchIdEnabled(): Boolean

    /**
     * Performs the availability check of the FaceID scan
     *
     * @return true if it is possible to use the face scanner, false - if it is not available
     */

    fun isFaceIdEnabled(): Boolean
}
