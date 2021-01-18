package com.example.spotifycloneapp.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.RadioServiceProvider
import com.example.spotifycloneapp.data.model.RadiosResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadiosFragment : Fragment() {

    private val radioServiceProvider = RadioServiceProvider()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radioServiceProvider.getRadioService().getPopularRadios()
            .enqueue(object : Callback<List<RadiosResponse>> {
                override fun onResponse(
                    call: Call<List<RadiosResponse>>,
                    response: Response<List<RadiosResponse>>
                ) {
                    Log.v("TEST", "Success: ${response.body().toString()}")
                }

                override fun onFailure(call: Call<List<RadiosResponse>>, t: Throwable) {
                    Log.v("TEST", "Failed: $t")
                }
            })

        radioServiceProvider.getRadioService().getLocationRadios()
            .enqueue(object : Callback<List<RadiosResponse>> {
                override fun onResponse(
                    call: Call<List<RadiosResponse>>,
                    response: Response<List<RadiosResponse>>
                ) {
                    Log.v("TEST", "Success: ${response.body().toString()}")
                }

                override fun onFailure(call: Call<List<RadiosResponse>>, t: Throwable) {
                    Log.v("TEST", "Failed: $t")
                }
            })
    }

    companion object {
        fun newInstance(): Fragment {
            return RadiosFragment()
        }
    }
}