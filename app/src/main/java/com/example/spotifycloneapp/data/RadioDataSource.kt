package com.example.spotifycloneapp.data

import com.example.spotifycloneapp.data.Remote.RadioServiceProvider
import com.example.spotifycloneapp.data.Remote.model.RadiosResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RadioDataSource {

    private val radioServiceProvider = RadioServiceProvider()

    fun fetchLocationRedios(): Observable<Resource<List<RadiosResponse>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())

            radioServiceProvider
                .getRadioService()
                .getLocationRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { locationRadioList ->
                        emitter.onNext(Resource.success(locationRadioList))
                        emitter.onComplete()
                    },
                    { error ->
                        emitter.onNext(Resource.error(error.message ?: ""))
                        emitter.onComplete()
                    }
                )

        }
    }

    fun fetchPopularRadios(): Observable<Resource<List<RadiosResponse>>> {
        return Observable.create { emitter ->
            emitter.onNext(Resource.loading())

            radioServiceProvider
                .getRadioService()
                .getPopularRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { popularRadioList ->
                        emitter.onNext(Resource.success(popularRadioList))
                        emitter.onComplete()
                    },
                    { error ->
                        emitter.onNext(Resource.error(error.message ?: ""))
                        emitter.onComplete()
                    }
                )
        }

    }
}