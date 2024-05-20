package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import com.example.frontvynils.ui.navigation.MainScreen
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AlbumViewTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<TestActivity>()

    @Before
    fun init() {
        composeTestRule.setContent {
            MainScreen(
                albumRepository = AlbumRepositoryMock(),
                collectorRepository = CollectorRepositoryMock()
            )
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