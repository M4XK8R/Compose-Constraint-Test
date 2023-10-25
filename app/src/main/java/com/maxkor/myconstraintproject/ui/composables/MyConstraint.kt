package com.maxkor.myconstraintproject.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun MyConstraintLayout() {

    ConstraintLayout {

        val button1 = createRef()
        val button2 = createRef()
        val button3 = createRef()
        val button4 = createRef()
        val button5 = createRef()

        val guideVertical =
            createGuidelineFromStart(fraction = .4f)

        val guideHorizontal =
            createGuidelineFromTop(fraction = .1f)

        val verticalBarrel = createEndBarrier(button2)

        MyButton(text = "Button 1", Modifier.constrainAs(button1) {
//            centerVerticallyTo(parent)
            top.linkTo(guideHorizontal)
            end.linkTo(guideVertical)
        })

        MyButton(text = "Button 2", Modifier.constrainAs(button2) {
            start.linkTo(button1.start)
            top.linkTo(button1.bottom, 8.dp)
            width = Dimension.value(170.dp)
        })

        MyButton(text = "Button 3", Modifier.constrainAs(button3) {
            start.linkTo(button2.start)
            top.linkTo(button2.bottom, 8.dp)
        })

        MyButton(text = "Button 4", Modifier.constrainAs(button4) {
            start.linkTo(button3.start)
            top.linkTo(button3.bottom, 8.dp)
            width = Dimension.value(270.dp)
        })

        MyButton(text = "Button 5", Modifier.constrainAs(button5) {
            start.linkTo(verticalBarrel)
            top.linkTo(button4.bottom, 8.dp)
        })

    }

}