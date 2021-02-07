package com.example.spotifycloneapp.ui.radios

import com.example.spotifycloneapp.data.Remote.model.RadiosResponse
import com.example.spotifycloneapp.data.Resource

data class RadiosFragmentViewState(
    val popularRadios: Resource<List<RadiosResponse>>,
    val locationRadios: Resource<List<RadiosResponse>>,
)