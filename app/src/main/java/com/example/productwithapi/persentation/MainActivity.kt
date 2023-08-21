package com.example.productwithapi.persentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.productwithapi.domain.model.CustomList
import com.example.productwithapi.persentation.ui.ListsViewModel
import com.example.productwithapi.persentation.ui.theme.ProductWithApiTheme
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    private val composeViewModel by viewModels<ListsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductWithApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = true) {
                        composeViewModel.sharedFlow.collectLatest {
                            Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG)
                        }
                    }
                    Greeting(composeViewModel = composeViewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(composeViewModel: ListsViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        OutlinedTextField(value = composeViewModel.textFieldText.value,
            onValueChange = { composeViewModel.textFieldText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            singleLine = true,
            label = { Text(text = "Search") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(modifier = Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            Button(modifier = Modifier
                .padding(1.dp)
                .weight(1f),
                onClick = { composeViewModel.addProduct() }) {
                Text(text = "Ad")
            }
            Button(modifier = Modifier
                .padding(1.dp),
                onClick = { composeViewModel.updateProduct() }) {
                Text(text = "Upda")
            }
            Button(modifier = Modifier
                .padding(1.dp),
                onClick = { composeViewModel.deleteProduct() }) {
                Text(text = "Dele")
            }
            Button(modifier = Modifier
                .padding(1.dp),
                onClick = { composeViewModel.searchProduct() }) {
                Text(text = "Sear")
            }
            Button(modifier = Modifier
                .padding(1.dp),
                onClick = { composeViewModel.loginToken() }) {
                Text(text = "Auth")
            }

        }
        CustomList(list = composeViewModel.productList.value)

        //    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        /*
            items(composeViewModel.quoteList.value) {

                ListItem(
                    headlineText = {
                        Text(text = it.author)
                    },
                    supportingText = {
                        Text(text = it.quote)

                    })
                Spacer(modifier = Modifier.height(20.dp))
            }

*/
        /*

            items(composeViewModel.productList.value) {

                ListItem(
                    headlineText = {
                        Text(text = "${it.brand}")
                    },

                    supportingText = {
                        Text(text = it.description)

                    }

                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            /*
            items(composeViewModel.userList.value) {
                ListItem(
                    headlineText = {
                        Text(text = " ${it.firstName} ${it.lastName} ")
                    },
                    supportingText = {
                        Text(text = it.email)
                        Text(text = it.phone)

                    },
                    leadingContent = {
                        Image(
                            painter = rememberAsyncImagePainter(model = it.image),
                            contentDescription = "Forest Image",
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )

                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

             */
*/
    }

}

