package com.dubrechi.ambag.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dubrechi.ambag.fragments.*

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Cases()
            1 -> PatientsUnderInvestigation()
//            1 -> CasesOutsidePH()
//            2 -> SuspectedCases()
            else -> {
                return Checkpoints()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Cases"
            1 -> "Patients Under Investigation"
//            1 -> "Cases Outside PH"
//            2 -> "Suspected Cases"
            else -> {
                return "Checkpoints"
            }
        }
    }
}