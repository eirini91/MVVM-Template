package com.pkfcooperparry.template.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.databinding.ActivityMainBinding;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.ui.form.FormAdapter;
import com.pkfcooperparry.template.utils.Navigator;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainViewInterface {

    @Inject
    Navigator navigator;

    @Inject
    MainViewModel mainViewModel;

    ActivityMainBinding activityMainBinding;

    public static Intent getCallingIntent(@NonNull Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel.setViewInterface(this, this);
        activityMainBinding = getViewDataBinding();
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FormAdapter pageAdapter = new FormAdapter(this, view -> navigator.navigateToFormView(MainActivity.this, (int) view.getId()), mainViewModel.getForms());
        activityMainBinding.recyclerView.setAdapter(pageAdapter);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    @Override
    public void handleError(String message) {

    }

    @Override
    public void openVisitPage(int visitId) {
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    protected int getActionBarType() {
        return KEY_NO_ACTION_BAR;

    }


}
