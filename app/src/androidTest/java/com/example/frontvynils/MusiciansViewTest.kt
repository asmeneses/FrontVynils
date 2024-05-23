package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MusiciansViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Test
    fun test_1_navigateToArtistsView() {
        var node = composeTestRule.onNodeWithTag("Artists")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
        node.performClick()
    }

    @Test
    fun test_2_checkViewContent() {
        test_1_navigateToArtistsView()
        Thread.sleep(1000)

        var node = composeTestRule.onNodeWithText("Steven taylor")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
    }
}