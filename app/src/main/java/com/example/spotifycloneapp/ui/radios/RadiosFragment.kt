package com.example.spotifycloneapp.ui.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.data.RadioDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RadiosFragment : Fragment() {


    val radioDataSource = RadioDataSource()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        radioDataSource.fetchLocationRedios()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.v("TEST", "fetchLocationRedios ${it.status}")
            }

        radioDataSource.fetchPopularRadios()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.v("TEST", "fetchPopularRadios ${it.status}")
            }

//        radioServiceProvider
//                .getRadioService()
//                .getPopularRadios()
////                .filter { it.size == 0 }
////                //gelen listeyi boş bir liste ile değiştir
////                .map { it ->  arrayListOf<MediaStore.Audio.Radio>() }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { Log.v("TEST", "$it") },
//                        { Log.v("TEST", "$it") })
//
//        radioServiceProvider
//                .getRadioService()
//                .getLocationRadios()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { Log.v("TEST", "$it") },
//                        { Log.v("TEST", "$it") })

    }

    companion object {
        fun newInstance(): Fragment {
            return RadiosFragment()
        }
    }
}

//subscribeOn -> isteğin atılcağı thred belirtilir
//observeOn -> hangi theradte observe edileceği belirtiler.
//filter -> filtre ekleyebiliyoruz. Örneğin liste 0 a eşitse devam et değilse altındaki kodlara devam etmez.
//map -> gelen içeriği istediğiniz herhangi bir şey ile değiştirebilirsiniz.
