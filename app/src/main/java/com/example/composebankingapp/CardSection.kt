package com.example.composebankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebankingapp.data.Card
import com.example.composebankingapp.ui.theme.BlueEnd
import com.example.composebankingapp.ui.theme.BlueStart
import com.example.composebankingapp.ui.theme.GreenEnd
import com.example.composebankingapp.ui.theme.GreenStart
import com.example.composebankingapp.ui.theme.OrangeEnd
import com.example.composebankingapp.ui.theme.OrangeStart
import com.example.composebankingapp.ui.theme.PurpleEnd
import com.example.composebankingapp.ui.theme.PurpleStart

val cards = listOf<Card>(
    Card(
        cardType = "VISA",
        cardNumber = "2121 2133 1233 3123",
        cardName = "Business",
        balance = 3123.12,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "2313 2133 3214 5685",
        cardName = "Savings",
        balance = 0.0,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "2121 2133 1233 3123",
        cardName = "School",
        balance = 123.12,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTER",
        cardNumber = "2121 2133 1233 3123",
        cardName = "Business",
        balance = 3123.12,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection() {
    LazyRow() {
        items(cards.size) { index ->

            CardItem(index)
        }

    }
}

@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType.uppercase() == "MASTER") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(card.color)
                .width(240.dp)
                .height(160.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        )

        {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color(0x1B000000),
                                Color.Transparent
                            ),
                            startX = 100f

                        )
                    )
            ) {
                Column(Modifier.padding(12.dp)) {
                    Image(
                        painter = image,
                        contentDescription = card.cardName,
                        Modifier
                            .width(50.dp)
                            .height(50.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = card.cardName,
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "€ ${card.balance}",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = card.cardNumber,
                        color = Color.White,
                        fontSize = 12.sp,
                    )

                }
            }

        }

    }
}