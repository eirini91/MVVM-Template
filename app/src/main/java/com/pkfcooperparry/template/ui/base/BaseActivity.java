package com.pkfcooperparry.template.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.blankj.utilcode.util.NetworkUtils;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.utils.CommonUtils;

import dagger.android.AndroidInjection;


public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity
        implements BaseFragment.Callback {
    public static final int KEY_NO_ACTION_BAR = 0;
    public static final int KEY_BACK_HOME_ACTION_BAR = 1;
    public static final int KEY_MAIN_ACTION_BAR = 2;
    private static final String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;
    private T mViewDataBinding;
    private V mViewModel;

    public abstract int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract V getViewModel();

    protected abstract String getActionBarTitle();

    protected abstract int getActionBarType();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);

        performDataBinding();

        setupActionBar();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isConnected();
    }


    public void performDependencyInjection() {
        AndroidInjection.inject(this);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    protected void setupActionBar() {
        TextView title = findViewById(R.id.title);

        switch (getActionBarType()) {
            case KEY_NO_ACTION_BAR: {
                break;
            }
            case KEY_BACK_HOME_ACTION_BAR: {
//                setSupportActionBar(findViewById(R.id.toolBar));
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//                if (title != null) {
//                    title.setText(getActionBarTitle());
//                }
//                final Drawable upArrow = getResources().getDrawable(R.drawable.backlo);
//                getSupportActionBar().setHomeAsUpIndicator(upArrow);
//                break;
            }
            case KEY_MAIN_ACTION_BAR: {
//                setSupportActionBar(findViewById(R.id.toolBar));

                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }
}

