package com.liliane.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bnvHome: BottomNavigationView
    lateinit var fcvHome: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        castViews()
        setupBottomNav()

    }
    fun castViews(){
        bnvHome=findViewById(R.id.bottom_nav)
        fcvHome=findViewById(R.id.fcvHome)
    }
    fun setupBottomNav(){
        bnvHome.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome,PlanFragment()).commit()
                    true
                }
                R.id.track ->{
                    var transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,TrackFragment())
                    transaction.commit()
                    true
                }
                R.id.profile->{
                    var transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome,ProfileFragment())
                    transaction.commit()
                    true

                }
                else->false
            }
        }
    }
}