package se.magictechnology.pia13android19mars

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import se.magictechnology.pia13android19mars.ui.theme.Pia13android19marsTheme

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            Pia13android19marsTheme {
                ProfileScreen()
            }
        }

        composeTestRule.onNodeWithTag("addbutton").performClick()
        //composeTestRule.onNodeWithText("ADD SHOP").performClick()

        composeTestRule.onNodeWithTag("errortext").assertIsDisplayed()

        composeTestRule.onNodeWithTag("titletextfield").performTextInput("ABC")
        composeTestRule.onNodeWithTag("addbutton").performClick()

        composeTestRule.onNodeWithTag("errortext").assertIsDisplayed()

        composeTestRule.onNodeWithTag("amounttextfield").performTextInput("2")

        composeTestRule.onNodeWithTag("addbutton").performClick()

        composeTestRule.onNodeWithTag("errortext").assertIsNotDisplayed()

        composeTestRule.onNodeWithTag("addbutton").captureToImage()
    }
}