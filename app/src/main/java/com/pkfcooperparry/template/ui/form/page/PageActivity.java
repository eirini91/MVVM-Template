package com.pkfcooperparry.template.ui.form.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.databinding.ActivityPageBinding;
import com.pkfcooperparry.template.ui.base.BaseActivity;
import com.pkfcooperparry.template.ui.form.page.tab.TabTitlesPagerAdapter;
import com.pkfcooperparry.template.utils.Navigator;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class PageActivity extends BaseActivity<ActivityPageBinding, PageViewModel> implements PageViewInterface, HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    Navigator navigator;

    @Inject
    PageViewModel pageViewModel;

    ActivityPageBinding activityPageBinding;

    public static Intent getCallingIntent(@NonNull Context context, int pageId) {
        Intent intent = new Intent(context, PageActivity.class);
        intent.putExtra("pageId", pageId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel.setViewInterface(this, this);
        activityPageBinding = getViewDataBinding();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        activityPageBinding.tabLayout.setLayoutManager(layoutManager);
        TabPagerAdapter adapterViewPager = new TabPagerAdapter(getSupportFragmentManager(), pageViewModel.getTabs(getIntent().getIntExtra("pageId", -1)));
        activityPageBinding.viewPager.setAdapter(adapterViewPager);

        TabTitlesPagerAdapter tabPagerAdapter = new TabTitlesPagerAdapter(this, (view, position) -> activityPageBinding.viewPager.setCurrentItem(position), pageViewModel.getTabs(getIntent().getIntExtra("pageId", -1)));

        activityPageBinding.tabLayout.setAdapter(tabPagerAdapter);
        activityPageBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                tabPagerAdapter.updateSelected(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_page;
    }

    @Override
    public PageViewModel getViewModel() {
        return pageViewModel;
    }

    @Override
    public void handleError(String message) {

    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    protected int getActionBarType() {
        return KEY_NO_ACTION_BAR;

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
