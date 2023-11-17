package com.gl4.tp_3_fragement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.gl4.tp_3_fragement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var actionMode: ActionMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setBtn.setOnClickListener {
            setTime(it)
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, FragmentClock(), null)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.switchh)
        {
            binding.switchWidget.isChecked = !binding.switchWidget.isChecked
            setTime(null)
        }
        return super.onOptionsItemSelected(item)
    }


    fun setTime(view : View?) {
        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()
        var fragmentClock = FragmentClock()
        var bundle = Bundle()
        bundle.putBoolean("digitalOK",binding.switchWidget.isChecked)
        fragmentClock.arguments = bundle
        transaction.replace(R.id.fragment,fragmentClock)
        transaction.commit()
    }



}