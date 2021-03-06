/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.amazonaws.services.chime.sdk.meetings.internal.video

import android.content.Context
import com.amazonaws.services.chime.sdk.meetings.session.MeetingSessionConfiguration
import com.amazonaws.services.chime.sdk.meetings.utils.logger.Logger
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class DefaultVideoClientControllerTest {
    @MockK
    private lateinit var mockContext: Context

    @MockK
    private lateinit var mockLogger: Logger

    @MockK
    private lateinit var mockVideoClientStateController: VideoClientStateController

    @MockK
    private lateinit var mockVideoClientObserver: VideoClientObserver

    @MockK
    private lateinit var mockConfiguration: MeetingSessionConfiguration

    @InjectMockKs
    private lateinit var testVideoClientController: DefaultVideoClientController

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `start should call VideoClientStateController start`() {
        testVideoClientController.start()

        verify { mockVideoClientStateController.start() }
    }

    @Test
    fun `startLocalVideo should call VideoClientStateController stop`() {
        runBlockingTest {
            testVideoClientController.stopAndDestroy()
        }

        verify { mockVideoClientStateController.stop() }
    }
}
