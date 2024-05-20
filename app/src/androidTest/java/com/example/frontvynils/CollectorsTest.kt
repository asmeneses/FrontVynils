package com.example.frontvynils

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.frontvynils.repository.*
import com.example.frontvynils.ui.navigation.MainScreen
import org.junit.*
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class CollectorsTest {

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
    fun test_1_navigateToView() {
        var node = composeTestRule.onNodeWithTag("Collectors")
        node.assertIsDisplayed()
        node.assertHasClickAction()
        node.performClick()
    }

    @Test
    fun test_2_checkIfCollector1IsDisplayed() {
        test_1_navigateToView()
        Thread.sleep(1000)

        var node = composeTestRule.onNodeWithText("Laura Puerta", ignoreCase = true)

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
    }

    @Test
    fun checkIfCollector2IsDisplayed() {
        test_1_navigateToView()
        Thread.sleep(1000)

        var node = composeTestRule.onNodeWithText("Mario Rios", ignoreCase = true)

        composeTestRule.waitUntil {
            node.isDisplayed()
        }

        node.assertIsDisplayed()
    }
}