package com.ofamosoron.tdd

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PlaylistFeature {

    @get:Rule
    val mActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun titleDisplayed() {
        assertDisplayed("Playlists")
    }
}