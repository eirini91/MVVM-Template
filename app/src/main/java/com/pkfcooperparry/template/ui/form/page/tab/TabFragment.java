package com.pkfcooperparry.template.ui.form.page.tab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;

import com.pkfcooperparry.template.BR;
import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.databinding.FragmentTabBinding;
import com.pkfcooperparry.template.ui.base.BaseFragment;
import com.pkfcooperparry.template.utils.Navigator;

import javax.annotation.Nullable;
import javax.inject.Inject;

public class TabFragment extends BaseFragment<FragmentTabBinding, TabFragmentViewModel> implements TabFragmentViewInterface {
    @Inject
    Navigator navigator;
    @Inject
    TabFragmentViewModel tabFragmentViewModel;


    FragmentTabBinding fragmentSpecificStatsBinding;
    LinearLayout linearLayout;

    public static TabFragment newInstance(long tabId) {
        Bundle args = new Bundle();
        TabFragment fragment = new TabFragment();
        args.putLong("tabId", tabId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_tab;
    }

    @Override
    public TabFragmentViewModel getViewModel() {
        return tabFragmentViewModel;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabFragmentViewModel.setViewInterface(getActivity(), this);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSpecificStatsBinding = getViewDataBinding();
        linearLayout = view.findViewById(R.id.parent);
        setupUi();

    }

    @Override
    public void setupUi() {

    }


}
