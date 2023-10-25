package com.maxkor.myconstraintproject.ui.composables

import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

fun myConstraintSet(
    constrainedLayoutReferenceId: String,
    margin: Dp
): ConstraintSet {

    return ConstraintSet {
        val constrainedLayoutReference =
            createRefFor(constrainedLayoutReferenceId)

        constrain(constrainedLayoutReference) {
            linkTo(
                parent.top, parent.bottom,
                topMargin = margin, bottomMargin = margin
            )
            linkTo(
                parent.start, parent.end,
                startMargin = margin, endMargin = margin
            )
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}