package com.example.compose.rally

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

class ListAlbumsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tesPresentElements(){
        composeTestRule.onNodeWithText("Albums").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Albums").performClick()
        composeTestRule.onNodeWithText("Poeta del pueblo").assertIsDisplayed()
    }
}