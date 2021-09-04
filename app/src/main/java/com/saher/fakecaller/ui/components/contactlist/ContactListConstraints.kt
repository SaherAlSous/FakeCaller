package com.saher.fakecaller.ui.components.contactlist

import androidx.constraintlayout.compose.ConstraintSet

fun contactListConstraints(): ConstraintSet {
    return ConstraintSet {
        val actionBar = createRefFor("actionbar")
        val lazyColumn = createRefFor("lazyColumn")
        val FAB =createRefFor("fab")
        val horizontalGuideLine = createGuidelineFromTop(0.8f)
        val verticalGuideLine = createGuidelineFromStart(0.8f)

        constrain(actionBar){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(lazyColumn){
            top.linkTo(actionBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(FAB){
            top.linkTo(horizontalGuideLine)
            start.linkTo(verticalGuideLine)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.absoluteRight)
        }

    }
}