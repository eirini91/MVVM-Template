package com.pkfcooperparry.template.ui.form.page.tab

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

import com.pkfcooperparry.template.BR
import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.databinding.FragmentTabBinding
import com.pkfcooperparry.template.ui.base.BaseFragment
import com.pkfcooperparry.template.utils.Navigator
import javax.inject.Inject

class TabFragment : BaseFragment<FragmentTabBinding, TabFragmentViewModel>(), TabFragmentViewInterface {
    var navigator: Navigator? = null
        @Inject set

    var tabFragmentViewModel: TabFragmentViewModel? = null
        @Inject set

    internal var fragmentSpecificStatsBinding: FragmentTabBinding? = null
    internal lateinit var linearLayout: LinearLayout

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_tab

    override fun getViewModel(): TabFragmentViewModel {
        return this!!.tabFragmentViewModel!!
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { tabFragmentViewModel!!.setViewInterface(it, this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSpecificStatsBinding = viewDataBinding
        linearLayout = view.findViewById(R.id.parent)
        setupUi()

    }

    override fun setupUi() {

    }

    companion object {

        fun newInstance(tabId: Long): TabFragment {
            val args = Bundle()
            val fragment = TabFragment()
            args.putLong("tabId", tabId)
            fragment.arguments = args
            return fragment
        }
    }


}
