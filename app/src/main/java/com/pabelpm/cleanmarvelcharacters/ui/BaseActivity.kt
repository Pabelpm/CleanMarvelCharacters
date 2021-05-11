package com.pabelpm.cleanmarvelcharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Override this method to prepare all views with the first state (loading info, skeleton, ...)
     * This method is called from onCreate, after base things
     */
    open fun initializeView() {
        // Optional implementation
    }

    /**
     * Listen view action events, onClickListener, onInputListener, ...
     * This method is called from onCreate, after base things and initializeView()
     */
    open fun bindViewActions() {
        // Optional implementation
    }

    /**
     * Observe view model live data, to update the interface
     * This method is called from onCreate, after base things, initializeView() and bindViewActions()
     */
    open fun observeViewModel() {
        // Optional implementation
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeView()

        bindViewActions()

        observeViewModel()
    }
}