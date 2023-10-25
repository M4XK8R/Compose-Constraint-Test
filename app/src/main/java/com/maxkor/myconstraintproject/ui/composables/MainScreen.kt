package com.maxkor.myconstraintproject.ui.composables

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private const val TAG = "global"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(firebase: FirebaseDatabase) {

    val firebaseRef = firebase.getReference("info")

    val keyboardController =
        LocalSoftwareKeyboardController.current

    ConstraintLayout {

        var textFieldState by remember {
            mutableStateOf("default tfs")
        }

        var textState by remember {
            mutableStateOf("default ts")
        }

        val textFieldTop = createRef()
        TextField(
            value = textFieldState,
            onValueChange = {
                textFieldState = it
            },
            modifier = Modifier
                .constrainAs(textFieldTop) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top, 32.dp)
                },
            shape = RoundedCornerShape(32.dp),
            textStyle = TextStyle(Color.DarkGray, 26.sp)
        )

        val buttonTop = createRef()
        Button(
            onClick = {
                firebaseRef.setValue(textFieldState)
                keyboardController?.hide()
            },
            modifier = Modifier.constrainAs(buttonTop) {
                centerHorizontallyTo(parent)
                top.linkTo(textFieldTop.bottom, 12.dp)
            }
        ) {
            Text(text = "Send to server", fontSize = 22.sp)
        }

        val divider = createRef()
        Divider(
            Modifier.constrainAs(divider) {
                centerHorizontallyTo(parent)
                centerVerticallyTo(parent)
            }
        )

        val buttonBottom = createRef()
        Button(
            onClick = {
                firebaseRef.addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        val value = snapshot.value
                        Log.d(TAG, "Value is: " + value)
                        textState = value.toString()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.w(TAG, "Failed to read value.", error.toException())
                    }

                })
            },
            modifier = Modifier.constrainAs(buttonBottom) {
                centerHorizontallyTo(parent)
                bottom.linkTo(parent.bottom, 32.dp)
            }
        ) {
            Text(text = "Receive from server", fontSize = 22.sp)
        }

        Text(
            text = textState,
            fontSize = 26.sp,
            modifier = Modifier.constrainAs(createRef()) {
                centerHorizontallyTo(parent)
                bottom.linkTo(buttonBottom.top, 12.dp)
            }
        )

    }

}












