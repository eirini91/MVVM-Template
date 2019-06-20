package com.pkfcooperparry.template.ui.form;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.data.model.db.visit.Page;
import com.pkfcooperparry.template.databinding.ActivityFormBinding;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.ui.custom.CustomDialog;
import com.pkfcooperparry.template.ui.form.page.PageAdapter;
import com.pkfcooperparry.template.utils.Navigator;

import javax.inject.Inject;

public class FormActivity extends BaseActivity<ActivityFormBinding, FormViewModel> implements FormViewInterface {

    @Inject
    CustomDialog customDialog;

    @Inject
    Navigator navigator;

    @Inject
    FormViewModel formViewModel;

    ActivityFormBinding activityFormBinding;

    public static Intent getCallingIntent(@NonNull Context context, int formId) {
        Intent intent = new Intent(context, FormActivity.class);
        intent.putExtra("formId", formId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        formViewModel.setViewInterface(this, this);
        activityFormBinding = getViewDataBinding();

        activityFormBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        PageAdapter pageAdapter = new PageAdapter(this, new PageAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Page view) {
                navigator.navigateToPageView(FormActivity.this, (int) view.getPageId());
            }

        }, formViewModel.getFormWithId(getIntent().getIntExtra("formId", -1)).getPages());
        activityFormBinding.recyclerView.setAdapter(pageAdapter);
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_form;
    }

    @Override
    public FormViewModel getViewModel() {
        return formViewModel;
    }

    @Override
    public void handleError(String message) {
        customDialog.showDialog(this, CustomDialog.ONE_BUTTON_DIALOG_STYLE, getString(R.string.something_went_wrong), message);

    }

    @Override
    public void goBack() {
        finish();
    }

    @Override
    public void openRequests() {

    }

    @Override
    public void openActionPlan() {

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
