package com.example.frontvynils

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CollectorViewTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Test
    fun test_1_navigateToView() {
        var node = composeTestRule.onNodeWithTag("Collectors")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
        node.performClick()
    }

    @Test
    fun test_navigateToCollectorDetailAndNavigateBackToCollectors() {
        test_1_navigateToView()
        Thread.sleep(1000) // Para visualizar en el dispositivo

        composeTestRule.onNodeWithText("Mario Rios").performClick()

        var name = composeTestRule.onNodeWithText("Nombre")
        var phone = composeTestRule.onNodeWithText("Telefono")
        var email = composeTestRule.onNodeWithText("email")
        composeTestRule.waitUntil {
            name.isDisplayed()
        }
        name.assertIsDisplayed()
        phone.assertIsDisplayed()
        email.assertIsDisplayed()

        Thread.sleep(1000) // Para visualizar en el dispositivo

        var backButton = composeTestRule.onNodeWithText("Volver")

        backButton.assertIsDisplayed()
        backButton.assertHasClickAction()
        backButton.performClick()

        var collectorsNode = composeTestRule.onNodeWithTag("Collectors")
        composeTestRule.waitUntil {
            collectorsNode.isDisplayed()
        }

        Thread.sleep(1000) // Para visualizar en el dispositivo

        collectorsNode.assertIsDisplayed()
    }
}