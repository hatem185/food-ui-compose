package com.example.foodscreen

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodscreen.ui.theme.FoodScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodScreen()
                }
            }
        }
    }
}

@Composable
fun FoodScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp, 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ) {
        SearchBar()
        MainContent()
        NavBottomBar()
    }
}

val circularCornerRadius = RoundedCornerShape(20.dp, 0.dp, 20.dp, 0.dp)
const val mainColor = 0xFF406A52

@Composable
fun SearchBar() {
    Card(
        shape = circularCornerRadius,
        modifier = Modifier.width(332.dp),
        backgroundColor = Color(0xFFECECEC)
    ) {

        var text by remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            },
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFFECECEC),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(mainColor),
                textColor = Color.Black,

            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp, 0.dp),
            placeholder = {
                Text(
                    "Chicken nuggets with potatoes",
                    fontSize = 14.sp,
                    color = Color(0xFF000000)
                )
            },

        )
    }
}

@Composable
fun MainContent() {
    Card(shape = circularCornerRadius) {
        Column(
            Modifier
                .background(Color(0xFFECECEC))
                .width(330.dp)
                .padding(bottom = 15.dp)

        ) {
            Text(
                text = "Here are the relevant results for your search for \"Chicken Nuggets with Potatoes\":",
                fontSize = 16.sp,
                color = Color(mainColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardFood(R.drawable.chicken_nug)
                    CardFood(R.drawable.french_fries)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardFood(R.drawable.burger)
                    CardFood(R.drawable.rustic_pot)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CardFood(R.drawable.fish_nug)
                    CardFood(R.drawable.ball_nug)
                }
            }
        }
    }
}

@Composable
fun NavBottomBar() {
    Card(shape = circularCornerRadius) {
        Row(
            modifier = Modifier
                .background(Color(0xFFECECEC))
                .width(332.dp)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.home), contentDescription = "")
            Image(painter = painterResource(id = R.drawable.fav_vec), contentDescription = "")
            Image(painter = painterResource(id = R.drawable.message_vec), contentDescription = "")
            Image(painter = painterResource(id = R.drawable.profile_vec), contentDescription = "")
        }
    }
}

@Composable
fun CardFood(@DrawableRes image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier.height(160.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodScreenTheme {
    }
}