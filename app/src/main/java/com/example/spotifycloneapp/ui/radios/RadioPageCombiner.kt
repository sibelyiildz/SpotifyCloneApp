package com.example.spotifycloneapp.ui.radios

import com.example.spotifycloneapp.data.Remote.model.RadiosResponse
import com.example.spotifycloneapp.data.Resource
import io.reactivex.functions.BiFunction

class RadioPageCombiner :
    BiFunction<Resource<List<RadiosResponse>>, Resource<List<RadiosResponse>>, RadiosFragmentViewState> {
    override fun apply(
        popularRadios: Resource<List<RadiosResponse>>,
        locationRadios: Resource<List<RadiosResponse>>
    ): RadiosFragmentViewState {
        return RadiosFragmentViewState(popularRadios, locationRadios)
    }

}