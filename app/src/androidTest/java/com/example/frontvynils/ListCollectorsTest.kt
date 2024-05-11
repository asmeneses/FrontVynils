package com.example.frontvynils

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CollectorScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun checkIfCollector1IsDisplayed() {
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Collectors").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Collectors").performClick()

        composeTestRule.waitUntil {
            composeTestRule.onNodeWithText("Laura Puerta", ignoreCase = true).isDisplayed()
        }

        composeTestRule.onNodeWithText("Laura Puerta", ignoreCase = true).assertIsDisplayed()
    }

    @Test
    fun checkIfCollector2IsDisplayed() {
        Thread.sleep(1000)
        composeTestRule.onNodeWithText("Collectors").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Collectors").performClick()

        composeTestRule.waitUntil {
            composeTestRule.onNodeWithText("Mario Rios", ignoreCase = true).isDisplayed()
        }

        composeTestRule.onNodeWithText("Mario Rios", ignoreCase = true).assertIsDisplayed()
    }

    @Test
    fun checkScrollingThroughCollectorList() {
        composeTestRule.onNodeWithText("Collectors").assertIsDisplayed().performClick()
        composeTestRule.swipeDown()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Último coleccionista", ignoreCase = true).assertIsDisplayed()
    }
}