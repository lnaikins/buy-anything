package com.lizaworks.buyanything.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lizaworks.buyanything.R
import com.lizaworks.buyanything.models.Categories
import com.lizaworks.buyanything.models.Price
import com.lizaworks.buyanything.models.Promos



@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(vertical = 42.dp, horizontal = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Greeting(
            name = "Derrick"
        )
        SearchBar()
        CategoriesRow()
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            Promos.data.forEach { promo ->
                PromoCard(
                    title = promo.title,
                    description = promo.description,
                    timeline = promo.timeline,
                    backgroundColor = promo.backgroundColor,
                    image = promo.image
                )
            }
        }
        Column {
            Text("Get ready for christmas")
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                Price.data.forEach { price ->
                    PriceCard(
                        title = price.title,
                        currency = price.currency,
                        price = price.price,
                        image = price.image
                    )
                }
            }
        }
    }
}


@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hi $name",
                modifier = modifier, fontSize = 24.sp, fontWeight = FontWeight.W400
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            )
            {
                Box(
                    contentAlignment = Alignment.Center,

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.verified),
                        contentDescription = "verified",
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text("Verified buyer", color = Color(0xFF41529F), fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .border(width = 4.dp, color = Color(0xFFDBDFF0), shape = CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse),
                contentDescription = "profile pic"
            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar() {

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color(0xFFF0F0F0),
            containerColor = Color(0xFFF0F0F0)
        ),
        shape = RoundedCornerShape(8.dp),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Search for anything. We have it.") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search"
            )
        },
        trailingIcon = {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(end = 8.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                )
                Icon(
                    painter = painterResource(id = R.drawable.upc_scan),
                    contentDescription = "scan"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
    )


}


@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CategoriesRow() {
    FlowRow(
        maxItemsInEachRow = 4,
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
//        modifier = Modifier.horizontalScroll(
//            rememberScrollState()
//        )
    ) {


        Categories.data.forEach { model ->


            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            color = Color(0xFFDBF0E6), shape = CircleShape
                        )
                        .padding(8.dp)
//                        .heightIn(min = 40.dp)

                ) {
                    Image(
                        painter = painterResource(id = model.image),
                        contentDescription = "fruits"
                    )
                }
                Text(text = model.title, fontSize = 10.sp)

            }
        }
    }
}

@Composable
private fun PromoCard(
    title: String,
    description: String,
    timeline: String,
    backgroundColor: Color,
    image: Int
) {
    Box() {
        Box(
            modifier = Modifier.background(
                color = backgroundColor, shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 8.dp
                )
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_background),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(
                        color = Color.Transparent,

                        )
                    .fillMaxWidth()
                    .padding(24.dp),
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(text = description, fontSize = 12.sp, color = Color.White)
                Text(text = timeline, fontSize = 12.sp, color = Color.White)
            }
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = "gift",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(y = (-22).dp)
        )
    }
}


@Composable
private fun PriceCard(
    title: String,
    currency: String,
    price: String,
    image: Int

) {
    Row {
        Column(
            modifier = Modifier
                .width(178.dp)
                .border(
                    color = Color(0xFFDBF0E6),
                    width = 2.dp,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "tree",
                modifier = Modifier.clip(shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
            )
            Row(modifier = Modifier.padding(16.dp)) {
                Text(text = title, fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = currency,
                        fontSize = 10.sp,
                    )
                    Text(
                        text = price,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                    )
                }
            }
        }
    }
}

