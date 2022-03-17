package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentPhotographer
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)
        firstRun()
        binding.bottomNavigation.setOnItemReselectedListener { }
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerMain,
            binding.toolBarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerMain.addDrawerListener(toggle)
        toggle.syncState()
        binding.navDrawerViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "wanna be a writer"
                    dialog.show()
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "you're a writer now", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.menu_photographer -> {
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    supportFragmentManager.beginTransaction().apply {
                        add(R.id.frame_container, FragmentPhotographer())
                        addToBackStack(null)
                        commit()
                        binding.navDrawerViewMain.setCheckedItem(R.id.menu_photographer)

                    }
                }
                R.id.menu_wikipedia -> {
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    openWebSite("https://www.wikipedia.org/")

                }
                R.id.menu_videoMaker -> {
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    Snackbar.make(binding.root, "create a video", Snackbar.LENGTH_LONG)
                        .setAction("ok") {
                            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show()
                        }.setAnchorView(binding.bottomNavigation)

                        .show()

                }
                R.id.menu_openWikimedia -> {

                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    openWebSite("https://commons.wikimedia.org/wiki/Main_Page")

                }
                R.id.menu_translate -> {
                    binding.drawerMain.closeDrawer(GravityCompat.START)
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)


                }


            }
            true
        }
        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragment(FragmentExplore())
                }
                R.id.menu_trend -> {
                    replaceFragment(FragmentTrend())
                }
                R.id.menu_profile -> {
                    replaceFragment(FragmentProfile())
                }

            }
            binding.navDrawerViewMain.menu.getItem(1).isChecked = false

            true
        }
    }

    private fun openWebSite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, fragment)
            commit()
        }


    }

    private fun firstRun() {
        replaceFragment(FragmentExplore())
        binding.bottomNavigation.selectedItemId = R.id.frame_container
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.navDrawerViewMain.menu.getItem(1).isChecked = false
    }
}