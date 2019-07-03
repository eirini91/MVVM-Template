package com.pkfcooperparry.template.ui.base

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableBoolean

import com.blankj.utilcode.util.NetworkUtils
import com.pkfcooperparry.template.data.DataManager
import com.pkfcooperparry.template.data.model.db.User
import com.pkfcooperparry.template.ui.login.LoginActivity
import com.pkfcooperparry.template.utils.rx.SchedulerProvider

import java.lang.ref.WeakReference

import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException

abstract class BaseViewModel<N>(val dataManager: DataManager,
                                val schedulerProvider: SchedulerProvider) : ViewModel() {

    val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable

    var viewInterface: WeakReference<N>? = null

    var context: Context? = null

    protected val isInternetConnectionValid: Boolean
        get() = NetworkUtils.isConnected()

    val user: User
        get() = dataManager.user!!

    init {
        this.compositeDisposable = CompositeDisposable()
    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getIsLoading():Boolean{
        return isLoading.get()
    }

    fun getViewInterface(): N {
        return viewInterface!!.get()!!
    }

    open fun setViewInterface(context: Context, navigator: N) {
        this.context = context
        this.viewInterface = WeakReference(navigator)
    }

    protected fun getHumanReadableError(throwable: Any): String {

        val toReturn = "Unknown Error. Please try again..."

        if (throwable is HttpException) {
            when (throwable.code()) {
                404 -> {

                }
            }
        }

        return toReturn
    }


}
