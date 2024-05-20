package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AlbumsViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Test
    fun test_1_navigateToView() {
        var node = composeTestRule.onNodeWithTag("Albums")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
        node.performClick()
    }

    @Test
    fun test_2_checkViewContent() {
        test_1_navigateToView()
        Thread.sleep(1000)

        var node = composeTestRule.onNodeWithText("Buscando América")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
    }
}