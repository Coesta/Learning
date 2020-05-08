package com.leocoesta.testefullscreendialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class DialogoFragment : DialogFragment() {

    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dialogo, container, false)
        toolbar = view.findViewById(R.id.toolbar)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("onViewCreated")
        toolbar.setNavigationOnClickListener { dismiss() }
        toolbar.title = "Endereço"
        toolbar.inflateMenu(R.menu.menu_dialogo_endereco)
        toolbar.setOnMenuItemClickListener {
            dismiss()
            true
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val largura = ViewGroup.LayoutParams.MATCH_PARENT
            val altura = ViewGroup.LayoutParams.MATCH_PARENT

            it.window?.setLayout(largura, altura)
            it.window?.setWindowAnimations(R.style.AppTheme_Slide)
        }
    }

    override fun getTheme(): Int {
        return R.style.AppTheme_FullScreenDialog
    }

    fun exibir(manager: FragmentManager): DialogFragment {
        val dialogo = DialogoFragment()
        dialogo.show(manager, TAG)
        return dialogo
    }

    companion object {
        const val TAG = "DialogoFragment"
    }
}