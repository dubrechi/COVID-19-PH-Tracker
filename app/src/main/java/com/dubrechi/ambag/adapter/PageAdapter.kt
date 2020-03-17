package com.dubrechi.ambag.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dubrechi.ambag.fragments.Cases
import com.dubrechi.ambag.fragments.CasesOutsidePH
import com.dubrechi.ambag.fragments.PatientsUnderInvestigation
import com.dubrechi.ambag.fragments.SuspectedCases

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Cases()
//            1 -> CasesOutsidePH()
//            2 -> SuspectedCases()
            else -> {
                return PatientsUnderInvestigation()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Cases"
//            1 -> "Cases Outside PH"
//            2 -> "Suspected Cases"
            else -> {
                return "Patients Under Investigation"
            }
        }
    }
}