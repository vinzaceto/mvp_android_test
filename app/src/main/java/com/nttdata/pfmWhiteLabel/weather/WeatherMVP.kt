package com.nttdata.pfmWhiteLabel.weather

public interface WeatherMVP {

    interface View
    {
        fun showLoader()
        fun hideLoader()
        fun setWeatherData(data: String)
    }

    interface ViewPresenter
    {
        fun requestDataFromServer()
        fun onDestroy()
    }

    interface ModelPresenter: Model.OnGetWeatherDataFinishedListener

    interface Model
    {
        interface OnGetWeatherDataFinishedListener
        {
            fun onFinished(data : String)
            fun onError(t : Throwable)
        }

        fun getWeatherData(listener: OnGetWeatherDataFinishedListener)
    }
}