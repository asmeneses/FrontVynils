package com.example.frontvynils

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.frontvynils.repository.AlbumRepositoryMock
import com.example.frontvynils.ui.navigation.MainScreen
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AlbumViewTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Before
    fun init() {
        composeTestRule.setContent {
            MainScreen(albumRepository = AlbumRepositoryMock())
        }
    }

    @Test
    fun test_navigateToAlbumDetailAndNavigateBackToAlbums() {
        Thread.sleep(1000) // Para visualizar en el dispositivo

        composeTestRule.onNodeWithText("Buscando América").performClick()

        var node = composeTestRule.onNodeWithText("Nombre")
        composeTestRule.waitUntil {
            node.isDisplayed()
        }
        node.assertIsDisplayed()

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