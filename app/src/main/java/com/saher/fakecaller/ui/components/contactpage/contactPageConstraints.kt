package com.saher.fakecaller.ui.components.contactpage

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun contactPageConstraints():ConstraintSet {
    return ConstraintSet {
        val contactPageBar = createRefFor("contactBar")
        val contactPhoto = createRefFor("userPhoto")
        val changeUserPhoto = createRefFor("changePhoto")
        val contactDetailsColumn = createRefFor("contactDetails")
        val callingContact = createRefFor("calling")
        val horizontalGuideLine = createGuidelineFromBottom(0.5f)

        constrain(contactPageBar){
            top.linkTo(parent.top)
            start.linkTo((parent.start))
            end.linkTo(parent.end)
        }
        constrain(contactPhoto){
            top.linkTo(contactPageBar.bottom)
            start.linkTo((parent.start))
            end.linkTo(parent.end)
        }
        constrain(changeUserPhoto){
            bottom.linkTo(horizontalGuideLine)
            end.linkTo(parent.end)
        }
        constrain(contactDetailsColumn){
            top.linkTo(contactPhoto.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(callingContact.top)
        }
        constrain(callingContact){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
    }
}