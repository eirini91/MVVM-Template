package com.pkfcooperparry.template.ui.form.page

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.pkfcooperparry.template.data.model.db.visit.Tab
import com.pkfcooperparry.template.ui.form.page.tab.TabFragment

class TabPagerAdapter(fm: FragmentManager, internal var formTabs: List<Tab>) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        return TabFragment.newInstance(formTabs[i].tabId)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return formTabs[position].tabName
    }

    override fun getCount(): Int {
        return formTabs.size
    }
}
