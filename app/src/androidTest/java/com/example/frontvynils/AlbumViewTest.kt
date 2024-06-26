package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AlbumViewTest {
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
    fun test_navigateToAlbumDetailAndNavigateBackToAlbums() {
        test_1_navigateToView()
        Thread.sleep(1000) // Para visualizar en el dispositivo

        var album = composeTestRule.onNodeWithText("Buscando América")

        composeTestRule.waitUntil {
            album.isDisplayed()
        }

        album.performClick()

        Thread.sleep(1000) // Para visualizar en el dispositivo

        var name = composeTestRule.onNodeWithText("Nombre")
        composeTestRule.waitUntil {
            name.isDisplayed()
        }
        name.assertIsDisplayed()

        Thread.sleep(1000) // Para visualizar en el dispositivo

        var backButton = composeTestRule.onNodeWithText("Volver")

        backButton.assertIsDisplayed()
        backButton.assertHasClickAction()
        backButton.performClick()

        var albumsNode = composeTestRule.onNodeWithText("Albums")
        composeTestRule.waitUntil {
            albumsNode.isDisplayed()
        }

        Thread.sleep(1000) // Para visualizar en el dispositivo

        albumsNode.assertIsDisplayed()
    }
}