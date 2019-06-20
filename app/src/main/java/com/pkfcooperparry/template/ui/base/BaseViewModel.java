package com.pkfcooperparry.template.ui.base;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.databinding.ObservableBoolean;

import com.blankj.utilcode.util.NetworkUtils;
import com.pkfcooperparry.template.data.DataManager;
import com.pkfcooperparry.template.data.model.db.User;
import com.pkfcooperparry.template.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public abstract class BaseViewModel<N> extends ViewModel {

    private final DataManager dataManager;

    private final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final SchedulerProvider schedulerProvider;

    private CompositeDisposable compositeDisposable;

    private WeakReference<N> viewInterface;

    private Context context;

    public BaseViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public N getViewInterface() {
        return viewInterface.get();
    }

    public void setViewInterface(Context context, N navigator) {
        this.context = context;
        this.viewInterface = new WeakReference<>(navigator);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    protected String getHumanReadableError(Object throwable) {

        String toReturn = "Unknown Error. Please try again...";

        if (throwable instanceof HttpException) {
            switch (((HttpException) throwable).code()) {
                case 404: {

                }
            }
        }

        return toReturn;
    }

    protected boolean isInternetConnectionValid() {
        return NetworkUtils.isConnected();
    }

    public User getUser() {
        return getDataManager().getUser();
    }


}
