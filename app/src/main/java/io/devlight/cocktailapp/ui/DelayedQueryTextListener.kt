package io.devlight.cocktailapp.ui

import android.widget.SearchView
import java.util.*

abstract class DelayedQueryTextListener : SearchView.OnQueryTextListener {
    var mTimer: Timer? = null

    override fun onQueryTextChange(text: String): Boolean {
        if (mTimer != null) {
            mTimer!!.cancel()
        }
        val task: TimerTask = object : TimerTask() {
            override fun run() {
                onSearch(text)
            }
        }
        mTimer = Timer()
        mTimer!!.schedule(task, 1000)
        return true
    }

    abstract fun onSearch(text: String)

    override fun onQueryTextSubmit(query: String): Boolean {
        return true
    }
}