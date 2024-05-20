package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import com.example.frontvynils.ui.navigation.MainScreen
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AlbumsViewTest {

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
    fun test_1_checkViewMounted() {
        var node = composeTestRule.onNodeWithText("Albums")

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
        node.assertHasClickAction()
        node.performClick()
    }

    @Test
    fun test_2_checkViewContent() {
        var node = composeTestRule.onNodeWithText("Buscando América")
        node.assertIsDisplayed()
        node.assertHasClickAction()
    }
}