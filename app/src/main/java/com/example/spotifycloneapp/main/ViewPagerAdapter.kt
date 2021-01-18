package com.example.spotifycloneapp.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.spotifycloneapp.R
import com.example.spotifycloneapp.favorites.FavoritesFragment
import com.example.spotifycloneapp.radios.RadiosFragment

class ViewPagerAdapter(context: Context, fragmentManager: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fragmentManager, behavior) {

    //string dosyasından tabLayout isimlerini çektik
    private val tabs = context.applicationContext.resources.getStringArray(R.array.tabs)

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            TAB_INDEX_RADIOS -> RadiosFragment.newInstance()
            TAB_INDEX_FAVORITES -> FavoritesFragment.newInstance()
            else -> throw IllegalStateException("Can not find fragment: $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        //toUpperCase() -> hepsini büyük harfle yazsın
        return tabs[position].toUpperCase()
    }

    companion object {
        private const val TAB_INDEX_RADIOS = 0
        private const val TAB_INDEX_FAVORITES = 1
    }
}