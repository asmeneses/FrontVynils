package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.frontvynils.MainActivity
import org.junit.Rule
import org.junit.Test

class AlbumScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkIfAlbum1IsDisplayed() {
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Albums").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Albums").performClick()

        composeTestRule.waitUntil {
            composeTestRule.onNodeWithText("Poeta del Pueblo", ignoreCase = true).isDisplayed()
        }

        composeTestRule.onNodeWithText("Poeta del Pueblo", ignoreCase = true).assertIsDisplayed()
    }

    @Test
    fun checkIfAlbum2IsDisplayed() {
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Albums").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Albums").performClick()

        composeTestRule.waitUntil {
            composeTestRule.onNodeWithText("Buscando América", ignoreCase = true).isDisplayed()
        }

        composeTestRule.onNodeWithText("Buscando América", ignoreCase = true).assertIsDisplayed()
    }
}