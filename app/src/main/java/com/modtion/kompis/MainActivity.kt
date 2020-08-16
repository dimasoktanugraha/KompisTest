package com.modtion.kompis

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_main_info.*
import kotlinx.android.synthetic.main.item_main_payment.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var menuAdapter: MainMenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_main)

        menuAdapter = MainMenuAdapter{
            toast("${it.desc} clicked")
        }

        main_qr.setOnClickListener(this)
        main_notification.setOnClickListener(this)
        main_profile.setOnClickListener(this)
        main_history.setOnClickListener(this)
        main_transfer.setOnClickListener(this)
        main_withdraw.setOnClickListener(this)
        item_info_more.setOnClickListener(this)
        main_pickup_more.setOnClickListener(this)
        main_pickup_close.setOnClickListener(this)

        main_menu_rv.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            setHasFixedSize(true)
            adapter = menuAdapter
        }

        setData()
    }

    private fun setData() {
        val data = ArrayList<MenuData>()
        data.add(MenuData(R.drawable.ic_menu_transaction, "Transaksi\nNasabah"))
        data.add(MenuData(R.drawable.ic_menu_trash, "Jual\nSampah"))
        data.add(MenuData(R.drawable.ic_menu_category, "Kategori \nSampah"))
        data.add(MenuData(R.drawable.ic_menu_report, "Laporan\nSampah"))
        data.add(MenuData(R.drawable.ic_menu_contact, "Daftar Contact"))
        data.add(MenuData(R.drawable.ic_menu_organization, "Struktur\nPengurus"))
        data.add(MenuData(R.drawable.ic_menu_point, "Tukar Poin\nKompis"))
        data.add(MenuData(R.drawable.ic_menu_price, "Tabel Harga\nKompis"))
        menuAdapter.setData(data)
    }

    override fun onClick(v: View?) {
        when(v){
            main_qr ->{
                toast("QR")
            }
            main_notification ->{
                toast("Notification")
            }
            main_profile ->{
                toast("Profile")
            }
            main_history ->{
                toast("History")
            }
            main_transfer ->{
                toast("Transfer")
            }
            main_withdraw ->{
                toast("Withdraw")
            }
            item_info_more ->{
                toast("Info More")
            }
            main_pickup_more ->{
                toast("Pick Up More")
            }
            main_pickup_close ->{
                toast("Close")
            }
        }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}