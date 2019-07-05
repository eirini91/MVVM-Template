package com.televantou.template.ui.base

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.databinding.ObservableBoolean
import com.blankj.utilcode.util.NetworkUtils
import com.televantou.template.data.DataManager
import com.televantou.template.data.model.db.User
import com.televantou.template.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(val dataManager: DataManager,
                                val schedulerProvider: SchedulerProvider) : ViewModel() {

    private val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var viewInterface: WeakReference<N>? = null

    var context: Context? = null

    protected val isInternetConnectionValid: Boolean
        get() = NetworkUtils.isConnected()

    val user: User
        get() = dataManager.user!!


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun getIsLoading(): Boolean {
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
