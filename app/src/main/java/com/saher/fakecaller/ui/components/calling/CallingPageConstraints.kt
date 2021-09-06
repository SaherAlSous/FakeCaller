package com.saher.fakecaller.ui.components.calling

import androidx.constraintlayout.compose.ConstraintSet

fun callingPageConstraints(): ConstraintSet{
    return ConstraintSet {
        val backgroundPhoto = createRefFor("background")
        val callingText = createRefFor("callingText")
        val timer = createRefFor("timer")
        val responseButtons = createRefFor("answeringButtons")
        val endCallButton = createRefFor("endCall")
        val bottomGuideline = createGuidelineFromBottom(0.15f)
        val topGuideline = createGuidelineFromTop(0.28f)

        constrain(backgroundPhoto){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(callingText){
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(timer){
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(responseButtons){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomGuideline)
        }
        constrain(endCallButton){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomGuideline)
        }

    }
}