package com.bold.weather_presentation.search

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.bold.core_ui.LocalSpacing

@Composable
fun SearchScreen(
    scaffoldState: ScaffoldState,
    onNavigateUp: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
}

