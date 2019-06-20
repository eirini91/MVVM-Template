package com.pkfcooperparry.template.ui.form.page;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pkfcooperparry.template.data.model.db.visit.Tab;
import com.pkfcooperparry.template.ui.form.page.tab.TabFragment;

import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {
    List<Tab> formTabs;

    public TabPagerAdapter(FragmentManager fm, List<Tab> formTabs) {
        super(fm);
        this.formTabs = formTabs;
    }

    @Override
    public Fragment getItem(int i) {
        return TabFragment.newInstance(formTabs.get(i).getTabId());
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return formTabs.get(position).getTabName();
    }

    @Override
    public int getCount() {
        return formTabs.size();
    }
}
