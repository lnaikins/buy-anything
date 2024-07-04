package com.lizaworks.buyanything.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lizaworks.buyanything.R


//@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun OnboardingScreen(
    onStartClicked: () -> Unit
) {


    val annotatedLinkString = buildAnnotatedString {
        val str = "Agree to our terms and conditions"
        val startIndex = str.indexOf("terms")
        val endIndex = startIndex + 20
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xFF41529F),
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )
    }
    Scaffold {
        Column(modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
            Text(
                "Buy anything. \n We deliver fast.",
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(painter = painterResource(id = R.drawable.checkbox), contentDescription = "")
                Text(
                    text = annotatedLinkString,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                contentPadding = PaddingValues(vertical = 24.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = onStartClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF41529F)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Start")
            }
        }
    }
}