// package com.example.frontvynils

// import androidx.compose.ui.test.assertHasClickAction
// import androidx.compose.ui.test.assertIsDisplayed
// import androidx.compose.ui.test.junit4.createAndroidComposeRule
// import androidx.compose.ui.test.onNodeWithContentDescription
// import androidx.compose.ui.test.onNodeWithText
// import androidx.compose.ui.test.performClick
// import com.example.frontvynils.repository.AlbumRepositoryMock
// import com.example.frontvynils.ui.navigation.MainScreen
// import org.junit.Before
// import org.junit.FixMethodOrder
// import org.junit.Rule
// import org.junit.Test
// import org.junit.runners.MethodSorters

// @FixMethodOrder(MethodSorters.NAME_ASCENDING)
// class AlbumsViewTest {

//     @get:Rule
//     val composeTestRule = createAndroidComposeRule<TestActivity>()

//     @Before
//     fun init() {
//         composeTestRule.setContent { 
//             MainScreen(albumRepository = AlbumRepositoryMock())
//         }
//     }
    
//     @Test
//     fun test_1_checkViewMounted() {
//         composeTestRule.onNodeWithText("Albums").assertIsDisplayed()
//         composeTestRule.onNodeWithContentDescription("Albums").assertHasClickAction()
//         composeTestRule.onNodeWithContentDescription("Albums").performClick()
//     }

//     @Test
//     fun test_2_checkViewContent() {
//         var node = composeTestRule.onNodeWithText("Buscando América")
//         node.assertIsDisplayed()
//         node.assertHasClickAction()
//     }
// }