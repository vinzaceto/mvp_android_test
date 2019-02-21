package com.vinzaceto.mvptest.weather

class WeatherPresenter (var iView: WeatherMVP.View) : WeatherMVP.ViewPresenter, WeatherMVP.ModelPresenter {
    var interactor: WeatherInteractor = WeatherInteractor()

    fun getWeatherData()
    {
        iView.showLoader()
        requestDataFromServer()
    }

    override fun requestDataFromServer() {
        interactor.getWeatherData(this);
    }

    override fun onDestroy() {

    }

    override fun onFinished(data: String) {
        iView.hideLoader()
        iView.setWeatherData(data)
    }

    override fun onError(t: Throwable) {
        iView.hideLoader()
    }
}